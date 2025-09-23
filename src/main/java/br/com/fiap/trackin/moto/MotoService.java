package br.com.fiap.trackin.moto;

import br.com.fiap.trackin.patio.PatioRepository;
import br.com.fiap.trackin.patio.PatioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoService {

    private MotoRepository motoRepository;

    public MotoService(MotoRepository motoRepository){
        this.motoRepository=motoRepository;
    }

    public List<Moto> getAllMotos(){
        return motoRepository.findAll();
    }

    public Moto save(Moto moto) {
        return motoRepository.save(moto);
    }

}
