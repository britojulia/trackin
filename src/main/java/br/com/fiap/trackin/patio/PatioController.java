package br.com.fiap.trackin.patio;

import br.com.fiap.trackin.moto.MotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
@RequestMapping("/patio")
@RequiredArgsConstructor
public class PatioController {

    private final PatioService patioService;
    private final MotoService motoService;
    private final MessageSource messageSource;

    @GetMapping
    public String index(Model model) {
        var patios = patioService.getAllPatios();
        Map<Long, Long> motosPorPatio = motoService.contarMotosPorPatio();
        model.addAttribute("motosPorPatio", motosPorPatio);
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
    public String create(@Valid Patio patio, BindingResult result, RedirectAttributes redirect ){
        if(result.hasErrors()) return "formPatio";

        var message = messageSource.getMessage("message.success", null, LocaleContextHolder.getLocale());
        patioService.save(patio);
        redirect.addFlashAttribute("message", message);
        return "redirect:/patio";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect ){
        patioService.deleteById(id);
        redirect.addFlashAttribute("message", "Patio deletado com sucesso!");
        return "redirect:/patio";
    }


}
