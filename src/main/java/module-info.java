module com.example.passgenerator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens com.example.passgenerator to javafx.fxml;
    exports com.example.passgenerator;
}