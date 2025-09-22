package br.com.fiap.trackin.eventoMoto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/evento")
public class EventoMotoController {

    private final EventoMotoService eventoMotoService;

    public EventoMotoController(EventoMotoService eventoMotoService) {this.eventoMotoService = eventoMotoService;}

    @GetMapping
    public String index(Model model) {
        var eventos = eventoMotoService.getAllEventos();
        model.addAttribute("eventos", eventos);
        return "index";
    }
}
