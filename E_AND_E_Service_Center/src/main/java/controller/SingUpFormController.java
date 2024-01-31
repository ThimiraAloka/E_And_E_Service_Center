package controller;

import bo.BoFactory;
import bo.custom.UserBo;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.UserDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class SingUpFormController implements Initializable {

    public AnchorPane paneSingUp;
    public JFXPasswordField txtConfirmPassword;

    public JFXComboBox cmbBoxJobRole;
    private UserBo userBo = BoFactory.getInstance().getBo(BoType.USER);

    public JFXPasswordField txtSecurityCode;
    public JFXTextField txtCreateEmail;
    public JFXPasswordField txtCreatePassword;


    @FXML
    void createAccountButtonOnAction(ActionEvent event)throws SQLException,ClassNotFoundException {

        String encryptedpassword = null;


        if (userBo.isValidPassCode(txtSecurityCode.getText())) {
            new Alert(Alert.AlertType.ERROR, "Register Fail! Input Correct Secure Code Please...").show();

        } else if(!Objects.equals(txtCreatePassword.getText(), "") &&
                  !Objects.equals(txtCreateEmail.getText(), "")){

            if(!txtCreatePassword.getText().equals(txtConfirmPassword.getText())) {
                new Alert(Alert.AlertType.ERROR, "Password is not mach... please enter same password").show();
            }else {
                if (userBo.isValidPassword(txtCreatePassword.getText())) {
                    try {
                        MessageDigest m = MessageDigest.getInstance("MD5");
                        m.update(txtCreatePassword.getText().getBytes());
                        byte[] bytes = m.digest();

                        StringBuilder s = new StringBuilder();
                        for(int i=0; i< bytes.length ;i++)
                        {
                            s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                        }
                        encryptedpassword = s.toString();

                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }

                    UserDto dto = new UserDto(txtCreateEmail.getText(), encryptedpassword, cmbBoxJobRole.getValue().toString() );
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> jobRoles = FXCollections.observableArrayList(
                "Owner",
                "Manager",
                "Employee"
        );
        cmbBoxJobRole.setItems(jobRoles);
    }
}
