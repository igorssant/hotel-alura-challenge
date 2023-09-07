package br.com.alura.hotel.dao;

import br.com.alura.hotel.model.Reserva;

import java.sql.*;
import java.util.LinkedList;
import java.util.Objects;

public class ReservaDAO {
    private Connection conexao;

    public ReservaDAO() {
    }

    /**
     * @param conexao
     */
    public ReservaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * @param conexao
     */
    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * @param preparedStatement
     * @return LinkedLisst<Reserva>
     * @throws SQLException
     */
    public LinkedList<Reserva> retornaLista(PreparedStatement preparedStatement) throws SQLException {
        LinkedList<Reserva> reservas = new LinkedList<>();

        try(ResultSet resultSet = preparedStatement.getResultSet()) {
            while(resultSet.next()) {
                Reserva reserva = new Reserva(
                        resultSet.getInt(1),
                        resultSet.getDate(2),
                        resultSet.getDate(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5)
                );
                reservas.add(reserva);
            }

            return reservas;
        }
    }

    /**
     * @return LinkedList<Reserva>
     */
    public LinkedList<Reserva> listar() {
        String codigoSQL = "SELECT res_id, res_data_entrada, " +
                "res_data_saida, res_valor, " +
                "res_forma_pagamento FROM " +
                "tbl_reserva";

        try(PreparedStatement preparedStatement = this.conexao.prepareStatement(codigoSQL)) {
            preparedStatement.execute();
            return retornaLista(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param reserva Reserva
     */
    public Integer salvar(Reserva reserva) {
        String codigoSQL = "INSERT INTO tbl_reserva (" +
                "res_data_entrada, res_data_saida, " +
                "res_valor, res_forma_pagamento) " +
                "values (?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = this.conexao.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, reserva.getDataEntrada());
            preparedStatement.setDate(2, reserva.getDataSaida());
            preparedStatement.setDouble(3, reserva.getValor());
            preparedStatement.setString(4, reserva.getFormaPagamento());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id Integer
     */
    public void deletar(Integer id) {
        try (PreparedStatement preparedStatement = this.conexao.prepareStatement(
                "DELETE FROM tbl_reserva WHERE res_id = ?"
        )) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param novoId Integer
     * @param velhoId Integer
     * @param reserva Reserva
     */
    public void alterar(Integer novoId, Integer velhoId, Reserva reserva) {
        try(PreparedStatement preparedStatement = this.conexao.prepareStatement(
                "UPDATE tbl_reserva SET " +
                        "res_id = ?, " +
                        "res_data_entrada = ?, res_valor = ?, " +
                        "res_forma_pagamento = ? " +
                        "WHERE res_id = ?"
        )) {
            preparedStatement.setInt(1, novoId);
            preparedStatement.setDate(2, reserva.getDataEntrada());
            preparedStatement.setDouble(3, reserva.getValor());
            preparedStatement.setString(4, reserva.getFormaPagamento());
            preparedStatement.setInt(5, velhoId);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id Integer
     * @param reserva Reserva
     */
    public void alterar(Integer id, Reserva reserva) {
        try(PreparedStatement preparedStatement = this.conexao.prepareStatement(
                "UPDATE tbl_reserva SET " +
                        "res_data_entrada = ?, res_valor = ?, " +
                        "res_forma_pagamento = ? " +
                        "WHERE res_id = ?"
        )) {
            preparedStatement.setDate(1, reserva.getDataEntrada());
            preparedStatement.setDouble(2, reserva.getValor());
            preparedStatement.setString(3, reserva.getFormaPagamento());
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id Integer
     * @return LinkedList<Reserva>
     */
    public LinkedList<Reserva> buscar(Integer id) {
        try(PreparedStatement preparedStatement = this.conexao.prepareStatement(
                "SELECT * FROM tbl_reserva WHERE res_id = ?"
            )
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return retornaLista(preparedStatement);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param dataDeEntrada java.sql.Date
     * @return LinkedList<Reserva>
     */
    public LinkedList<Reserva> buscar(Date dataDeEntrada) {
        try(PreparedStatement preparedStatement = this.conexao.prepareStatement(
                "SELECT * FROM tbl_reserva WHERE res_data_entrada = ?"
        )
        ) {
            preparedStatement.setDate(1, dataDeEntrada);
            preparedStatement.execute();
            return retornaLista(preparedStatement);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param valorDePagamento Double
     * @return LinkedList<Reserva>
     */
    public LinkedList<Reserva> buscar(Double valorDePagamento) {
        try(PreparedStatement preparedStatement = this.conexao.prepareStatement(
                "SELECT * FROM tbl_reserva WHERE res_valor = ?"
        )
        ) {
            preparedStatement.setDouble(1, valorDePagamento);
            preparedStatement.execute();
            return retornaLista(preparedStatement);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
