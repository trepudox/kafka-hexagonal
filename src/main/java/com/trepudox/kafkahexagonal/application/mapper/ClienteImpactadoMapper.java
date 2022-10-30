package com.trepudox.kafkahexagonal.application.mapper;

import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDTO;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoDetailDTO;
import com.trepudox.kafkahexagonal.application.dto.ClienteImpactadoMessageDTO;
import com.trepudox.kafkahexagonal.application.exception.ClienteImpactadoParseException;
import com.trepudox.kafkahexagonal.domain.ClienteImpactado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ClienteImpactadoMapper {

    public ClienteImpactadoDTO domainToDto(ClienteImpactado domain) {
        ClienteImpactadoDTO dto = new ClienteImpactadoDTO();

        dto.setApp(domain.getApp());
        dto.setData(domain.getData());
        dto.setClientes(domain.getClientes());
        dto.setImpactados(domain.getImpactados());
        dto.setAltaPrioridade(domain.getAltaPrioridade());
        dto.setBaixaPrioridade(domain.getBaixaPrioridade());

        return dto;
    }

    public ClienteImpactado messageDtoToDomain(ClienteImpactadoMessageDTO dto) {
        String app = dto.getApp();

        try {
            LocalDateTime data = LocalDateTime.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
            int clientes = Integer.parseInt(dto.getClientes());
            int impactados = Integer.parseInt(dto.getImpactados());
            int altaPrioridade = Integer.parseInt(dto.getAltaPrioridade());
            int baixaPrioridade = Integer.parseInt(dto.getBaixaPrioridade());

            return new ClienteImpactado(app, data, clientes, impactados, altaPrioridade, baixaPrioridade);
        } catch(DateTimeParseException | NumberFormatException e) {
            throw new ClienteImpactadoParseException("Nao foi possivel realizar a conversao de ClienteImpactado", e);
        }

    }

    public ClienteImpactadoDetailDTO domainToDetailDto(ClienteImpactado domain) {
        ClienteImpactadoDetailDTO detailDTO = new ClienteImpactadoDetailDTO();

        detailDTO.setApp(domain.getApp());
        detailDTO.setData(domain.getData());
        detailDTO.setClientes(domain.getClientes());
        detailDTO.setImpactados(domain.getImpactados());
        detailDTO.setAltaPrioridade(domain.getAltaPrioridade());
        detailDTO.setBaixaPrioridade(domain.getBaixaPrioridade());
        detailDTO.setPorcentagemImpactados(domain.calcularPorcentagemDeImpactados().doubleValue());
        detailDTO.setPorcentagemAltaPrioridade(domain.calcularPorcentagemDeAltaPrioridade().doubleValue());
        detailDTO.setPorcentagemBaixaPrioridade(domain.calcularPorcentagemDeBaixaPrioridade().doubleValue());

        return detailDTO;
    }

}
