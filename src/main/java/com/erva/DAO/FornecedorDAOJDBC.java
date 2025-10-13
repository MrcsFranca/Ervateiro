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

    public void inserirFornecedor(Fornecedor fornecedor) throws SQLException{
        open();
        this.sql = "INSERT INTO fornecedor (fornecedorId, nome, cpf, cnpj, endereco, fornecedorFisico) VALUES (?, ?, ?, ?, ?, ?)";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, fornecedor.getFornecedorId());
        this.preparedStatement.setString(2, fornecedor.getNome());
        this.preparedStatement.setString(3, fornecedor.getCpf());
        this.preparedStatement.setString(4, fornecedor.getCnpj());
        this.preparedStatement.setString(5, fornecedor.getEndereco());
        this.preparedStatement.setBoolean(6, fornecedor.getFornecedorFisico());

        this.preparedStatement.executeUpdate();
        close();
    }
    public void atualizarFornecedor(Fornecedor fornecedor){}
    public void removerFornecedor(Fornecedor fornecedor){}
    public ArrayList<Fornecedor> listarTodosFornecedor(){}
}
