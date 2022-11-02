package com.trepudox.kafkahexagonal.adapter.out.repository;

import com.trepudox.kafkahexagonal.application.port.out.DatabaseOutputPort;
import com.trepudox.kafkahexagonal.domain.ClienteImpactado;
import com.trepudox.kafkahexagonal.infrastructure.mapper.ClienteImpactadoInfraMapper;
import com.trepudox.kafkahexagonal.infrastructure.persistence.model.ClienteImpactadoModel;
import com.trepudox.kafkahexagonal.infrastructure.persistence.repository.ClienteImpactadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteImpactadoRepositoryAdapter implements DatabaseOutputPort {

    @Value("${dataHora.pattern}")
    private String dataHoraPattern;

    private final ClienteImpactadoRepository clienteImpactadoRepository;

    @Override
    public void save(ClienteImpactado clienteImpactado) {
        ClienteImpactadoModel model = ClienteImpactadoInfraMapper.INSTANCE.domainToModel(clienteImpactado);
        clienteImpactadoRepository.save(model);
    }

    @Override
    public List<ClienteImpactado> findAllByDate(LocalDateTime localDateTime) {
        List<ClienteImpactadoModel> models = clienteImpactadoRepository
                .buscarPorDataHora(localDateTime.format(DateTimeFormatter.ofPattern(dataHoraPattern)));

        return models.stream()
                .map(ClienteImpactadoInfraMapper.INSTANCE::modelToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClienteImpactado> findAllByAppAndDataHoraGreaterThan(String app, LocalDateTime localDateTime) {
        String formattedRange = localDateTime.format(DateTimeFormatter.ofPattern(dataHoraPattern));

        List<ClienteImpactadoModel> models = clienteImpactadoRepository.buscarPorAppEDataHoraMaiorQue(app, formattedRange);

        return models.stream()
                .map(ClienteImpactadoInfraMapper.INSTANCE::modelToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteImpactado> findByAppAndData(String app, LocalDateTime data) {
        String formattedData = data.format(DateTimeFormatter.ofPattern(dataHoraPattern));

        Optional<ClienteImpactadoModel> optional = clienteImpactadoRepository.buscarPorAppEData(app, formattedData);
        return optional.map(ClienteImpactadoInfraMapper.INSTANCE::modelToDomain);
    }
}
