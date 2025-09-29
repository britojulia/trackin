package br.com.fiap.trackin.patio;

import br.com.fiap.trackin.moto.Moto;
import jakarta.persistence.EntityNotFoundException;
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

    public Patio save(Patio patio) {
        return patioRepository.save(patio);
    }

    public void deleteById(Long id){
        patioRepository.delete(getPatio(id));
    }

    public Patio getPatio(Long id){
        return patioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("patio não encontrada")
        );
    }
}
