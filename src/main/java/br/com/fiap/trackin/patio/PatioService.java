package br.com.fiap.trackin.patio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatioService {
    private final PatioRepository patioRepository;

    public PatioService(PatioRepository patioRepository) {
        this.patioRepository = patioRepository;
    }

    public List<Patio> getAllPatios() {
        return patioRepository.findAll();
    }
}
