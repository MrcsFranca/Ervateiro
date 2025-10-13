package com.erva.model;

public class Fornecedor {
    private int fornecedorId;
    private Boolean fornecedorFisico;
    private String nome;
    private String cpf;
    private String cnpj;
    private String endereco;

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
}
