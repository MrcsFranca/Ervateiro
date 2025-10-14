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
    public void atualizarFornecedor(Fornecedor fornecedor) throws SQLException {
        open();
        this.sql = "UPDATE Fornecedor SET nome = ?, cpf = ?, cnpj = ?, endereco = ?, fornecedorFisico = ? WHERE fornecedorId = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, fornecedor.getNome());
        this.preparedStatement.setString(2, fornecedor.getCpf());
        this.preparedStatement.setString(3, fornecedor.getCnpj());
        this.preparedStatement.setString(4, fornecedor.getEndereco());
        this.preparedStatement.setBoolean(5, fornecedor.getFornecedorFisico());
        this.preparedStatement.setInt(6, fornecedor.getFornecedorId());
        this.preparedStatement.executeUpdate();
        close();
    }
    public void removerFornecedor(Fornecedor fornecedor) throws SQLException {
        open();
        this.sql = "DELETE from fornecedor where fornecedorId = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, fornecedor.getFornecedorId());
        this.preparedStatement.executeUpdate();
        close();

    }
    public ArrayList<Fornecedor> listarTodosFornecedor() throws SQLException {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        open();
        this.sql = "SELECT * FROM fornecedor";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.resultSet = this.preparedStatement.executeQuery();
        while(this.resultSet.next()){
            Fornecedor fornecedorAux = new Fornecedor(this.resultSet.getInt("fornecedorId"));
            fornecedorAux.setCnpj(this.resultSet.getString("cnpj"));
            fornecedorAux.setEndereco(this.resultSet.getString("endereco"));
            fornecedorAux.setCpf(this.resultSet.getString("cpf"));
            fornecedorAux.setNome(this.resultSet.getString("nome"));
            fornecedorAux.setFornecedorFisico(this.resultSet.getBoolean("fisico"));
            fornecedores.add(fornecedorAux);
        }
        close();
        return fornecedores;
    }
}
