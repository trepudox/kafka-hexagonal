package com.trepudox.kafkahexagonal.application.exception;

import com.trepudox.kafkahexagonal.domain.ClienteImpactado;

public class ClienteImpactadoNaoEncontradoException extends RuntimeException {

    public ClienteImpactadoNaoEncontradoException() {
        super(ClienteImpactado.class.getSimpleName().concat(" nao encontrado"));
    }

    public ClienteImpactadoNaoEncontradoException(String message) {
        super(message);
    }

    public ClienteImpactadoNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteImpactadoNaoEncontradoException(Throwable cause) {
        super(cause);
    }
}
