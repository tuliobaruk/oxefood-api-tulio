package br.com.ifpe.oxefood.util.exception;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ClienteException extends RuntimeException {
    public static final String MSG_VALOR_DDD_INVALIDO = "Não é permitido cadastrar telefones que o DDD não seja (81) (Pernambuco)";

    public ClienteException(String msg){
        super(String.format(msg));
    }
}
