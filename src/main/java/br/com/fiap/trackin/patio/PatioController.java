package br.com.fiap.trackin.patio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/patio")
public class PatioController {


    private final PatioService patioService;

    public PatioController( PatioService patioService) {
        this.patioService = patioService;
    }

    @GetMapping
    public String index(Model model) {
        var patios = patioService.getAllPatios();
        model.addAttribute("patios", patios);
        return "index";
    }
}
