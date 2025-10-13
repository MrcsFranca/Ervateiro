package com.erva.model;

public class Funcionario {
    private String cpf;
    private String nome;
    private String numCt;
    private String celular;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumCt() {
        return numCt;
    }

    public String getCelular() {
        return celular;
    }

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
