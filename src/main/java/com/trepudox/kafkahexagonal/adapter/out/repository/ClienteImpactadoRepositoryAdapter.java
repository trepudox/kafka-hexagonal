package com.trepudox.kafkahexagonal.adapter.out.repository;

import com.trepudox.kafkahexagonal.application.port.out.DatabaseOutputPort;
import com.trepudox.kafkahexagonal.domain.ClienteImpactado;
import com.trepudox.kafkahexagonal.infrastructure.mapper.ClienteImpactadoMapper;
import com.trepudox.kafkahexagonal.infrastructure.persistence.id.ClienteImpactadoModelId;
import com.trepudox.kafkahexagonal.infrastructure.persistence.model.ClienteImpactadoModel;
import com.trepudox.kafkahexagonal.infrastructure.persistence.repository.ClienteImpactadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteImpactadoRepositoryAdapter implements DatabaseOutputPort {

    private final ClienteImpactadoRepository clienteImpactadoRepository;

    // FIXME: precisa ser uma busca de todos os apps nos últimos 5 min
    // algo como uma busca de LocalDateTime.now() - 4min e 59s
    @Override
    public List<ClienteImpactado> findAllInTheLast5Minutes() {
        Iterable<ClienteImpactadoModel> modelsIterable = clienteImpactadoRepository.findAll();
        List<ClienteImpactadoModel> modelsList = new ArrayList<>();

        modelsIterable.forEach(modelsList::add);

        return modelsList.stream()
                .map(ClienteImpactadoMapper.INSTANCE::modelToDomain)
                .collect(Collectors.toList());
    }

    // TODO: find por App que busque as ultimas 24 horas
    @Override
    public List<ClienteImpactado> findAllByAppInTheLast24Hours(String app) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime range = now.minus(23, ChronoUnit.HOURS)
                .minus(59, ChronoUnit.MINUTES)
                .minus(59, ChronoUnit.SECONDS);

        return null;
    }

    @Override
    public Optional<ClienteImpactado> findByAppAndData(String app, LocalDateTime data) {
        ClienteImpactadoModelId id = new ClienteImpactadoModelId(app, data.format(DateTimeFormatter.ofPattern("ddMMyyyy'T'HHmmss")));

        return clienteImpactadoRepository.findById(id)
                .map(ClienteImpactadoMapper.INSTANCE::modelToDomain);
    }
}
