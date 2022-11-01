package com.trepudox.kafkahexagonal.application.port.out;

import com.trepudox.kafkahexagonal.domain.ClienteImpactado;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface DatabaseOutputPort {

    void save(ClienteImpactado clienteImpactado);

    List<ClienteImpactado> findAllByDate(LocalDateTime localDateTime);

    List<ClienteImpactado> findAllByAppAndDataHoraGreaterThan(String app, LocalDateTime localDateTime);

    Optional<ClienteImpactado> findByAppAndData(String app, LocalDateTime localDateTime);
}
