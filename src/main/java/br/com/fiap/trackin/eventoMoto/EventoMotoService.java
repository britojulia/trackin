package br.com.fiap.trackin.eventoMoto;

import br.com.fiap.trackin.config.MessageHelper;
import br.com.fiap.trackin.moto.Moto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventoMotoService {

    private final EventoMotoRepository eventoMotoRepository;
    private final MessageHelper messageHelper;

    public EventoMotoService(EventoMotoRepository eventoMotoRepository, MessageHelper messageHelper) {
        this.eventoMotoRepository = eventoMotoRepository;
        this.messageHelper = messageHelper;
    }

    public List<EventoMoto> getAllEventos(){
        return eventoMotoRepository.findAll();
    }

    public EventoMoto save(EventoMoto eventoMoto) {
        return eventoMotoRepository.save(eventoMoto);
    }

    public void deleteById(Long id){
        eventoMotoRepository.delete(getEvento(id));
    }


    public EventoMoto getEvento(Long id){
        return eventoMotoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(messageHelper.get("message.notFound"))
        );
    }
}
