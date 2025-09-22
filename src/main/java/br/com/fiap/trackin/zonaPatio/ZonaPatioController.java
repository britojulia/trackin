package br.com.fiap.trackin.zonaPatio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/zona")
public class ZonaPatioController {

    private final ZonaPatioService zonaPatioService;


    public ZonaPatioController(ZonaPatioService zonaPatioService) {
        this.zonaPatioService = zonaPatioService;
    }

    @GetMapping
    public String index(Model model) {
        var zonas = zonaPatioService.getAllZonaPatios();
        model.addAttribute("zonas", zonas);
        return "index";
    }
}
