package br.com.fiap.trackin.eventoMoto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoMotoRepository extends JpaRepository<EventoMoto,Long> {
    List<EventoMoto> findByMotoId(Long motoId);
}
