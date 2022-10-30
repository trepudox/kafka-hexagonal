package com.trepudox.kafkahexagonal.application.exception;

public class ClienteImpactadoParseException extends RuntimeException {

    public ClienteImpactadoParseException() {
    }

    public ClienteImpactadoParseException(String message) {
        super(message);
    }

    public ClienteImpactadoParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteImpactadoParseException(Throwable cause) {
        super(cause);
    }
}
