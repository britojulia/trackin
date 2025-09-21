package br.com.fiap.trackin.eventoMoto;

import java.util.List;

public class EventoMotoService {

    private final EventoMotoRepository eventoMotoRepository;

    public EventoMotoService(EventoMotoRepository eventoMotoRepository) {
        this.eventoMotoRepository = eventoMotoRepository;
    }

    public List<EventoMoto> getAllEventos(){
        return eventoMotoRepository.findAll();
    }
}
