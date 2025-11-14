//Parte da refatoração: criar ENUM para encapsular dados sensíveis do banco de dados

package com.erva.DAO;

public interface IConst {
    public static final String stringDeConexao = String.valueOf(DataBaseConfig.URL.get());
    public static final String usuario =  String.valueOf(DataBaseConfig.USUARIO.get()); //DataBaseConfig.getUser();
    public static final String senha =  String.valueOf(DataBaseConfig.SENHA.get());
}
