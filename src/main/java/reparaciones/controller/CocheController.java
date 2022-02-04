package reparaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reparaciones.domain.Coche.DAO.CocheRepository;
import reparaciones.domain.Coche.Model.Coche;
import reparaciones.domain.Customer.DAO.CustomerRepository;
import reparaciones.domain.Customer.Model.Customer;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/coche")
public class CocheController {

    String error;

    @Autowired
    private CocheRepository cocheRepository;
    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/nuevo")
    public String nuevoCoche(Model model) {
        model.addAttribute("coche", new Coche());
        return "/coche/nuevoCoche";
    }

    @PostMapping("/crearCoche")
    public String processRegisterCustomer(
            @Valid @ModelAttribute("coche") Coche cocheBD,
            BindingResult bindingResult) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = user.getUsername();
        Optional<Customer> customer = customerRepository.findByUsername(userName);
        if (customer.isPresent()) {
            Customer c = customer.get();
            cocheBD.setDueño(c);
        }

        cocheRepository.save(cocheBD);
        return "index";
    }

}
