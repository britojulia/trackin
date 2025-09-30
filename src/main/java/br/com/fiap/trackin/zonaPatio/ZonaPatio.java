package br.com.fiap.trackin.zonaPatio;

import br.com.fiap.trackin.patio.Patio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZonaPatio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome da zona do pátio não pode ser nulo")
    private String nome; //Manutenção, Estacionamento, Lavagem, etc

    @ManyToOne
    @NotNull
    @JoinColumn(name = "patio_id", nullable = false)
    private Patio patio;

    private Double coordenadaInicialX;

    private Double coordenadaInicialY;

    private Double coordenadaFinalX;

    private Double coordenadaFinalY;

    private String cor; //representação visual por cor
}
