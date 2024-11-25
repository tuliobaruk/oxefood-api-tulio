package br.com.ifpe.oxefood.modelo.produto;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto){

        produto.setHabilitado(Boolean.TRUE);
        produto.setVersao(1L);
        produto.setDataCriacao(LocalDate.now());
        return repository.save(produto);
    }

    public List<Produto> listarTodos(){
        return repository.findAll();
    }

    public Produto obterPorId(Long id){
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado){
        Produto produto = repository.findById(id).get();
        produto.setCategoria(produtoAlterado.getCategoria());
        produto.setCodigo(produtoAlterado.getCodigo());
        produto.setTitulo(produtoAlterado.getTitulo());
        produto.setDescricao(produtoAlterado.getDescricao());
        produto.setValorUnitario(produtoAlterado.getValorUnitario());
        produto.setTempoEntregaMinimo(produtoAlterado.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(produtoAlterado.getTempoEntregaMaximo());
    }

    @Transactional
    public void delete(Long id){
        Produto produto = repository.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);
        
        repository.save(produto);
    }
}
