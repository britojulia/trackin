package br.com.fiap.trackin.patio;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
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
public class Patio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{patio.nome.notblank}")
    private String nome;

    @NotBlank(message = "{patio.endereco.notblank}")
    private String endereco;

    @Min(value = 10, message = "{patio.capacidade.min}")
    private Integer capacidadeMaxima;

    private String cidade;

    private String estado;

    @NotBlank(message = "patio.pais.notblank")
    private String pais; //brasil ou mexico

    private Double dimensaoX; //largura em metros

    private Double dimensaoY; //cumprimento em metros
}


