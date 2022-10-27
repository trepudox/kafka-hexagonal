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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteImpactadoRepositoryAdapter implements DatabaseOutputPort {

    private final ClienteImpactadoRepository clienteImpactadoRepository;

    @Override
    public List<ClienteImpactado> findAll() {
        Iterable<ClienteImpactadoModel> modelsIterable = clienteImpactadoRepository.findAll();
        List<ClienteImpactadoModel> modelsList = new ArrayList<>();

        modelsIterable.forEach(modelsList::add);

        return modelsList.stream()
                .map(ClienteImpactadoMapper.INSTANCE::modelToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteImpactado> findByAppAndData(String app, LocalDateTime data) {
        ClienteImpactadoModelId id = new ClienteImpactadoModelId(app, data);

        return clienteImpactadoRepository.findById(id)
                .map(ClienteImpactadoMapper.INSTANCE::modelToDomain);
    }
}
