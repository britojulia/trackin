package br.com.fiap.trackin.moto;

import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.eventoMoto.EventoMotoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/moto")
@RequiredArgsConstructor
public class MotoController {

    private final MotoService motoService;

    @GetMapping
    public String index(Model model) {
        var motos = motoService.getAllMotos();
        model.addAttribute("motos", motos);
        return "index";
    }

    @GetMapping("/formMoto")
    public String form(Model model){
        model.addAttribute("moto", new Moto());
        model.addAttribute("statusMotos", TypesEnum.StatusMoto.values());
        return "forms/formMoto";
    }

    @PostMapping("/formMoto")
    public String create(@Valid Moto moto, RedirectAttributes redirect ){ //session
        motoService.save(moto);
        redirect.addFlashAttribute("message", "moto cadastrada com sucesso!");
        return "redirect:/moto"; //301
    }


}
