package br.com.fiap.trackin.eventoMoto;

import br.com.fiap.trackin.moto.Moto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoMotoService {

    private final EventoMotoRepository eventoMotoRepository;

    public EventoMotoService(EventoMotoRepository eventoMotoRepository) {
        this.eventoMotoRepository = eventoMotoRepository;
    }

    public List<EventoMoto> getAllEventos(){
        return eventoMotoRepository.findAll();
    }

    public EventoMoto save(EventoMoto eventoMoto) {
        return eventoMotoRepository.save(eventoMoto);
    }
}
