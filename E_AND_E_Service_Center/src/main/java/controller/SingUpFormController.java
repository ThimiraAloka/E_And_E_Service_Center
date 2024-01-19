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
    private UserBo userBo = BoFactory.getInstance().getBo(BoType.USER);

    public JFXPasswordField txtSecurityCode;
    public JFXTextField txtCreateEmail;
    public JFXPasswordField txtCreatePassword;

    @FXML
    void createAccountButtonOnAction(ActionEvent event)throws SQLException,ClassNotFoundException {

        if (!Objects.equals(txtSecurityCode.getText(), "e&eAdmin")){
            new Alert(Alert.AlertType.ERROR,"Register Fail! Input Correct Secure Code Please...").show();
        }
            UserDto dto = new UserDto(txtCreateEmail.getText(), txtCreatePassword.getText());

            boolean isSaved = userBo.saveUser(dto);
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"User Registered!").show();
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){}
                Stage stage = (Stage) paneSingUp.getScene().getWindow();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LogInForm.fxml"))));

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.show();

        }
    }

}
