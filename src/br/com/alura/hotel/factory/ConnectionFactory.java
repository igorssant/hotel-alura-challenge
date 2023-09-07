package br.com.alura.hotel.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private DataSource dataSource;
    private final String usuario = "admin";
    private final String senha = "admin";
    private final String bancoDeDados = "hotel_alura";
    private final String path = "jdbc:mysql://localhost/"+bancoDeDados+"?useTimezone=true&serverTimezone=UTC";

    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(this.path);
        comboPooledDataSource.setUser(this.usuario);
        comboPooledDataSource.setPassword(this.senha);
        this.dataSource = comboPooledDataSource;
    }

    public ConnectionFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * Metodo que retorna uma conexao
     * de uma pool de conexoes
     * em caso de erro sobe uma
     * RuntimeException
     * @return dataSource
     */
    public Connection recuperarConexao() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
