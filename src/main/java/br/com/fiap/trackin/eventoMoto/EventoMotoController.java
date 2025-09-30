package br.com.fiap.trackin.eventoMoto;

import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.moto.Moto;
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

@Controller
@RequestMapping("/evento")
@RequiredArgsConstructor
public class EventoMotoController {

    private final EventoMotoService eventoMotoService;

    private final MessageSource messageSource;

    @GetMapping
    public String index(Model model) {
        var eventos = eventoMotoService.getAllEventos();
        model.addAttribute("eventos", eventos);
        model.addAttribute("totalEventos", eventos.size());
        model.addAttribute("ultimoEvento", eventos.isEmpty() ? null : eventos.get(0));
        return "evento";
    }


    @GetMapping("/formEvento")
    public String form(Model model){
        model.addAttribute("evento", new EventoMoto());
        model.addAttribute("fonteEvento", TypesEnum.FonteEvento.values());
        return "forms/formEvento";
    }

    @GetMapping("/formEvento/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        EventoMoto evento = eventoMotoService.getEvento(id);
        model.addAttribute("evento", evento);
        model.addAttribute("fonteEvento", TypesEnum.FonteEvento.values());
        return "forms/formEvento";
    }

    @PostMapping("/formEvento")
    public String create(@Valid EventoMoto eventoMoto, BindingResult result, RedirectAttributes redirect ){

        if(result.hasErrors()) return "formEvento";

        var message = messageSource.getMessage("message.success", null, LocaleContextHolder.getLocale());
        eventoMotoService.save(eventoMoto);
        redirect.addFlashAttribute("message", message);
        return "redirect:/evento";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect ){
        var message = messageSource.getMessage("message.success", null, LocaleContextHolder.getLocale());
        eventoMotoService.deleteById(id);
        redirect.addFlashAttribute("message", message);
        return "redirect:/evento";
    }
}
