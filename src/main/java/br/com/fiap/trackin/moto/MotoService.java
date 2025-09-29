package br.com.fiap.trackin.moto;

import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.eventoMoto.EventoMoto;
import br.com.fiap.trackin.eventoMoto.EventoMotoService;
import br.com.fiap.trackin.patio.PatioRepository;
import br.com.fiap.trackin.patio.PatioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MotoService {

    private MotoRepository motoRepository;
    private EventoMotoService eventoMotoService;

    public MotoService(MotoRepository motoRepository, EventoMotoService eventoMotoService){
        this.motoRepository=motoRepository;
        this.eventoMotoService = eventoMotoService;
    }

    public List<Moto> getAllMotos(){
        return motoRepository.findAll();
    }

    public Moto save(Moto moto) {
        return motoRepository.save(moto);
    }

    public void deleteById(Long id){
        motoRepository.delete(getMoto(id));
    }

    public void statusManutencao(Long id) {
        Moto moto = getMoto(id);
        moto.setStatusMoto(TypesEnum.StatusMoto.EM_MANUTENCAO);
        motoRepository.save(moto);
        EventoMoto evento = EventoMoto.builder()
                .tipo("Manutenção")
                .timesTamp(LocalDateTime.now())
                .observacao("Moto enviada para manutenção")
                .fonteEvento(TypesEnum.FonteEvento.SISTEMA)
                .build();
        eventoMotoService.save(evento);
    }

    public void statusDisponivel(Long id) {
        Moto moto = getMoto(id);
        moto.setStatusMoto(TypesEnum.StatusMoto.DISPONIVEL);
        motoRepository.save(moto);
        EventoMoto evento = EventoMoto.builder()
                .tipo("Disponivel")
                .timesTamp(LocalDateTime.now())
                .observacao("Moto disponivel")
                .fonteEvento(TypesEnum.FonteEvento.SISTEMA)
                .build();
        eventoMotoService.save(evento);
    }

    public void statusAlugada(Long id) {
        Moto moto = getMoto(id);
        moto.setStatusMoto(TypesEnum.StatusMoto.ALUGADA);
        motoRepository.save(moto);
        EventoMoto evento = EventoMoto.builder()
                .tipo("Alugada")
                .timesTamp(LocalDateTime.now())
                .observacao("Moto alugada")
                .fonteEvento(TypesEnum.FonteEvento.SISTEMA)
                .build();
        eventoMotoService.save(evento);
    }

    public Moto getMoto(Long id){
        return motoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("moto não encontrada")
        );
    }

}
