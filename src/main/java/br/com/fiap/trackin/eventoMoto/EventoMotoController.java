package br.com.fiap.trackin.eventoMoto;

import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.moto.Moto;
import br.com.fiap.trackin.moto.MotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/evento")
public class EventoMotoController {

    private final EventoMotoService eventoMotoService;
    private final MotoService motoService;

    public EventoMotoController(EventoMotoService eventoMotoService, MotoService motoService) {this.eventoMotoService = eventoMotoService;
        this.motoService = motoService;
    }


    @GetMapping
    public String index(Model model) {
        var eventos = eventoMotoService.getAllEventos();
        model.addAttribute("eventos", eventos);
        return "index";
    }

    @GetMapping("/formEvento")
    public String form(Model model){
        model.addAttribute("eventMoto", new EventoMoto());
        model.addAttribute("fonteEvento", TypesEnum.FonteEvento.values());
        return "forms/formMoto";
    }

    @PostMapping("/formEvento")
    public String create(EventoMoto eventoMoto, RedirectAttributes redirect ){ //session
        eventoMotoService.save(eventoMoto);
        redirect.addFlashAttribute("message", "Novo evento cadastrado com sucesso!");
        return "redirect:/eventoMoto"; //301
    }
}
