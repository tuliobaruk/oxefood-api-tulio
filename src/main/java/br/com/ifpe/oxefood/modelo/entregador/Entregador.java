package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import org.hibernate.annotations.SQLRestriction;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Entregador")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel {
    @Column
    private String nome;
    
    @Column
    private String cpf;

    @Column
    private String rg;

    @Column
    private LocalDate dataNascimento;

    @Column
    private String foneCelular;

    @Column
    private String foneFixo;

    @Column
    private Integer qtdEntregasRealizadas;
    
    @Column
    private Double valorFrete;

    @Column
    private Boolean ativo;
}
