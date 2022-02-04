package reparaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reparaciones.domain.Coche.DAO.CocheRepository;
import reparaciones.domain.Coche.Model.Coche;

@Controller
@RequestMapping("/coche")
public class CocheController {

    @Autowired
    private CocheRepository customerRepository;

    @GetMapping("/nuevo")
    public String nuevoCoche(Model model) {
        model.addAttribute("coche", new Coche());
        return "/coche/nuevoCoche";
    }

}
