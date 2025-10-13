package com.erva.DAO;
import java.util.ArrayList;

import com.erva.model.Funcionario;
public interface FuncionarioDAO {
    public void inserirFuncionario(Funcionario funcionario);
    public void atualizarFuncionario(Funcionario funcionario);
    public void removerFuncionario(Funcionario funcionario);
    public ArrayList<Funcionario> listarTodosFuncionario();
}
