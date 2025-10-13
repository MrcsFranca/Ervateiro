package com.erva.DAO;

import com.erva.model.Entrega;
import java.util.ArrayList;
import java.sql.*;

public class EntregaDAOJDBC implements EntregaDAO {

    private String sql;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    private void open() throws SQLException {
        this.connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
    }

    private void close() throws SQLException {
        this.connection.close();
    }

    public void insereEntrega(Entrega entrega) throws SQLException{}
    public void atualizaEntrega(Entrega entrega) throws SQLException{}
    public void removerEntrega(Entrega entrega) throws SQLException{}
    public ArrayList<Entrega> listaTodosEntregas() throws SQLException{}
}
