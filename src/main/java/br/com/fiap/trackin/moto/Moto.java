package br.com.fiap.trackin.moto;

import br.com.fiap.trackin.enuns.TypesEnum;
import br.com.fiap.trackin.eventoMoto.EventoMoto;
import br.com.fiap.trackin.patio.Patio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "eventos")
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{moto.placa.notblank}")
    private String placa;

    @NotNull(message = "motoZona.patio.notnull")
    @ManyToOne
    @JoinColumn(name = "patio_id")
    private Patio patio;

    @NotBlank(message = "{moto.modelo.notblank}")
    private String modelo;

    private Integer ano;

    @Enumerated(EnumType.STRING)
    private TypesEnum.StatusMoto statusMoto;

    @NotBlank(message = "{moto.rfidTag.notblank}")
    private String rfidTag;

    private LocalDate dataAquisicao;

    private LocalDate ultimaManutencao;

    private String imagemReferencia;

    @Lob
    private String caracteristicasVisuais; //JSON da foto será como string

    @OneToMany(mappedBy = "moto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EventoMoto> eventos = new ArrayList<>();

}

