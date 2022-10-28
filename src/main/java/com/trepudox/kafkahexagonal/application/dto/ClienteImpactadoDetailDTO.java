package com.trepudox.kafkahexagonal.application.dto;

import com.trepudox.kafkahexagonal.domain.ClienteImpactado;

import java.time.LocalDateTime;

public class ClienteImpactadoDetailDTO {

    private String app;
    private LocalDateTime data;
    private int clientes;
    private int impactados;
    private int altaPrioridade;
    private int baixaPrioridade;
    private double porcentagemImpactados;
    private double porcentagemAltaPrioridade;
    private double porcentagemBaixaPrioridade;

    public ClienteImpactadoDetailDTO() {}

    public ClienteImpactadoDetailDTO(String app, LocalDateTime data, int clientes, int impactados, int altaPrioridade, int baixaPrioridade, double porcentagemImpactados, double porcentagemAltaPrioridade, double porcentagemBaixaPrioridade) {
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

    public ClienteImpactadoDetailDTO(ClienteImpactado clienteImpactado) {
        this.app = clienteImpactado.getApp();
        this.data = clienteImpactado.getData();
        this.clientes = clienteImpactado.getClientes();
        this.impactados = clienteImpactado.getImpactados();
        this.altaPrioridade = clienteImpactado.getAltaPrioridade();
        this.baixaPrioridade = clienteImpactado.getBaixaPrioridade();
        this.porcentagemImpactados = clienteImpactado.calcularPorcentagemDeImpactados().doubleValue();
        this.porcentagemAltaPrioridade = clienteImpactado.calcularPorcentagemDeAltaPrioridade().doubleValue();
        this.porcentagemBaixaPrioridade = clienteImpactado.calcularPorcentagemDeBaixaPrioridade().doubleValue();
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

    public double getPorcentagemImpactados() {
        return porcentagemImpactados;
    }

    public void setPorcentagemImpactados(double porcentagemImpactados) {
        this.porcentagemImpactados = porcentagemImpactados;
    }

    public double getPorcentagemAltaPrioridade() {
        return porcentagemAltaPrioridade;
    }

    public void setPorcentagemAltaPrioridade(double porcentagemAltaPrioridade) {
        this.porcentagemAltaPrioridade = porcentagemAltaPrioridade;
    }

    public double getPorcentagemBaixaPrioridade() {
        return porcentagemBaixaPrioridade;
    }

    public void setPorcentagemBaixaPrioridade(double porcentagemBaixaPrioridade) {
        this.porcentagemBaixaPrioridade = porcentagemBaixaPrioridade;
    }
}
