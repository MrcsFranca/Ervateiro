package com.erva.model;

public class Funcionario {
    private String cpf;
    private String nome;
    private String numCt;
    private String celular;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumCt(String numCt) {
        this.numCt = numCt;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Funcionario(String cpf){
        this.cpf = cpf;
    }

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
        return this.nome;
    }
}
