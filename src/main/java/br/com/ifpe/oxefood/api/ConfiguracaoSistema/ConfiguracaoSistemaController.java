package br.com.ifpe.oxefood.api.ConfiguracaoSistema;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.ConfiguracaoSistema.ConfiguracaoSistema;
import br.com.ifpe.oxefood.modelo.ConfiguracaoSistema.ConfiguracaoSistemaService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/configuracaoSistema")
@CrossOrigin
public class ConfiguracaoSistemaController {
    @Autowired
    private ConfiguracaoSistemaService configuracaoSistemaService;

    @PostMapping
    public ResponseEntity<ConfiguracaoSistema> save(@RequestBody ConfiguracaoSistemaRequest request) {
        ConfiguracaoSistema configuracaoSistema = configuracaoSistemaService.save(request.build());
        return new ResponseEntity<ConfiguracaoSistema>(configuracaoSistema, HttpStatus.CREATED);
    }

    @GetMapping()
    public List<ConfiguracaoSistema> listarTodos() {
        return configuracaoSistemaService.listarTodos();
    }

    @GetMapping("/{id}")
    public ConfiguracaoSistema obterPorId(@PathVariable Long id) {
        return configuracaoSistemaService.obterPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConfiguracaoSistema> update(@PathVariable("id") long id, @RequestBody ConfiguracaoSistemaRequest request) {
        configuracaoSistemaService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        configuracaoSistemaService.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
