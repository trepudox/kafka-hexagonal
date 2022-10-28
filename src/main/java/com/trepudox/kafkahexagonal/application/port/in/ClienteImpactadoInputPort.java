package com.trepudox.kafkahexagonal.application.port.in;

import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDTO;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDetailDTO;

import java.util.List;

public interface ClienteImpactadoInputPort {

    ClienteImpactadoDetailDTO findByAppAndData(String app, String data);

    List<ClienteImpactadoDetailDTO> retrieveClienteImpactadoDetailsFromTheLast5Minutes();

    List<ClienteImpactadoDTO> findAllByAppInTheLast24Hours(String app);

}
