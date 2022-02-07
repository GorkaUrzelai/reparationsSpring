package reparaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reparaciones.domain.Coche.DAO.CocheRepository;
import reparaciones.domain.Coche.Model.Coche;
import reparaciones.domain.Customer.DAO.CustomerRepository;
import reparaciones.domain.Customer.Model.Customer;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired //inject the customerRepository bean
    private CustomerRepository customerRepository;

    @Autowired
    private CocheRepository cocheRepository;

    @GetMapping({"/coches"})
    public String coches(Model model) {


        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = user.getUsername();
        Optional<Customer> customer = customerRepository.findByUsername(userName);
        Customer c = customer.get();
        int customerId = c.getId();
        List<Coche> coches = cocheRepository.getCoches(customerId);

        model.addAttribute("coches", coches);
        return "coche/coches";
    }
}
