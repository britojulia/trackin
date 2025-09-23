package br.com.fiap.trackin.eventoMoto;

import br.com.fiap.trackin.moto.MotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
