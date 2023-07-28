module com.conversor {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.conversor to javafx.fxml;
    exports com.conversor;
}
