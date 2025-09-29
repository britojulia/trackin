package br.com.fiap.trackin.eventoMoto;

import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.moto.Moto;
import br.com.fiap.trackin.moto.MotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/evento")
@RequiredArgsConstructor
public class EventoMotoController {

    private final EventoMotoService eventoMotoService;

    @GetMapping
    public String index(Model model) {
        var eventos = eventoMotoService.getAllEventos();
        model.addAttribute("eventos", eventos);
        return "evento";
    }


    @GetMapping("/formEvento")
    public String form(Model model){
        model.addAttribute("evento", new EventoMoto());
        model.addAttribute("fonteEvento", TypesEnum.FonteEvento.values());
        return "forms/formEvento";
    }

    @PostMapping("/formEvento")
    public String create(@Valid EventoMoto eventoMoto, RedirectAttributes redirect ){ //session
        eventoMotoService.save(eventoMoto);
        redirect.addFlashAttribute("message", "Novo evento cadastrado com sucesso!");
        return "redirect:/evento"; //301
    }
}
