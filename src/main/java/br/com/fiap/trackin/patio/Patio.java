package br.com.fiap.trackin.patio;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @NotBlank(message = "nome do pátio não pode ser nulo")
    private String nome;

    @NotBlank(message = "Endereço não pode ser nulo")
    private String endereco;

    @NotNull(message = "Capacidade máxima do pátio não pode ser nula")
    private Integer capacidadeMaxima;

    private String cidade;

    private String estado;

    @NotBlank(message = "Oaís não pode ser nulo")
    private String pais; //brasil ou mexico

    private Double dimensaoX; //largura em metros

    private Double dimensaoY; //cumprimento em metros

}
