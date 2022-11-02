package com.trepudox.kafkahexagonal.domain;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class ClienteImpactado {

    private static final int PRECISAO_PORCENTAGEM = 4;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_DOWN;

    private String app;
    private LocalDateTime data;
    private int clientes;
    private int impactados;
    private int altaPrioridade;
    private int baixaPrioridade;

    public ClienteImpactado() {}

    public ClienteImpactado(String app, LocalDateTime data, int clientes, int impactados, int altaPrioridade, int baixaPrioridade) {
        this.app = app;
        this.data = data;
        this.clientes = clientes;
        this.impactados = impactados;
        this.altaPrioridade = altaPrioridade;
        this.baixaPrioridade = baixaPrioridade;
    }

    public BigDecimal calcularPorcentagemDeImpactados() {
        BigDecimal impactadosBigDecimal = BigDecimal.valueOf(this.impactados);
        BigDecimal clientesBigDecimal = BigDecimal.valueOf(this.clientes);
        return doCalcularPorcentagem(impactadosBigDecimal, clientesBigDecimal);
    }

    public BigDecimal calcularPorcentagemDeAltaPrioridade() {
        BigDecimal altaPrioridadeBigDecimal = BigDecimal.valueOf(this.altaPrioridade);
        BigDecimal impactadosBigDecimal = BigDecimal.valueOf(this.impactados);
        return doCalcularPorcentagem(altaPrioridadeBigDecimal, impactadosBigDecimal);
    }

    public BigDecimal calcularPorcentagemDeBaixaPrioridade() {
        BigDecimal baixaPrioridadeBigDecimal = BigDecimal.valueOf(this.baixaPrioridade);
        BigDecimal impactadosBigDecimal = BigDecimal.valueOf(this.impactados);
        return doCalcularPorcentagem(baixaPrioridadeBigDecimal, impactadosBigDecimal);
    }

    private BigDecimal doCalcularPorcentagem(BigDecimal dividendo, BigDecimal divisor) {
        if(divisor.compareTo(BigDecimal.ZERO) == 0)
            return BigDecimal.ZERO;

        return dividendo.divide(divisor, new MathContext(PRECISAO_PORCENTAGEM, ROUNDING_MODE))
                .multiply(BigDecimal.valueOf(100));
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

    @Override
    public String toString() {
        return "ClienteImpactado{" +
                "app='" + app + '\'' +
                ", clientes=" + clientes +
                ", impactados=" + impactados +
                ", altaPrioridade=" + altaPrioridade +
                ", baixaPrioridade=" + baixaPrioridade +
                ", data=" + data +
                '}';
    }
}
