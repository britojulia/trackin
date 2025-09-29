package br.com.fiap.trackin.zonaPatio;

import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.moto.Moto;
import br.com.fiap.trackin.patio.Patio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/zonaPatio")
@RequiredArgsConstructor
public class ZonaPatioController {

    private final ZonaPatioService zonaPatioService;

    @GetMapping
    public String index(Model model) {
        var zonas = zonaPatioService.getAllZonaPatios();
        model.addAttribute("zonas", zonas);
        return "zonaPatio";
    }

    @GetMapping("/formZona")
    public String form(Model model){
        model.addAttribute("zona", new ZonaPatio());
        return "forms/formZona";
    }

    @GetMapping("/formZona/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        ZonaPatio zonaPatio = zonaPatioService.getZona(id);
        model.addAttribute("zonaPatio", zonaPatio);
        return "forms/formZona";
    }

    @PostMapping("/formZona")
    public String create(@Valid ZonaPatio zonaPatio, RedirectAttributes redirect ){ //session
        zonaPatioService.save(zonaPatio);
        redirect.addFlashAttribute("message", "zona do patio cadastrada com sucesso!");
        return "redirect:/zonaPatio"; //301
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect ){
        zonaPatioService.deleteById(id);
        redirect.addFlashAttribute("message", "Patio deletado com sucesso!");
        return "redirect:/zonaPatio";
    }
}
