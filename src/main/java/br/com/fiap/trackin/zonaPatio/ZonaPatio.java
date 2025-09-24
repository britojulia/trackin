package br.com.fiap.trackin.zonaPatio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
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

    private Double coordenadaInicialX;

    private Double coordenadaInicialY;

    private Double coordenadaFinalX;

    private Double coordenadaFinalY;

    private String cor; //representação visual por cor
}
