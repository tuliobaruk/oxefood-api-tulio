package br.com.ifpe.oxefood.modelo.ConfiguracaoSistema;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import java.time.LocalDate;
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
@Table(name = "ConfiguracaoSistema")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConfiguracaoSistema extends EntidadeAuditavel {
    @Column
    private String nomeEmpresa;
    @Column
    private String cnpj;
    @Column
    private String site;
    @Column
    private String emailContato;
    @Column
    private Long tempoMinimoAgendamentoPedidos;
    @Column
    private Boolean ligarAceitePedidos;
    @Column
    private LocalDate dataEntradaSistema;
}
