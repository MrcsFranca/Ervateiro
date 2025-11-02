package com.erva.DAO;

import com.erva.model.Fornecedor;
import com.erva.model.Funcionario;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class FornecedorDAOJDBCTest {

    @Test
    void inserirFornecedorInvalido() throws SQLException {
        FornecedorDAOJDBC fornecedorDAOJDBC = new FornecedorDAOJDBC();
        Fornecedor fornecedor = new Fornecedor(123);
        fornecedor.setCpf("12345678134214512341912");
        fornecedor.setNome("NomeTeste");
        fornecedor.setEndereco("Rua teste");
        fornecedor.setFornecedorFisico(true);
        fornecedorDAOJDBC.removerFornecedor(fornecedor);
        assertThrows(org.postgresql.util.PSQLException.class, () -> {
            fornecedorDAOJDBC.inserirFornecedor(fornecedor);
        }, "Erro ao inserir fornecedor invalido, excecao de sql nao lançada");
    }
}