package com.erva.DAO;
import java.util.ArrayList;

import com.erva.model.Motorista;
public interface MotoristaDAO {
    public void inserirMotorista(Motorista motorista);
    public void atualizarMotorista(Motorista motorista);
    public void removerMotorista(Motorista motorista);
    public ArrayList<Motorista> listarTodosMotorista();
}
