module com.music {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires jfugue;
    requires java.desktop;

    /*
    opens com.music to javafx.fxml;
    exports com.music;

    opens com.program to javafx.fxml;
    exports com.program;
     */

    opens com.model to javafx.fxml;
    exports com.model;
}
