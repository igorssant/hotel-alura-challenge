package br.com.alura.hotel.dao;

import br.com.alura.hotel.model.Hospede;
import java.sql.*;
import java.util.LinkedList;

public class HospedeDAO {
    private Connection conexao;

    public HospedeDAO() {
    }

    /**
     * @param conexao Connection
     */
    public HospedeDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * @param preparedStatement PreparedStatment
     * @return LinkedList<Hospede>
     * @throws SQLException
     */
    private LinkedList<Hospede> retornaLista(PreparedStatement preparedStatement) throws SQLException {
        LinkedList<Hospede> hospedes = new LinkedList<Hospede>();

        try(ResultSet resultSet = preparedStatement.getResultSet()) {
            while(resultSet.next()) {
                Hospede hospede = new Hospede(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7)
                );
                hospedes.add(hospede);
            }

            return hospedes;
        }
    }

    /**
     * @return LinkedList<Hospede>
     */
    public LinkedList<Hospede> listar() {
        String codigoSQL = "SELECT * " +
                "FROM tbl_hospede ORDER BY hos_nome";
        try(PreparedStatement preparedStatement = conexao.prepareStatement(codigoSQL)) {
            preparedStatement.execute();
            return retornaLista(preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param hospede Hospede
     */
    public void salvar(Hospede hospede) {
        String codigoSQL = "INSERT INTO tbl_hospede (hos_nome, hos_sobrenome, " +
                "hos_data_nascimento, hos_nacionalidade, " +
                "hos_telefone, res_id_tbl_reserva) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conexao.prepareStatement(codigoSQL, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, hospede.getNome());
            preparedStatement.setString(2, hospede.getSobrenome());
            preparedStatement.setDate(3, hospede.getDataNascimento());
            preparedStatement.setString(4, hospede.getNacionalidade());
            preparedStatement.setString(5, hospede.getTelefone());
            preparedStatement.setInt(6, hospede.getReservaId());
            preparedStatement.execute();
            //ResultSet resultSet = preparedStatement.getGeneratedKeys();
            //return resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id Integer
     */
    public void deletar(Integer id) {
        try(PreparedStatement preparedStatement = conexao.prepareStatement(
                "DELETE FROM tbl_hospede WHERE hos_id = ?"
        )) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param nome String
     * @param sobrenome String
     */
    public void deletar(String nome, String sobrenome) {
        try(PreparedStatement preparedStatement = conexao.prepareStatement(
                "DELETE FROM tbl_hospede WHERE hos_nome = ? " +
                        "AND hos_sobrenome = ?"
        )) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, sobrenome);
            preparedStatement.execute();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id Integer
     * @param nome String
     * @param sobrenome String
     * @param dataNascimento java.sql.Date
     * @param nacionalidade String
     * @param telefone String
     */
    public void alterar(Integer id, String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone) {
        try(PreparedStatement preparedStatement = conexao.prepareStatement(
                "UPDATE tbl_hospede SET " +
                        "hos_nome = ?, hos_sobrenome = ?, " +
                        "hos_data_nascimento = ?, hos_nacionalidade = ?, " +
                        "hos_telefone = ? WHERE hos_id = ?")) {
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, sobrenome);
            preparedStatement.setDate(3, dataNascimento);
            preparedStatement.setString(4, nacionalidade);
            preparedStatement.setString(5, telefone);
            preparedStatement.setInt(6, id);
            preparedStatement.execute();
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param id Integer
     * @return LinkedList<Hospede>
     */
    public LinkedList<Hospede> buscar(Integer id) {
        try(PreparedStatement preparedStatement = conexao.prepareStatement(
            "SELECT * FROM tbl_hospede WHERE hos_id = ?"
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
     * @param nome String
     * @return LinkedList<Hospede>
     */
    public LinkedList<Hospede> buscar(String nome) {
        try(PreparedStatement preparedStatement = conexao.prepareStatement(
                "SELECT * FROM tbl_hospede WHERE hos_nome = ?"
            )
        ) {
            preparedStatement.setString(1, nome);
            preparedStatement.execute();
            return retornaLista(preparedStatement);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param dataNascimento java.sql.Date
     * @return LinkedList<Hospede>
     */
    public LinkedList<Hospede> buscar(Date dataNascimento) {
        try(PreparedStatement preparedStatement = conexao.prepareStatement(
                "SELECT * FROM tbl_hospede WHERE hos_data_nascimento = ?"
            )
        ) {
            preparedStatement.setDate(1, dataNascimento);
            preparedStatement.execute();
            return retornaLista(preparedStatement);
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
