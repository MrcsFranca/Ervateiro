package com.erva.DAO;
import java.sql.SQLException;
import java.util.ArrayList;

import com.erva.model.Funcionario;
public interface FuncionarioDAO {
    public void inserirFuncionario(Funcionario funcionario) throws SQLException;
    public void atualizarFuncionario(Funcionario funcionario) throws SQLException;
    public void removerFuncionario(Funcionario funcionario) throws SQLException;
    public ArrayList<Funcionario> listarTodosFuncionario() throws SQLException;
}
