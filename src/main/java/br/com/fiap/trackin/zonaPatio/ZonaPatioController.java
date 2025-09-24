package br.com.fiap.trackin.zonaPatio;

import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.moto.Moto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/formZona")
    public String form(Model model){
        model.addAttribute("zona", new ZonaPatio());
        return "forms/formZona";
    }

    @PostMapping("/formMoto")
    public String create(ZonaPatio zonaPatio, RedirectAttributes redirect ){ //session
        zonaPatioService.save(zonaPatio);
        redirect.addFlashAttribute("message", "zona do patio cadastrada com sucesso!");
        return "redirect:/zonaPAtio"; //301
    }
}
