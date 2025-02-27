module com.music {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires jfugue;

    opens com.music to javafx.fxml;
    exports com.music;

    opens com.program to javafx.fxml;
    exports com.program;
}
