package br.com.alura.hotel.model;

import java.sql.Date;

public class Reserva {
    private Integer id;
    private Date dataEntrada;
    private Date dataSaida;
    private Double valor;
    private String formaPagamento;

    public Reserva() {
    }

    /**
     * @param dataEntrada Date
     * @param valor Double
     * @param formaPagamento String
     */
    public Reserva(Date dataEntrada, Date dataSaida, Double valor, String formaPagamento) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    /**
     * @param id Integer
     * @param dataEntrada Date
     * @param valor Double
     * @param formaPagamento String
     */
    public Reserva(Integer id, Date dataEntrada, Date dataSaida, Double valor, String formaPagamento) {
        this.id = id;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
