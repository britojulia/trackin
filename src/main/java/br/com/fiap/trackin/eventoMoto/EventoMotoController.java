package br.com.fiap.trackin.eventoMoto;

import br.com.fiap.trackin.config.MessageHelper;
import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.user.UserService;
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
@RequestMapping("/evento")
@RequiredArgsConstructor
public class EventoMotoController {

    private final EventoMotoService eventoMotoService;
    private final MessageHelper messageHelper;
    private final MessageSource messageSource;

    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user ) {
        var eventos = eventoMotoService.getAllEventos();
        model.addAttribute("user", user);
        model.addAttribute("eventos", eventos);
        model.addAttribute("totalEventos", eventos.size());
        model.addAttribute("ultimoEvento", eventos.isEmpty() ? null : eventos.get(0));
        return "evento";
    }


    @GetMapping("/formEvento")
    public String form(Model model,  @AuthenticationPrincipal OAuth2User user){
        model.addAttribute("evento", new EventoMoto());
        model.addAttribute("user", user);
        model.addAttribute("fonteEvento", TypesEnum.FonteEvento.values());
        return "forms/formEvento";
    }

    @GetMapping("/formEvento/{id}")
    public String editForm(@PathVariable Long id,@AuthenticationPrincipal OAuth2User user, Model model) {
        EventoMoto evento = eventoMotoService.getEvento(id);
        model.addAttribute("user", user);
        model.addAttribute("evento", evento);
        model.addAttribute("fonteEvento", TypesEnum.FonteEvento.values());
        return "forms/formEvento";
    }

    @PostMapping("/formEvento")
    public String create(@Valid EventoMoto eventoMoto, BindingResult result, RedirectAttributes redirect ){

        if(result.hasErrors()) return "forms/formEvento";
        eventoMotoService.save(eventoMoto);

        redirect.addFlashAttribute("message", messageHelper.get("message.success"));
        return "redirect:/evento";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect ){
        eventoMotoService.deleteById(id);

        redirect.addFlashAttribute("message", messageHelper.get("message.delete.success"));
        return "redirect:/evento";
    }
}
