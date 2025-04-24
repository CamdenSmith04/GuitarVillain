package com.music;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.model.Facade;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

 /**
 * @author Abby Holdcraft
 */
public class BecomeRoleController implements Initializable {

    private Facade facade;

    @FXML
    private Button becomeStudentButton;

    @FXML
    private Button becomeTeacherButton;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        facade = Facade.getInstance();
    }

    @FXML
    private void becomeStudent() throws IOException {
        if (facade.becomeStudent())
            goBack();
    }

    @FXML
    private void becomeTeacher() throws IOException {
        if (facade.becomeTeacher())
            goBack();
    }

    @FXML
    void goBack() throws IOException {
        App.setRoot("home");
    }

}