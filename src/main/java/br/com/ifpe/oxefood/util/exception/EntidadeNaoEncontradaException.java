package br.com.ifpe.oxefood.util.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaException extends RuntimeException {
    public EntidadeNaoEncontradaException(String entidade, Long id) {
        super(String.format("Não foi encontrado(a) um(a) %s com o id %s", entidade, id.toString()));
    }
}
