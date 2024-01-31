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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

public class LogInFormController {

    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public AnchorPane paneLogIn;
    private UserBo usersBo = BoFactory.getInstance().getBo(BoType.USER);
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
    void logInButtonOnAction(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String encryptedpassword = null;
        List<UserDto> dtoList = usersBo.allUser();
        for (UserDto dto:dtoList) {
            Stage stage = (Stage) paneLogIn.getScene().getWindow();
            if(dto.getEmail().equals(txtEmail.getText())){
                try {
                    MessageDigest m = MessageDigest.getInstance("MD5");
                    m.update(txtPassword.getText().getBytes());
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
                if (dto.getPassword().equals(encryptedpassword)) {
                    if(dto.getJobRole().equals("Employee")) {
                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForEmployeeForm.fxml"))));
                        stage.setTitle("DashBoard Form");
                        stage.show();
                    }if(dto.getJobRole().equals("Owner") || dto.getJobRole().equals("Manager") ) {

                        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForAdminForm.fxml"))));
                        stage.setTitle("DashBoard Form");
                        stage.show();
                    }
                }
            }
        }
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
