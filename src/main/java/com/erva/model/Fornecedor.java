package com.erva.model;

public class Fornecedor {
    private String fornecedorId;
    private Boolean fornecedorFisico;
    private String nome;
    private String cpf;
    private String cnpj;
    private String endereco;

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
