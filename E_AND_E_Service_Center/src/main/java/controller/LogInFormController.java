package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInFormController {

    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public AnchorPane paneLogIn;

    @FXML
    void chagnePasswordButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) paneLogIn.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/PasswordForm.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void logInButtonOnAction(ActionEvent event) {

    }

    public void accountFormButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) paneLogIn.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SingUpForm.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }
}
