package br.com.alura.hotel.dao;

import br.com.alura.hotel.model.Administrador;
import java.sql.*;
import java.util.LinkedList;

public class AdministradorDAO {
    private Connection conexao;

    public AdministradorDAO() {
    }

    public AdministradorDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * @param preparedStatement
     * @return LinkedList<Administrador>
     * @throws SQLException
     */
    private LinkedList<Administrador> retornaLista(PreparedStatement preparedStatement) throws SQLException {
        LinkedList<Administrador> administradores = new LinkedList<>();

        try(ResultSet resultSet = preparedStatement.getResultSet()) {
            while(resultSet.next()) {
                Administrador administrador = new Administrador(
                        resultSet.getString(1),
                        resultSet.getString(2)
                );
                administradores.add(administrador);
            }

            return administradores;
        }
    }

    /**
     * @return LinkedList<Administrador>
     */
    public LinkedList<Administrador> listar() {
        String codigoSQL = "SELECT adm_usuario, adm_senha FROM tbl_administrador " +
                "ORDER BY adm_usuario";

        try(PreparedStatement preparedStatement = conexao.prepareStatement(codigoSQL)) {
            preparedStatement.execute();
            return retornaLista(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param usuarioAdministrador
     * @return LinkedList<Administrador>
     */
    public LinkedList<Administrador> buscar(String usuarioAdministrador) {
        String codigoSQL = "SELECT adm_id, adm_usuario, adm_senha FROM tbl_administrador " +
                "WHERE adm_usuario = ?";
        LinkedList<Administrador> administradores = new LinkedList<>();

        try(PreparedStatement preparedStatement = conexao.prepareStatement(codigoSQL)) {
            preparedStatement.setString(1, usuarioAdministrador);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while(resultSet.next()) {
                Administrador administrador = new Administrador(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                );

                administradores.add(administrador);
            }

            return administradores;
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param administrador
     */
    public void salvar(Administrador administrador) {
        String codigoSQL = "INSERT INTO tbl_administrador (adm_usuario, adm_senha) VALUES (?, ?)";

        try(PreparedStatement preparedStatement = conexao.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, administrador.getUsuario());
            preparedStatement.setString(2, administrador.getSenha());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id
     */
    public void deletar(Integer id) {
        try(PreparedStatement preparedStatement = conexao.prepareStatement(
            "DELETE FROM tbl_administrador WHERE adm_id = ?"
        )){
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id
     * @param usuario
     */
    public void alterar(Integer id, String usuario) {
        try(PreparedStatement preparedStatement = conexao.prepareStatement(
                "UPDATE tbl_administrador SET " +
                        "adm_nome = ? " +
                        "WHERE adm_id = ?"
        )) {
            preparedStatement.setString(1, usuario);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id
     * @param usuario
     * @param senha
     */
    public void alterar(Integer id, String usuario, String senha) {
        try(PreparedStatement preparedStatement = conexao.prepareStatement(
                "UPDATE tbl_administrador SET " +
                        "adm_nome = ?, adm_senha = ?" +
                        "WHERE adm_id = ?"
        )) {
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, senha);
            preparedStatement.setInt(3, id);
            preparedStatement.execute();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
