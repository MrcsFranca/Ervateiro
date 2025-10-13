package com.erva.model;

public class Funcionario {
    private String cpf;
    private String nome;
    private String numCt;
    private String celular;

    @Override
    public String toString() {
        return "Funcionario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", numCt='" + numCt + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
