package br.com.fiap.trackin.moto;

import br.com.fiap.trackin.enuns.TypesEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "placa não pode ser nula")
    private String placa;

    @NotBlank(message = "modelo não pode ser nulo")
    private String modelo;

    private Integer ano;

    @Enumerated(EnumType.STRING)
    private TypesEnum.StatusMoto statusMoto;

    @NotBlank(message = "RFID não pode ser nulo")
    private String rfidTag;

    private LocalDate dataAquisicao;

    private LocalDate ultimaManutencao;

    private String imagemReferencia;

    @Lob
    private String caracteristicasVisuais; //JSON da foto será como string

}
