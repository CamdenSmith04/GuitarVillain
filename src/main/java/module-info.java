module com.music {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires jfugue;
    requires java.desktop;
    requires junit;
    requires javafx.graphics;

    opens com.music to javafx.fxml;
    exports com.music;

    exports com.model to junit;
}
