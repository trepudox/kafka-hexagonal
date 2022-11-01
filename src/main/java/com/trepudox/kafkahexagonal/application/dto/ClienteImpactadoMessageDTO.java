package com.trepudox.kafkahexagonal.application.dto;

public class ClienteImpactadoMessageDTO {

    private String app;
    private String data;
    private String clientes;
    private String impactados;
    private String altaPrioridade;
    private String baixaPrioridade;

    public ClienteImpactadoMessageDTO() {}

    public ClienteImpactadoMessageDTO(String app, String data, String clientes, String impactados, String altaPrioridade, String baixaPrioridade) {
        this.app = app;
        this.data = data;
        this.clientes = clientes;
        this.impactados = impactados;
        this.altaPrioridade = altaPrioridade;
        this.baixaPrioridade = baixaPrioridade;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getClientes() {
        return clientes;
    }

    public void setClientes(String clientes) {
        this.clientes = clientes;
    }

    public String getImpactados() {
        return impactados;
    }

    public void setImpactados(String impactados) {
        this.impactados = impactados;
    }

    public String getAltaPrioridade() {
        return altaPrioridade;
    }

    public void setAltaPrioridade(String altaPrioridade) {
        this.altaPrioridade = altaPrioridade;
    }

    public String getBaixaPrioridade() {
        return baixaPrioridade;
    }

    public void setBaixaPrioridade(String baixaPrioridade) {
        this.baixaPrioridade = baixaPrioridade;
    }
}
