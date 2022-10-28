package com.trepudox.kafkahexagonal.application.dto;

import com.trepudox.kafkahexagonal.domain.ClienteImpactado;

import java.time.LocalDateTime;

public class ClienteImpactadoDTO {

    private String app;
    private LocalDateTime data;
    private int clientes;
    private int impactados;
    private int altaPrioridade;
    private int baixaPrioridade;

    public ClienteImpactadoDTO() {}

    public ClienteImpactadoDTO(String app, LocalDateTime data, int clientes, int impactados, int altaPrioridade, int baixaPrioridade) {
        this.app = app;
        this.data = data;
        this.clientes = clientes;
        this.impactados = impactados;
        this.altaPrioridade = altaPrioridade;
        this.baixaPrioridade = baixaPrioridade;
    }

    public ClienteImpactadoDTO(ClienteImpactado clienteImpactado) {
        this.app = clienteImpactado.getApp();
        this.data = clienteImpactado.getData();
        this.clientes = clienteImpactado.getClientes();
        this.impactados = clienteImpactado.getImpactados();
        this.altaPrioridade = clienteImpactado.getAltaPrioridade();
        this.baixaPrioridade = clienteImpactado.getBaixaPrioridade();
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getClientes() {
        return clientes;
    }

    public void setClientes(int clientes) {
        this.clientes = clientes;
    }

    public int getImpactados() {
        return impactados;
    }

    public void setImpactados(int impactados) {
        this.impactados = impactados;
    }

    public int getAltaPrioridade() {
        return altaPrioridade;
    }

    public void setAltaPrioridade(int altaPrioridade) {
        this.altaPrioridade = altaPrioridade;
    }

    public int getBaixaPrioridade() {
        return baixaPrioridade;
    }

    public void setBaixaPrioridade(int baixaPrioridade) {
        this.baixaPrioridade = baixaPrioridade;
    }
}
