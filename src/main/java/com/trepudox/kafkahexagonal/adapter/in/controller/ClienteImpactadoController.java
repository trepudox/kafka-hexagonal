package com.trepudox.kafkahexagonal.adapter.in.controller;

import com.trepudox.kafkahexagonal.application.port.in.ClienteImpactadoInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cliente-impactado")
public class ClienteImpactadoController {

    private final ClienteImpactadoInputPort clienteImpactadoInputPort;

}
