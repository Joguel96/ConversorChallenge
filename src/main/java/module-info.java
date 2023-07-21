module com.conversor {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.conversor to javafx.fxml;
    exports com.conversor;
}
