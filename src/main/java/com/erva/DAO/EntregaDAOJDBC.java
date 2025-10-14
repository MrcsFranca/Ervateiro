package com.erva.DAO;

import com.erva.model.Entrega;
import com.erva.model.Fornecedor;
import com.erva.model.Funcionario;
import com.erva.model.Motorista;

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

    public void insereEntrega(Entrega entrega) throws SQLException{
        open();
        this.sql = "INSERT INTO entrega (entregaId, codMotorista, fornecedorId, cpf, dataHora, tipoErva, peso, descricao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, entrega.getEntregaId());
        this.preparedStatement.setString(2, entrega.getMotorista().getCodMotorista());
        this.preparedStatement.setInt(3, entrega.getFornecedor().getFornecedorId());
        this.preparedStatement.setString(4, entrega.getFuncionario().getCpf());
        this.preparedStatement.setTimestamp(5, entrega.getDataHora());
        this.preparedStatement.setString(6, entrega.getTipoErva());
        this.preparedStatement.setDouble(7, entrega.getPeso());
        this.preparedStatement.setString(8, entrega.getDescricao());
        this.preparedStatement.executeUpdate();
        close();
    }
    public void atualizaEntrega(Entrega entrega) throws SQLException{
        open();
        this.sql = "UPDATE Entrega SET codMotorista = ?, fornecedorId = ?, cpf = ?, dataHora = ?, tipoErva = ?, peso = ?, descricao = ? WHERE entregaId = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setString(1, entrega.getMotorista().getCodMotorista());
        this.preparedStatement.setInt(2, entrega.getFornecedor().getFornecedorId());
        this.preparedStatement.setString(3, entrega.getFuncionario().getCpf());
        this.preparedStatement.setTimestamp(4, entrega.getDataHora());
        this.preparedStatement.setString(5, entrega.getTipoErva());
        this.preparedStatement.setDouble(6, entrega.getPeso());
        this.preparedStatement.setString(7, entrega.getDescricao());
        this.preparedStatement.setInt(8, entrega.getEntregaId());
        close();
    }
    public void removerEntrega(Entrega entrega) throws SQLException{
        open();
        this.sql = "DELETE FROM entrega WHERE entregaId = ?";
        this.preparedStatement = this.connection.prepareStatement(sql);
        this.preparedStatement.setInt(1, entrega.getEntregaId());
        this.preparedStatement.executeUpdate();
        close();
    }
    public ArrayList<Entrega> listaTodosEntregas() throws SQLException{
        ArrayList<Entrega> entregas = new ArrayList<>();
        open();
        this.sql = "SELECT * FROM entrega";
        this.preparedStatement = this.connection.prepareStatement(this.sql);
        this.resultSet = this.preparedStatement.executeQuery();
        while(this.resultSet.next()){
            Entrega entregaAux = new Entrega();
            Funcionario funcionarioAux = new Funcionario(this.resultSet.getString("cpf"));
            Fornecedor fornecedorAux = new Fornecedor(this.resultSet.getInt("fornecedorId"));
            Motorista motoristaAux = new Motorista(this.resultSet.getString("codMotorista"));
            entregaAux.setEntregaId(this.resultSet.getInt("entregaId"));
            entregaAux.setMotorista(motoristaAux);
            entregaAux.setFornecedor(fornecedorAux);
            entregaAux.setFuncionario(funcionarioAux);
            entregaAux.setDataHora(resultSet.getTimestamp("dataHora"));
            entregaAux.setTipoErva(resultSet.getString("tipoErva"));
            entregaAux.setPeso(resultSet.getDouble("peso"));
            entregaAux.setDescricao(resultSet.getString("descricao"));
            entregas.add(entregaAux);
        }
        close();
        return entregas;
    }
}
