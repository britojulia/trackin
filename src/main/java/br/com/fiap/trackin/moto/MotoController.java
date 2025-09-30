package br.com.fiap.trackin.moto;

import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.eventoMoto.EventoMoto;
import br.com.fiap.trackin.eventoMoto.EventoMotoService;
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
@RequestMapping("/moto")
@RequiredArgsConstructor
public class MotoController {

    private final MotoService motoService;
    private final EventoMotoService eventoMotoService;
    private final MessageSource messageSource;


    @GetMapping
    public String index(Model model) {
        var motos = motoService.getAllMotos();
        model.addAttribute("motos", motos);
        model.addAttribute("totalMotos", motoService.getAllMotos().size());
        model.addAttribute("emManutencao", motoService.contarMotosEmManutencao());
        model.addAttribute("totalEventos", eventoMotoService.getAllEventos().size());
        return "index";
    }

    @GetMapping("/formMoto")
    public String form(Model model){
        model.addAttribute("moto", new Moto());
        model.addAttribute("statusMoto", TypesEnum.StatusMoto.values());
        return "forms/formMoto";
    }

    @GetMapping("/formMoto/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Moto moto = motoService.getMoto(id);
        model.addAttribute("moto", moto);
        model.addAttribute("statusMoto", TypesEnum.StatusMoto.values());
        return "forms/formMoto";
    }

    @PostMapping("/formMoto")
    public String create(@Valid Moto moto, BindingResult result, RedirectAttributes redirect ){

        if(result.hasErrors()) return "formMoto";

        var message = messageSource.getMessage("message.success", null, LocaleContextHolder.getLocale());

        motoService.save(moto);
        redirect.addFlashAttribute("message", message);
        return "redirect:/moto"; //301
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirect ){
        motoService.deleteById(id);
        redirect.addFlashAttribute("message", "message.success");
        return "redirect:/moto";
    }

    @PutMapping("/manutencao/{id}")
    public String enviarManutencao(@PathVariable Long id, RedirectAttributes redirect) {
        motoService.statusManutencao(id);
        redirect.addFlashAttribute("message", "message.success");
        return "redirect:/moto";
    }

    @PutMapping("/disponivel/{id}")
    public String enviarDisponivel(@PathVariable Long id, RedirectAttributes redirect) {
        motoService.statusDisponivel(id);
        redirect.addFlashAttribute("message", "message.success");
        return "redirect:/moto";
    }

    @PutMapping("/alugada/{id}")
    public String enviarAlugada(@PathVariable Long id, RedirectAttributes redirect) {
        motoService.statusAlugada(id);
        redirect.addFlashAttribute("message", "message.success");
        return "redirect:/moto";
    }



}
