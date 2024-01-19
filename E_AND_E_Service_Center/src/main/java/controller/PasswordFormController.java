package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class PasswordFormController {


    public JFXTextField txtEmail;
    public JFXTextField txtOTP;
    public AnchorPane panePswrd;

    @FXML
    void backLogInButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) panePswrd.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LogInForm.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void checkOTPButtonOnAction(ActionEvent event) {

    }

    @FXML
    void sendOTPButtonOnAction(ActionEvent event) {

    }

}
