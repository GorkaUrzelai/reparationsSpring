package reparaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import reparaciones.ReparationscalendarApplication;
import reparaciones.domain.Authority.Authority;
import reparaciones.domain.Customer.DAO.CustomerRepository;
import reparaciones.domain.Customer.Model.Customer;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
public class AppController {

    String error;

    @Autowired //inject the customerRepository bean
    private CustomerRepository customerRepository;

    @GetMapping({"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping({"/home"})
    public String index() {
        return "index";
    }

    @GetMapping({"/perfil"})
    public String perfil(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = user.getUsername();
        Optional<Customer> customer = customerRepository.findByUsername(userName);
        Customer c = null;
        if (customer.isPresent()) {
            c = customer.get();
        }
        model.addAttribute("customer", c);
        return "perfil";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("customer", new Customer());
        return "register";
    }


    @PostMapping("/process_register")
    public String processRegisterCustomer(Model model, Customer customerApp,
                                          @Valid @ModelAttribute("customer") Customer customerDB,
                                          BindingResult bindingResult) {
        error = null;
        if (bindingResult.hasErrors() || existeUsuarioConEseUsername(customerDB)) {
            if (existeUsuarioConEseUsername(customerDB)) error = "usuario duplicado";
            if (bindingResult.hasErrors()) error = "error creando el usuario";
            model.addAttribute("error", error);
            if (existeUsuarioConEseUsername(customerDB)) ReparationscalendarApplication.log.warn("usuario repetido");
            if (bindingResult.hasErrors()) ReparationscalendarApplication.log.warn("ha fallado el registro");

            return "register";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(customerDB.getPassword());
        customerDB.setPassword(encodedPassword);
        customerApp.setUsername(customerDB.getUsername());
        customerApp.setPassword(customerDB.getPassword());
        /*customerApp.setFirstName(customerDB.getFirstName());
        customerApp.setEmail(customerDB.getEmail());*/
        customerApp.setEnabled(true);
        customerApp.setAuthority(getAuthority(customerRepository, "customer"));
        saveCus(customerDB);
        customerRepository.save(customerApp);
        error = "registro correcto";
        model.addAttribute("error", error);
        return "login";
    }

    @CacheEvict(value = "customers", beforeInvocation = true)
    public void saveCus(Customer customer) {
        try {
            customerRepository.save(customer);
        } catch (EntityExistsException e) {

        }
    }

    public boolean existeUsuarioConEseUsername(@Valid Customer customer) {

        boolean existe = false;

        Optional<Customer> username = customerRepository.findByUsername(customer.getUsername());

        if (username.isPresent()) {
            existe = true;
        } else existe = false;

        return existe;
    }

    public static Set<Authority> getAuthority(CustomerRepository userRepo, String auth) {


        Optional<Customer> user_customer_opt = userRepo.findByUsername("admin");
        if (user_customer_opt.isPresent()) {
            Customer customer_customer = user_customer_opt.get();
        }


        Set<Authority> auth_user = new HashSet<Authority>();
        Optional<Customer> user_opt;
        Customer customer;
        switch (auth) {
            case "customer":
                user_opt = userRepo.findByUsername("customer");
                if (user_opt.isPresent()) {
                    customer = user_opt.get();
                    auth_user.addAll(customer.getAuthority());
                }
                break;
        }
        return auth_user;
    }

}
