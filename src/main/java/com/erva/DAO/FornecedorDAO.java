package com.erva.DAO;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erva.model.Fornecedor;
public interface FornecedorDAO {
    public void inserirFornecedor(Fornecedor fornecedor) throws SQLException;
    public void atualizarFornecedor(Fornecedor fornecedor) throws SQLException;
    public void removerFornecedor(Fornecedor fornecedor) throws SQLException;
    public ArrayList<Fornecedor> listarTodosFornecedor() throws SQLException;
}
