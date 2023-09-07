package br.com.alura.hotel.controller;

import br.com.alura.hotel.dao.AdministradorDAO;
import br.com.alura.hotel.factory.ConnectionFactory;
import br.com.alura.hotel.model.Administrador;
import java.sql.Connection;
import java.util.LinkedList;

public class AdministradorController {

    private AdministradorDAO administradorDAO;

    public AdministradorController() {
        Connection conexao = new ConnectionFactory().recuperarConexao();
        this.administradorDAO = new AdministradorDAO(conexao);
    }

    /**
     * @return LinkedList<Administrador>
     */
    public LinkedList<Administrador> listar() {
        return this.administradorDAO.listar();
    }

    /**
     * @param usuario
     * @param senha
     */
    public void salvar(String usuario, String senha) {
        Administrador administrador = new Administrador(usuario, senha);
        this.administradorDAO.salvar(administrador);
    }

    /**
     * @param id
     */
    public void deletar(Integer id) {
        this.administradorDAO.deletar(id);
    }

    /**
     * @param id Integer
     * @param usuario String
     */
    public void alterar(Integer id, String usuario) {
        this.administradorDAO.alterar(id, usuario);
    }

    /**
     * @param id Integer
     * @param administrador Administrador
     */
    public void alterar(Integer id, Administrador administrador) {
        this.administradorDAO.alterar(id, administrador.getUsuario(), administrador.getSenha());
    }

    /**
     * @param usuario String
     * @return LinkedList<Administrador>
     */
    public LinkedList<Administrador> buscar(String usuario) {
        LinkedList<Administrador> administradores = this.administradorDAO.buscar(usuario);
        return administradores;
    }
}
