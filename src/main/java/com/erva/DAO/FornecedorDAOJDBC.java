package com.erva.DAO;
import com.erva.model.Fornecedor;
import java.util.ArrayList;
import java.sql.*;

public class FornecedorDAOJDBC implements FornecedorDAO {
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

    public void inserirFornecedor(Fornecedor fornecedor) throws SQLException{}
    public void atualizarFornecedor(Fornecedor fornecedor){}
    public void removerFornecedor(Fornecedor fornecedor){}
    public ArrayList<Fornecedor> listarTodosFornecedor(){}
}
