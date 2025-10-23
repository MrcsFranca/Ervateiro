package com.erva.model;

public class Fornecedor {
    private int fornecedorId;
    private Boolean fornecedorFisico;
    private String nome;
    private String cpf;
    private String cnpj;
    private String endereco;

    public void setFornecedorFisico(Boolean fornecedorFisico) {
        this.fornecedorFisico = fornecedorFisico;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Fornecedor(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    public Fornecedor() {}

    public int getFornecedorId() {
        return fornecedorId;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Boolean getFornecedorFisico() {
        return fornecedorFisico;
    }

    /*
    @Override
    public String toString() {
        return "Fornecedor{" +
                "fornecedorId='" + fornecedorId + '\'' +
                ", fornecedorFisico=" + fornecedorFisico +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
     */

    @Override
    public String toString() {
        return this.nome;
    }
}
