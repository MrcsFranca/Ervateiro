//Parte da refatoração: Mudança do nome da classe para condizer melhor com seu propósito
//Parte da refatoração: Foram removidos vários métodos redundantes de varias classes
package com.erva.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ErvateiroApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/erva/ervateiro/Menu.fxml"));
        Scene scene = new Scene(loader.load());
        primaryStage.setTitle("Tabela de Entregas");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setMaximized(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
