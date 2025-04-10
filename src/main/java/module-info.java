module com.music {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.music to javafx.fxml;
    exports com.music;
}
