package com.trepudox.kafkahexagonal.application.port.out;

import com.trepudox.kafkahexagonal.domain.ClienteImpactado;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DatabaseOutputPort {
    List<ClienteImpactado> findAllInTheLast5Minutes();

    List<ClienteImpactado> findAllByAppInTheLast24Hours(String app);

    Optional<ClienteImpactado> findByAppAndData(String app, LocalDateTime data);
}
