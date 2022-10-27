package com.trepudox.kafkahexagonal.application.dto;

import java.time.LocalDateTime;

public class ClienteImpactadoCardDTO {

    private String app;
    private LocalDateTime data;
    private int clientes;
    private int impactados;
    private int altaPrioridade;
    private int baixaPrioridade;
    private long porcentagemImpactados;
    private long porcentagemAltaPrioridade;
    private long porcentagemBaixaPrioridade;

    public ClienteImpactadoCardDTO() {}

    public ClienteImpactadoCardDTO(String app, LocalDateTime data, int clientes, int impactados, int altaPrioridade, int baixaPrioridade, long porcentagemImpactados, long porcentagemAltaPrioridade, long porcentagemBaixaPrioridade) {
        this.app = app;
        this.data = data;
        this.clientes = clientes;
        this.impactados = impactados;
        this.altaPrioridade = altaPrioridade;
        this.baixaPrioridade = baixaPrioridade;
        this.porcentagemImpactados = porcentagemImpactados;
        this.porcentagemAltaPrioridade = porcentagemAltaPrioridade;
        this.porcentagemBaixaPrioridade = porcentagemBaixaPrioridade;
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

    public long getPorcentagemImpactados() {
        return porcentagemImpactados;
    }

    public void setPorcentagemImpactados(long porcentagemImpactados) {
        this.porcentagemImpactados = porcentagemImpactados;
    }

    public long getPorcentagemAltaPrioridade() {
        return porcentagemAltaPrioridade;
    }

    public void setPorcentagemAltaPrioridade(long porcentagemAltaPrioridade) {
        this.porcentagemAltaPrioridade = porcentagemAltaPrioridade;
    }

    public long getPorcentagemBaixaPrioridade() {
        return porcentagemBaixaPrioridade;
    }

    public void setPorcentagemBaixaPrioridade(long porcentagemBaixaPrioridade) {
        this.porcentagemBaixaPrioridade = porcentagemBaixaPrioridade;
    }
}
