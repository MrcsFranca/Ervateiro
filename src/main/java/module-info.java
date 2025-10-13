module com.erva.ervateiro {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.erva.ervateiro to javafx.fxml;
    exports com.erva.ervateiro;
}