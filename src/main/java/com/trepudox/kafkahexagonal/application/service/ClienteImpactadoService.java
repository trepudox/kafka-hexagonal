package com.trepudox.kafkahexagonal.application.service;

import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDTO;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDetailDTO;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoMessageDTO;
import com.trepudox.kafkahexagonal.application.exception.ClienteImpactadoNaoEncontradoException;
import com.trepudox.kafkahexagonal.application.mapper.ClienteImpactadoApplicationMapper;
import com.trepudox.kafkahexagonal.application.port.in.ClienteImpactadoInputPort;
import com.trepudox.kafkahexagonal.application.port.out.DatabaseOutputPort;
import com.trepudox.kafkahexagonal.domain.ClienteImpactado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClienteImpactadoService implements ClienteImpactadoInputPort {

    private final DatabaseOutputPort databaseOutputPort;
    private final ClienteImpactadoApplicationMapper clienteImpactadoApplicationMapper;

    public ClienteImpactadoService(DatabaseOutputPort databaseOutputPort, ClienteImpactadoApplicationMapper clienteImpactadoApplicationMapper) {
        this.databaseOutputPort = databaseOutputPort;
        this.clienteImpactadoApplicationMapper = clienteImpactadoApplicationMapper;
    }

    @Override
    public void save(ClienteImpactadoMessageDTO messageDTO) {
        ClienteImpactado clienteImpactado = clienteImpactadoApplicationMapper.messageDtoToDomain(messageDTO);
        databaseOutputPort.save(clienteImpactado);
    }

    @Override
    public ClienteImpactadoDetailDTO findByAppAndData(String app, String data) {
        LocalDateTime parsedDateTime = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("yyyyMMddHHmm"));

        Optional<ClienteImpactado> clienteImpactadoOptional = databaseOutputPort.findByAppAndData(app, parsedDateTime);

        return clienteImpactadoOptional
                .map(clienteImpactadoApplicationMapper::domainToDetailDto)
                .orElseThrow(ClienteImpactadoNaoEncontradoException::new);
    }

    @Override
    public List<ClienteImpactadoDetailDTO> retrieveClienteImpactadoDetailsFromTheLast5Minutes() {
        LocalDateTime last5MinInterval = findLast5MinInterval(LocalDateTime.now());

        List<ClienteImpactado> clientesImpactados = databaseOutputPort.findAllByDate(last5MinInterval);

        return clientesImpactados.stream()
                .map(clienteImpactadoApplicationMapper::domainToDetailDto)
                .collect(Collectors.toList());
    }

    private LocalDateTime findLast5MinInterval(LocalDateTime localDateTime) {
        int minutos = localDateTime.getMinute() - 1; // dando 1 minuto de delay (nem sempre a mensagem vem aos 0 segundos)
        int resto = minutos % 5;

        if(resto == 0) // se resto for 0, pode retornar os dados do minutos anterior
            return localDateTime.minus(1, ChronoUnit.MINUTES);
        else if(resto == -1) // se resto for -1, retorna os dados do minuto 55 da hora anterior
            return localDateTime.minus(1, ChronoUnit.HOURS).withMinute(55);
        else // senao, subtraimos o resto + 1 (para compensar o minuto de delay)
            return localDateTime.minus(resto + 1L, ChronoUnit.MINUTES);
    }

    @Override
    public List<ClienteImpactadoDTO> findAllByAppInTheLastHour(String app) {
        LocalDateTime range = LocalDateTime.now().minus(60, ChronoUnit.MINUTES);

        List<ClienteImpactado> clienteImpactados = databaseOutputPort.findAllByAppAndDataHoraGreaterThan(app, range);

        return clienteImpactados.stream()
                .map(clienteImpactadoApplicationMapper::domainToDto)
                .collect(Collectors.toList());
    }

}
