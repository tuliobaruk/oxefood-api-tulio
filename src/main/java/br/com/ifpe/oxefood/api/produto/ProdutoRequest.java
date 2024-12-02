package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRequest {
    
    @NotNull(message = "O campo idCategoria é de preenchimento obrigatório")
    private Long idCategoria;

    @NotBlank(message = "O campo codigo é de preenchimento obrigatório")
    private String codigo;

    @NotBlank(message = "O campo titulo é de preenchimento obrigatório")
    private String titulo;

    private String descricao;

    @NotNull(message = "O campo valorUnitario é de preenchimento obrigatório")
    private Double valorUnitario;

    private Integer tempoEntregaMinimo;

    private Integer tempoEntregaMaximo;

    public Produto build() {

        return Produto.builder()
                .codigo(codigo)
                .titulo(titulo)
                .descricao(descricao)
                .valorUnitario(valorUnitario)
                .tempoEntregaMinimo(tempoEntregaMinimo)
                .tempoEntregaMaximo(tempoEntregaMaximo)
                .build();
    }
}
