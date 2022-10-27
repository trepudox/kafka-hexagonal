package com.trepudox.kafkahexagonal.application.service;

import com.trepudox.kafkahexagonal.application.exception.ClienteImpactadoNaoEncontradoException;
import com.trepudox.kafkahexagonal.application.port.in.ClienteImpactadoInputPort;
import com.trepudox.kafkahexagonal.application.port.out.DatabaseOutputPort;
import com.trepudox.kafkahexagonal.domain.ClienteImpactado;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class ClienteImpactadoService implements ClienteImpactadoInputPort {

    private final DatabaseOutputPort databaseOutputPort;

    public ClienteImpactadoService(DatabaseOutputPort databaseOutputPort) {
        this.databaseOutputPort = databaseOutputPort;
    }

    @Override
    public List<ClienteImpactado> findAll() {
        return databaseOutputPort.findAll();
    }

    @Override
    public ClienteImpactado findByAppAndData(String app, LocalDateTime data) {
        Optional<ClienteImpactado> clienteImpactadoOptional = databaseOutputPort.findByAppAndData(app, data);
        return clienteImpactadoOptional.orElseThrow(ClienteImpactadoNaoEncontradoException::new);
    }

}
