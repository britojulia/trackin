package br.com.fiap.trackin.eventoMoto;

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
}
