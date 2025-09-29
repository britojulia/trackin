package br.com.fiap.trackin.patio;

import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.moto.Moto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/patio")
@RequiredArgsConstructor
public class PatioController {

    private final PatioService patioService;

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

    @GetMapping("/formPatio/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Patio patio = patioService.getPatio(id);
        model.addAttribute("patio", patio);
        return "forms/formPatio";
    }

    @PostMapping("/formPatio")
    public String create(@Valid Patio patio, RedirectAttributes redirect ){ //session
        patioService.save(patio);
        redirect.addFlashAttribute("message", "patio cadastrado com sucesso!");
        return "redirect:/patio"; //301
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect ){
        patioService.deleteById(id);
        redirect.addFlashAttribute("message", "Patio deletado com sucesso!");
        return "redirect:/patio";
    }


}
