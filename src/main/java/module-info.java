module com.erva.ervateiro {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    requires java.sql;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.base;

    opens com.erva.main to javafx.fxml;
    opens com.erva.DAO to javafx.fxml;
    opens com.erva.model to javafx.fxml;
    opens com.erva.controller to javafx.fxml;

    exports com.erva.main;
    exports com.erva.DAO;
    exports com.erva.model;
}
