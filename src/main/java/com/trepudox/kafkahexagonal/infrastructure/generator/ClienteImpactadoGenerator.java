package com.trepudox.kafkahexagonal.infrastructure.generator;

import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoMessageDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ClienteImpactadoGenerator {

    private static final Random RANDOM = new Random();

    public List<ClienteImpactadoMessageDTO> createDtoList() {
        List<String> names = List.of("PF", "PJ", "Empresas Atacado", "Empresas Varejo");
        List<ClienteImpactadoMessageDTO> resultList = new ArrayList<>();

        for(String name : names) {
            ClienteImpactadoMessageDTO dto = doCreateDto(name);
            resultList.add(dto);
        }

        return resultList;
    }

    public ClienteImpactadoMessageDTO doCreateDto(String appName) {
        ClienteImpactadoMessageDTO dto = new ClienteImpactadoMessageDTO();

        dto.setApp(appName);
        dto.setData(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));

        int clientes = RANDOM.nextInt(10000);
        int impactados = RANDOM.nextInt(clientes + 1);
        int baixaPrioridade = RANDOM.nextInt(impactados + 1);
        int altaPrioridade = impactados - baixaPrioridade;

        dto.setClientes(String.valueOf(clientes));
        dto.setImpactados(String.valueOf(impactados));
        dto.setBaixaPrioridade(String.valueOf(baixaPrioridade));
        dto.setAltaPrioridade(String.valueOf(altaPrioridade));

        return dto;
    }

}
