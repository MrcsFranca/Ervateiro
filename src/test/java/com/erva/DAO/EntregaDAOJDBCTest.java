package com.erva.DAO;

import com.erva.model.Entrega;
import com.erva.model.Fornecedor;
import com.erva.model.Funcionario;
import com.erva.model.Motorista;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EntregaDAOJDBCTest {

    @Test
    void insereEntregaInvalida() throws SQLException
    {
        EntregaDAOJDBC entregaDAOJDBC = new EntregaDAOJDBC();
        Entrega entrega = new Entrega();
        entrega.setPeso(100.9);
        assertThrows(java.lang.NullPointerException.class, () -> {
            entregaDAOJDBC.insereEntrega(entrega);
        }, "Erro ao inserir motorista invalido, excecao de nullPointer nao lançada");
    }

    @Test
    void insereEntregaValida() throws SQLException
    {
        EntregaDAOJDBC entregaDAOJDBC = new EntregaDAOJDBC();
        MotoristaDAOJDBC motoristaDAOJDBC = new MotoristaDAOJDBC();
        FuncionarioDAOJDBC funcionarioDAOJDBC = new FuncionarioDAOJDBC();
        FornecedorDAOJDBC fornecedorDAOJDBC = new FornecedorDAOJDBC();

        Entrega entrega = new Entrega();
        Motorista motorista = new Motorista("98798798798");
        Fornecedor fornecedor = new Fornecedor();
        Funcionario funcionario = new Funcionario("87687687687");

        motorista.setEquipeColeta(false);
        motorista.setCaminhao("Scania R440");
        motorista.setNome("motorista teste inserir entrega");

        fornecedor.setCnpj(null);
        fornecedor.setCpf("09809809809");
        fornecedor.setNome("fornecedor teste inserir entrega");
        fornecedor.setFornecedorFisico(true);
        fornecedor.setEndereco("Rua dos bobos, 0");

        funcionario.setNome("funcionario teste inserir entrega");
        funcionario.setCelular("40028922");
        funcionario.setNumCt("000000000000");

        entrega.setMotorista(motorista);
        entrega.setFornecedor(fornecedor);
        entrega.setFuncionario(funcionario);
        entrega.setTipoErva("Plantada");
        entrega.setPeso(1000.0);
        entrega.setDescricao("entrega teste inserir entrega");

        motoristaDAOJDBC.inserirMotorista(motorista);
        fornecedorDAOJDBC.inserirFornecedor(fornecedor);
        funcionarioDAOJDBC.inserirFuncionario(funcionario);

        assertDoesNotThrow(() -> {
            entregaDAOJDBC.insereEntrega(entrega);
        }, "Erro ao inserir entrega valida, entrega nao inserida");
        ArrayList<Entrega>entregas = entregaDAOJDBC.buscarEntregas("motorista teste inserir entrega", "fornecedor teste inserir entrega", null, null, 999.00, 1001.00, "Plantada");
        Entrega entrega2 = entregas.getFirst();
        entregaDAOJDBC.removerEntrega(entrega2);
        motoristaDAOJDBC.removerMotorista(motorista);
        fornecedorDAOJDBC.removerFornecedor(fornecedor);
        funcionarioDAOJDBC.removerFuncionario(funcionario);
    }

    @Test
    void buscarEntregaValida() throws SQLException
    {
        EntregaDAOJDBC entregaDAOJDBC = new EntregaDAOJDBC();
        MotoristaDAOJDBC motoristaDAOJDBC = new MotoristaDAOJDBC();
        FuncionarioDAOJDBC funcionarioDAOJDBC = new FuncionarioDAOJDBC();
        FornecedorDAOJDBC fornecedorDAOJDBC = new FornecedorDAOJDBC();

        Entrega entrega = new Entrega();
        Motorista motorista = new Motorista("98798798798");
        Fornecedor fornecedor = new Fornecedor();
        Funcionario funcionario = new Funcionario("87687687687");

        motorista.setEquipeColeta(false);
        motorista.setCaminhao("Scania R440");
        motorista.setNome("motorista teste inserir entrega");

        fornecedor.setCnpj(null);
        fornecedor.setCpf("09809809809");
        fornecedor.setNome("fornecedor teste inserir entrega");
        fornecedor.setFornecedorFisico(true);
        fornecedor.setEndereco("Rua dos bobos, 0");

        funcionario.setNome("funcionario teste inserir entrega");
        funcionario.setCelular("40028922");
        funcionario.setNumCt("000000000000");

        entrega.setMotorista(motorista);
        entrega.setFornecedor(fornecedor);
        entrega.setFuncionario(funcionario);
        entrega.setTipoErva("Plantada");
        entrega.setPeso(1000.0);
        entrega.setDescricao("entrega teste inserir entrega");

        motoristaDAOJDBC.inserirMotorista(motorista);
        fornecedorDAOJDBC.inserirFornecedor(fornecedor);
        funcionarioDAOJDBC.inserirFuncionario(funcionario);
        entregaDAOJDBC.insereEntrega(entrega);

        assertDoesNotThrow(() -> {
            entregaDAOJDBC.buscarEntregas(motorista.getNome(), fornecedor.getNome(), Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.MIN)), Timestamp.valueOf(LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 59, 59))), entrega.getPeso()- 10, entrega.getPeso()+10, entrega.getTipoErva());
        }, "Erro ao buscar a entrega valida, entrega nao encontrada");
        ArrayList<Entrega>entregas = entregaDAOJDBC.buscarEntregas("motorista teste inserir entrega", "fornecedor teste inserir entrega", null, null, 999.00, 1001.00, "Plantada");
        Entrega entrega2 = entregas.getFirst();
        entregaDAOJDBC.removerEntrega(entrega2);
        motoristaDAOJDBC.removerMotorista(motorista);
        fornecedorDAOJDBC.removerFornecedor(fornecedor);
        funcionarioDAOJDBC.removerFuncionario(funcionario);
    }

    @Test
    void removeEntregaValida() throws SQLException
    {
        EntregaDAOJDBC entregaDAOJDBC = new EntregaDAOJDBC();
        MotoristaDAOJDBC motoristaDAOJDBC = new MotoristaDAOJDBC();
        FuncionarioDAOJDBC funcionarioDAOJDBC = new FuncionarioDAOJDBC();
        FornecedorDAOJDBC fornecedorDAOJDBC = new FornecedorDAOJDBC();

        Entrega entrega = new Entrega();
        Motorista motorista = new Motorista("98798798798");
        Fornecedor fornecedor = new Fornecedor();
        Funcionario funcionario = new Funcionario("87687687687");

        motorista.setEquipeColeta(false);
        motorista.setCaminhao("Scania R440");
        motorista.setNome("motorista teste inserir entrega");

        fornecedor.setCnpj(null);
        fornecedor.setCpf("09809809809");
        fornecedor.setNome("fornecedor teste inserir entrega");
        fornecedor.setFornecedorFisico(true);
        fornecedor.setEndereco("Rua dos bobos, 0");

        funcionario.setNome("funcionario teste inserir entrega");
        funcionario.setCelular("40028922");
        funcionario.setNumCt("000000000000");

        entrega.setMotorista(motorista);
        entrega.setFornecedor(fornecedor);
        entrega.setFuncionario(funcionario);
        entrega.setTipoErva("Plantada");
        entrega.setPeso(1000.0);
        entrega.setDescricao("entrega teste inserir entrega");

        motoristaDAOJDBC.inserirMotorista(motorista);
        fornecedorDAOJDBC.inserirFornecedor(fornecedor);
        funcionarioDAOJDBC.inserirFuncionario(funcionario);
        entregaDAOJDBC.insereEntrega(entrega);

        ArrayList<Entrega>entregas = entregaDAOJDBC.buscarEntregas("motorista teste inserir entrega", "fornecedor teste inserir entrega", null, null, 999.00, 1001.00, "Plantada");
        Entrega entrega2 = entregas.getFirst();

        assertDoesNotThrow(() -> {
            entregaDAOJDBC.removerEntrega(entrega2);
        }, "Erro ao remover a entrega");
        motoristaDAOJDBC.removerMotorista(motorista);
        fornecedorDAOJDBC.removerFornecedor(fornecedor);
        funcionarioDAOJDBC.removerFuncionario(funcionario);
    }


}