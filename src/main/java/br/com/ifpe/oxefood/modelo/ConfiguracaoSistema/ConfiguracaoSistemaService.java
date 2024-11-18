package br.com.ifpe.oxefood.modelo.ConfiguracaoSistema;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class ConfiguracaoSistemaService {
    @Autowired
    private ConfiguracaoSistemaRepository repository;

    @Transactional
    public ConfiguracaoSistema save(ConfiguracaoSistema configuracaoSistema){
        configuracaoSistema.setHabilitado(true);
        configuracaoSistema.setVersao(1L);
        configuracaoSistema.setDataCriacao(LocalDate.now());
        return repository.save(configuracaoSistema);
    }

    public List<ConfiguracaoSistema> listarTodos(){
        return repository.findAll();
    }

    public ConfiguracaoSistema obterPorId(Long id){
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, ConfiguracaoSistema configuracaoSistemaAlterado){
        ConfiguracaoSistema configuracaoSistema = repository.findById(id).get();
        configuracaoSistema.setNomeEmpresa(configuracaoSistemaAlterado.getNomeEmpresa());
        configuracaoSistema.setCnpj(configuracaoSistemaAlterado.getCnpj());
        configuracaoSistema.setSite(configuracaoSistemaAlterado.getSite());
        configuracaoSistema.setEmailContato(configuracaoSistemaAlterado.getEmailContato());
        configuracaoSistema.setTempoMinimoAgendamentoPedidos(configuracaoSistemaAlterado.getTempoMinimoAgendamentoPedidos());
        configuracaoSistema.setLigarAceitePedidos(configuracaoSistemaAlterado.getLigarAceitePedidos());
        configuracaoSistema.setDataEntradaSistema(configuracaoSistemaAlterado.getDataEntradaSistema());
    }

    @Transactional
    public void delete(Long id){
        ConfiguracaoSistema configuracaoSistema = repository.findById(id).get();
        configuracaoSistema.setHabilitado(Boolean.FALSE);

        repository.save(configuracaoSistema);
    }
}
