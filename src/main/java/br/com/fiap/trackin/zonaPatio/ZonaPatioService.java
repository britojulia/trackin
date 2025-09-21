package br.com.fiap.trackin.zonaPatio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZonaPatioService {

    private final ZonaPatioRepository zonaPatioRepository;

    public ZonaPatioService(ZonaPatioRepository zonaPatioRepository) {
        this.zonaPatioRepository = zonaPatioRepository;
    }

    public List<ZonaPatio> getAllZonaPatios() {
        return zonaPatioRepository.findAll();
    }
}
