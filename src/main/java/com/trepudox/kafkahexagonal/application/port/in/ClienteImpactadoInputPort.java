package com.trepudox.kafkahexagonal.application.port.in;

import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDTO;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDetailDTO;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoMessageDTO;

import java.util.List;

public interface ClienteImpactadoInputPort {

    void save(ClienteImpactadoMessageDTO messageDTO);

    ClienteImpactadoDetailDTO findByAppAndData(String app, String data);

    List<ClienteImpactadoDetailDTO> retrieveClienteImpactadoDetailsFromTheLast5Minutes();

    List<ClienteImpactadoDTO> findAllByAppInTheLastHour(String app);

}
