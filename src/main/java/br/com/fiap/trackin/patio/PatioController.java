package br.com.fiap.trackin.patio;

import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.moto.Moto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return "patio";
    }

    @GetMapping("/formPatio")
    public String form(Model model){
        model.addAttribute("patio", new Patio());
        return "forms/formPatio";
    }

    @PostMapping("/formPatio")
    public String create(@Valid Patio patio, RedirectAttributes redirect ){ //session
        patioService.save(patio);
        redirect.addFlashAttribute("message", "patio cadastrado com sucesso!");
        return "redirect:/patio"; //301
    }


}
