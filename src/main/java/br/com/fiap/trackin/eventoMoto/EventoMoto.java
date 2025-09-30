package br.com.fiap.trackin.eventoMoto;

import br.com.fiap.trackin.enuns.TypesEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventoMoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{evento.tipo.notblank}")
    private String tipo; //tipo de evento - entrada, saída, manutenção etc

    private LocalDateTime timesTamp;

    private String observacao;

    @NotNull(message = "{evento.fonteEvento.notnull}")
    @Enumerated(EnumType.STRING)
    private TypesEnum.FonteEvento fonteEvento; //Sistema, Manual, VisaoComputacional, RFID
}

