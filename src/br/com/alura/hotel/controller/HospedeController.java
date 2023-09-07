package br.com.alura.hotel.controller;

import br.com.alura.hotel.dao.HospedeDAO;
import br.com.alura.hotel.factory.ConnectionFactory;
import br.com.alura.hotel.model.Hospede;

import java.sql.Connection;
import java.sql.Date;
import java.util.LinkedList;

public class HospedeController {
    private HospedeDAO hospedeDAO;

    public HospedeController() {
        Connection conexao = new ConnectionFactory().recuperarConexao();
        this.hospedeDAO = new HospedeDAO(conexao);
    }

    /**
     * @return LinkedList<Hospede>
     */
    public LinkedList<Hospede> listar() {
        return this.hospedeDAO.listar();
    }

    /**
     * @param nome String
     * @param sobrenome String
     * @param dataNascimento Date
     * @param nacionalidade String
     * @param telefone String
     */
    public void salvar(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, Integer reservaId) {
        this.hospedeDAO.salvar(
            new Hospede(
                nome,
                sobrenome,
                dataNascimento,
                nacionalidade,
                telefone,
                reservaId
            )
        );
    }

    /**
     * @param id Integer
     */
    public void deletar(Integer id){
        this.hospedeDAO.deletar(id);
    }

    /**
     * @param nome String
     * @param sobrenome String
     */
    public void deletar(String nome, String sobrenome) {
        this.hospedeDAO.deletar(nome, sobrenome);
    }

    /**
     * @param id Integer
     * @param nome String
     * @param sobrenome String
     * @param dataNascimento Date
     * @param nacionalidade String
     * @param telefone String
     */
    public void alterar(Integer id, String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone) {
        this.hospedeDAO.alterar(
                id,
                nome,
                sobrenome,
                dataNascimento,
                nacionalidade,
                telefone
        );
    }

    /**
     * @param id Integer
     * @return LinkedList<Hospede>
     */
    public LinkedList<Hospede> buscar(Integer id) {
        return this.hospedeDAO.buscar(id);
    }

    /**
     * @param nome String
     * @return LinkedList<Hospede>
     */
    public LinkedList<Hospede> buscar(String nome) {
        return this.hospedeDAO.buscar(nome);
    }

    /**
     *
     * @param dataNascimento java.sql.Date
     * @return LinkedList<Hospede>
     */
    public LinkedList<Hospede> buscar(Date dataNascimento) {
        return this.hospedeDAO.buscar(dataNascimento);
    }
}
