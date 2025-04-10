module com.music {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires jfugue;
    requires java.desktop;
    requires junit;

    opens com.music to javafx.fxml;
    exports com.music;
}
