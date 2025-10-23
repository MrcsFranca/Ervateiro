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
        this.sql = "INSERT INTO entrega (codMotorista, fornecedorId, cpf, tipoErva, peso, descricao) VALUES (?, ?, ?, ?, ?, ?) RETURNING entregaId";
        this.preparedStatement = this.connection.prepareStatement(sql);
        //this.preparedStatement.setInt(1, entrega.getEntregaId());
        this.preparedStatement.setString(1, entrega.getMotorista().getCodMotorista());
        this.preparedStatement.setInt(2, entrega.getFornecedor().getFornecedorId());
        this.preparedStatement.setString(3, entrega.getFuncionario().getCpf());
        this.preparedStatement.setString(4, entrega.getTipoErva());
        this.preparedStatement.setDouble(5, entrega.getPeso());
        this.preparedStatement.setString(6, entrega.getDescricao());
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.executeQuery(); // usar executeQuery() porque tem RETURNING
        if (rs.next()) {
            entrega.setEntregaId(rs.getInt("entregaId")); // atualiza o objeto com o ID gerado
        }
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
            entregaAux.setDataHora(this.resultSet.getTimestamp("dataHora"));
            entregaAux.setTipoErva(this.resultSet.getString("tipoErva"));
            entregaAux.setPeso(this.resultSet.getDouble("peso"));
            entregaAux.setDescricao(this.resultSet.getString("descricao"));
            entregas.add(entregaAux);
        }
        close();
        return entregas;
    }
    public ArrayList<Entrega> buscarEntregas(String nomeMotorista, String nomeFornecedor,
                                             Timestamp dataInicio, Timestamp dataFim,
                                             Double pesoMin, Double pesoMax,
                                             String tipoErva) throws SQLException {
        ArrayList<Entrega> entregas = new ArrayList<>();
        open();

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("""
        SELECT e.*, m.nome AS nomeMotorista, f.nome AS nomeFornecedor
        FROM entrega e
        JOIN motorista m ON e.codMotorista = m.codMotorista
        JOIN fornecedor f ON e.fornecedorId = f.fornecedorId
        WHERE 1=1
    """);

        // Lista dinâmica de parâmetros
        ArrayList<Object> params = new ArrayList<>();

        if (nomeMotorista != null && !nomeMotorista.isEmpty()) {
            sqlBuilder.append(" AND m.nome ILIKE ?"); // ILIKE -> busca sem case-sensitive (PostgreSQL)
            params.add("%" + nomeMotorista + "%");
        }
        if (nomeFornecedor != null && !nomeFornecedor.isEmpty()) {
            sqlBuilder.append(" AND f.nome ILIKE ?");
            params.add("%" + nomeFornecedor + "%");
        }
        if (dataInicio != null) {
            sqlBuilder.append(" AND e.dataHora >= ?");
            params.add(dataInicio);
        }
        if (dataFim != null) {
            sqlBuilder.append(" AND e.dataHora <= ?");
            params.add(dataFim);
        }
        if (pesoMin != null) {
            sqlBuilder.append(" AND e.peso >= ?");
            params.add(pesoMin);
        }
        if (pesoMax != null) {
            sqlBuilder.append(" AND e.peso <= ?");
            params.add(pesoMax);
        }
        if (tipoErva != null && !tipoErva.isEmpty()) {
            sqlBuilder.append(" AND e.tipoErva ILIKE ?");
            params.add("%" + tipoErva + "%");
        }

        this.preparedStatement = this.connection.prepareStatement(sqlBuilder.toString());

        for (int i = 0; i < params.size(); i++) {
            this.preparedStatement.setObject(i + 1, params.get(i));
        }

        this.resultSet = this.preparedStatement.executeQuery();
        while (this.resultSet.next()) {
            Entrega entregaAux = new Entrega();
            Funcionario funcionarioAux = new Funcionario(this.resultSet.getString("cpf"));
            Fornecedor fornecedorAux = new Fornecedor(this.resultSet.getInt("fornecedorId"));
            Motorista motoristaAux = new Motorista(this.resultSet.getString("codMotorista"));

            entregaAux.setEntregaId(this.resultSet.getInt("entregaId"));
            entregaAux.setMotorista(motoristaAux);
            entregaAux.setFornecedor(fornecedorAux);
            entregaAux.setFuncionario(funcionarioAux);
            entregaAux.setDataHora(this.resultSet.getTimestamp("dataHora"));
            entregaAux.setTipoErva(this.resultSet.getString("tipoErva"));
            entregaAux.setPeso(this.resultSet.getDouble("peso"));
            entregaAux.setDescricao(this.resultSet.getString("descricao"));
            entregas.add(entregaAux);
        }

        close();
        return entregas;
    }

}
