package com.trepudox.kafkahexagonal.application.port.in;

import com.trepudox.kafkahexagonal.domain.ClienteImpactado;

import java.time.LocalDateTime;
import java.util.List;

public interface ClienteImpactadoInputPort {

    List<ClienteImpactado> findAll();

    ClienteImpactado findByAppAndData(String app, LocalDateTime data);

}
