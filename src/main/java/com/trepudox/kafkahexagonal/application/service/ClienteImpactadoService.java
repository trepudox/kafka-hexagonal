package com.trepudox.kafkahexagonal.application.service;

import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDTO;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDetailDTO;
import com.trepudox.kafkahexagonal.application.exception.ClienteImpactadoNaoEncontradoException;
import com.trepudox.kafkahexagonal.application.port.in.ClienteImpactadoInputPort;
import com.trepudox.kafkahexagonal.application.port.out.DatabaseOutputPort;
import com.trepudox.kafkahexagonal.domain.ClienteImpactado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClienteImpactadoService implements ClienteImpactadoInputPort {

    private final DatabaseOutputPort databaseOutputPort;

    public ClienteImpactadoService(DatabaseOutputPort databaseOutputPort) {
        this.databaseOutputPort = databaseOutputPort;
    }

    @Override
    public ClienteImpactadoDetailDTO findByAppAndData(String app, String data) {
        // TODO: definir formato da data (ddMMyyyy'T'HHmmss) = 27102022T221500
        LocalDateTime parsedDateTime = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("ddMMyyyy'T'HHmmss"));

        Optional<ClienteImpactado> clienteImpactadoOptional = databaseOutputPort.findByAppAndData(app, parsedDateTime);

        return clienteImpactadoOptional
                .map(ClienteImpactadoDetailDTO::new)
                .orElseThrow(ClienteImpactadoNaoEncontradoException::new);
    }

    @Override
    public List<ClienteImpactadoDetailDTO> retrieveClienteImpactadoDetailsFromTheLast5Minutes() {
        List<ClienteImpactado> clientesImpactados = databaseOutputPort.findAllInTheLast5Minutes();
        return clientesImpactados.stream()
                .map(ClienteImpactadoDetailDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClienteImpactadoDTO> findAllByAppInTheLast24Hours(String app) {
        return null;
    }

}
