package br.com.fiap.trackin.eventoMoto;

import br.com.fiap.trackin.enuns.TypesEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Tipo de veento não pode ser nulo")
    private String tipo; //tipo de evento - entrada, saída, manutenção etc

    private LocalDateTime timesTamp;

    private String observacao;

    @NotBlank(message = "fonte do evento não pode ser nulo")
    @Enumerated(EnumType.STRING)
    private TypesEnum.FonteEvento fonteEvento; //Sistema, Manual, VisaoComputacional, RFID

}
