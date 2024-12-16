package br.com.ifpe.oxefood.modelo.produto;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.ifpe.oxefood.util.exception.EntidadeNaoEncontradaException;
import br.com.ifpe.oxefood.util.exception.ProdutoException;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private CategoriaProdutoRepository categoriaProdutoRepository;

    @Transactional
    public Produto save(Produto produto, Long categoriaId) {

        if (produto.getValorUnitario() < 10) {
            throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
        }

        Optional<CategoriaProduto> consultaCategoria = categoriaProdutoRepository.findById(categoriaId);

        if (!consultaCategoria.isPresent()) {
            throw new EntidadeNaoEncontradaException("categoriaProduto", produto.getCategoria().getId());
        }

        
        produto.setCategoria(categoriaProdutoRepository.findById(categoriaId).get());
        produto.setHabilitado(Boolean.TRUE);
        produto.setVersao(1L);
        produto.setDataCriacao(LocalDate.now());
        return repository.save(produto);
    }

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto obterPorId(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Produto produtoAlterado) {
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
    public void delete(Long id) {
        Produto produto = repository.findById(id).get();
        produto.setHabilitado(Boolean.FALSE);

        repository.save(produto);
    }
}
