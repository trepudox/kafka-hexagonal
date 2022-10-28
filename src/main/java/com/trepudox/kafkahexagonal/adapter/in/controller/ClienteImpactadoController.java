package com.trepudox.kafkahexagonal.adapter.in.controller;

import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDTO;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDetailDTO;
import com.trepudox.kafkahexagonal.application.port.in.ClienteImpactadoInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cliente-impactado")
public class ClienteImpactadoController {

    private final ClienteImpactadoInputPort clienteImpactadoInputPort;

    @GetMapping
    public ResponseEntity<List<ClienteImpactadoDetailDTO>> getClienteImpactadoDetailsFromTheLast5Minutes() {
        List<ClienteImpactadoDetailDTO> details = clienteImpactadoInputPort.retrieveClienteImpactadoDetailsFromTheLast5Minutes();
        return ResponseEntity.status(HttpStatus.OK).body(details);
    }

    @GetMapping("/{app}/{data}")
    public ResponseEntity<ClienteImpactadoDetailDTO> getClienteImpactadoDetailByAppAndData(@PathVariable String app,
                                                                                           @PathVariable String data) {

        ClienteImpactadoDetailDTO detail = clienteImpactadoInputPort.findByAppAndData(app, data);
        return ResponseEntity.status(HttpStatus.OK).body(detail);
    }

    @GetMapping("/{app}/last-day")
    public ResponseEntity<List<ClienteImpactadoDTO>> getAllClienteImpactadosByAppFromLast24Hours(@PathVariable String app) {
        List<ClienteImpactadoDTO> clientesImpactados = clienteImpactadoInputPort.findAllByAppInTheLast24Hours(app);
        return ResponseEntity.status(HttpStatus.OK).body(clientesImpactados);
    }

}
