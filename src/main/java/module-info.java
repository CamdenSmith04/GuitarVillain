module grass {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens grass to javafx.fxml;
    exports grass;

    opens model to javafx.fxml;
    exports model;

    opens com.program to javafx.fxml;
    exports com.program;
}
