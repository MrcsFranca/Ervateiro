package com.erva.DAO;

import com.erva.model.Entrega;
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
    public void atualizaEntrega(Entrega entrega) throws SQLException{}
    public void removerEntrega(Entrega entrega) throws SQLException{}
    public ArrayList<Entrega> listaTodosEntregas() throws SQLException{
        ArrayList<Entrega> entregas = new ArrayList<>();
        open();
        this.sql = "SELECT * FROM entrega";
        this.preparedStatement = this.connection.prepareStatement(this.sql);
        this.resultSet = this.preparedStatement.executeQuery();
        while(this.resultSet.next()){
            Entrega entregaAux = new Entrega();
            Motorista motoristaAux = new Motorista();
            entregaAux.setEntregaId(this.resultSet.getInt("entregaId"));
            entregaAux.setMotorista(this.resultSet.getString("codMotorista"));
        }
    }
}
