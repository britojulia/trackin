package br.com.fiap.trackin.zonaPatio;

import br.com.fiap.trackin.patio.Patio;
import jakarta.persistence.EntityNotFoundException;
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

    public ZonaPatio save(ZonaPatio zonaPatio) {
        return zonaPatioRepository.save(zonaPatio);
    }

    public void deleteById(Long id){
        zonaPatioRepository.delete(getZona(id));
    }

    public ZonaPatio getZona(Long id){
        return zonaPatioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("zona de patio não encontrada")
        );
    }
}
