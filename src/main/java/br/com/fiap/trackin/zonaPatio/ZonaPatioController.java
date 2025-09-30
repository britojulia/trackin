package br.com.fiap.trackin.zonaPatio;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/zonaPatio")
@RequiredArgsConstructor
public class ZonaPatioController {

    private final ZonaPatioService zonaPatioService;
    private final MessageSource messageSource;

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user) {
        var zonas = zonaPatioService.getAllZonaPatios();
        model .addAttribute("user", user);
        model.addAttribute("zonas", zonas);
        return "zonaPatio";
    }

    @GetMapping("/formZona")
    public String form(Model model, @AuthenticationPrincipal OAuth2User user ){
        model.addAttribute("zona", new ZonaPatio());
        model.addAttribute("user", user);
        return "forms/formZona";
    }

    @GetMapping("/formZona/{id}")
    public String editForm(@PathVariable Long id,  @AuthenticationPrincipal OAuth2User user, Model model) {
        ZonaPatio zona = zonaPatioService.getZona(id);
        model.addAttribute("user", user);
        model.addAttribute("zona", zona);
        return "forms/formZona";
    }

    @PostMapping("/formZona")
    public String create(@Valid ZonaPatio zonaPatio, BindingResult result, RedirectAttributes redirect ){

        if(result.hasErrors()) return "formZona";

        var message = messageSource.getMessage("message.success", null, LocaleContextHolder.getLocale());
        zonaPatioService.save(zonaPatio);
        redirect.addFlashAttribute("message", message);
        return "redirect:/zonaPatio"; //301
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect ){
        var message = messageSource.getMessage("message.success", null, LocaleContextHolder.getLocale());
        zonaPatioService.deleteById(id);
        redirect.addFlashAttribute("message", message);
        return "redirect:/zonaPatio";
    }
}
