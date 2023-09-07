package br.com.alura.hotel.controller;

import br.com.alura.hotel.dao.ReservaDAO;
import br.com.alura.hotel.factory.ConnectionFactory;
import br.com.alura.hotel.model.Reserva;
import java.sql.Connection;
import java.sql.Date;
import java.util.LinkedList;

public class ReservaController {
    private ReservaDAO reservaDAO;

    public ReservaController() {
        Connection conexao = new ConnectionFactory().recuperarConexao();
        this.reservaDAO = new ReservaDAO(conexao);
    }

    /**
     * @return LinkedList<Reserva>
     */
    public LinkedList<Reserva> listar() {
        return this.reservaDAO.listar();
    }

    /**
     * @param dataEntrada Date
     * @param valor Double
     * @param formaPagamento String
     */
    public Integer salvar(Date dataEntrada, Date dataSaida, Double valor, String formaPagamento) {
        Reserva reserva = new Reserva(dataEntrada, dataSaida, valor, formaPagamento);
        return this.reservaDAO.salvar(reserva);
    }

    /**
     * @param id
     */
    public void deletar(Integer id) {
        this.reservaDAO.deletar(id);
    }

    /**
     * @param novoId
     * @param velhoId
     * @param dataEntrada
     * @param valor
     * @param formaPagamento
     */
    public void alterar(Integer novoId, Integer velhoId, Date dataEntrada, Date dataSaida, Double valor, String formaPagamento) {
        Reserva reserva = new Reserva(velhoId, dataEntrada, dataSaida, valor, formaPagamento);
        this.reservaDAO.alterar(novoId, velhoId, reserva);
    }

    /**
     * @param id
     * @param dataEntrada
     * @param valor
     * @param formaPagamento
     */
    public void alterar(Integer id, Date dataEntrada, Date dataSaida, Double valor, String formaPagamento) {
        Reserva reserva = new Reserva(id, dataEntrada, dataSaida, valor, formaPagamento);
        this.reservaDAO.alterar(id, reserva);
    }

    /**
     * @param id Integer
     * @return LinkedList<Reserva>
     */
    public LinkedList<Reserva> buscar(Integer id) {
        return this.reservaDAO.buscar(id);
    }

    /**
     * @param dataDeEntrada java.sql.Date
     * @return LinkedList<Reserva>
     */
    public LinkedList<Reserva> buscar(Date dataDeEntrada) {
        return this.reservaDAO.buscar(dataDeEntrada);
    }

    /**
     * @param valorPagamento Double
     * @return LinkedList<Reserva>
     */
    public LinkedList<Reserva> buscar(Double valorPagamento) {
        return this.reservaDAO.buscar(valorPagamento);
    }
}
