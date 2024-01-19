package controller;

import bo.BoFactory;
import bo.custom.UserBo;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class SingUpFormController {

    public AnchorPane paneSingUp;
    public JFXPasswordField txtConfirmPassword;
    private UserBo userBo = BoFactory.getInstance().getBo(BoType.USER);

    public JFXPasswordField txtSecurityCode;
    public JFXTextField txtCreateEmail;
    public JFXPasswordField txtCreatePassword;

    @FXML
    void createAccountButtonOnAction(ActionEvent event)throws SQLException,ClassNotFoundException {

        if (userBo.isValidPassCode(txtSecurityCode.getText())) {
            new Alert(Alert.AlertType.ERROR, "Register Fail! Input Correct Secure Code Please...").show();

        } else if(!Objects.equals(txtCreatePassword.getText(), "") &&
                  !Objects.equals(txtCreateEmail.getText(), "")){

            if(!txtCreatePassword.getText().equals(txtConfirmPassword.getText())) {
                new Alert(Alert.AlertType.ERROR, "Password is not mach... please enter same password").show();
            }else {
                if (userBo.isValidPassword(txtCreatePassword.getText())) {

                    UserDto dto = new UserDto(txtCreateEmail.getText(), txtCreatePassword.getText());
                    boolean isSaved = userBo.saveUser(dto);
                    if (isSaved) {
                        new Alert(Alert.AlertType.INFORMATION, "User Registered!").show();

                        Stage stage = (Stage) paneSingUp.getScene().getWindow();
                        try {
                            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LogInForm.fxml"))));

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        stage.show();
                    }
                } else {
                    new Alert(Alert.AlertType.ERROR, "Password not Strong... *(read) ").show();
                }
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "Please Fill information completely...").show();
        }
    }

    public void logInAccountButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) paneSingUp.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LogInForm.fxml"))));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }
}
