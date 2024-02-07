package controller;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static controller.LogInFormController.stillUser;

public class DashboardForEmployeeFormController {

    public Label lblDate;
    public Label lblTime;

    public void initialize(){
        calculateTime();
    }

    private void calculateTime() {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.ZERO,
                actionEvent -> lblTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")))
        ),
                new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Timeline date = new Timeline((new KeyFrame(
                Duration.ZERO,
                actionEvent -> lblDate.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
        )), new KeyFrame(Duration.seconds(1)));
        date.setCycleCount(Animation.INDEFINITE);
        date.play();

    }

    @FXML
    public void customerBtnOnAction(ActionEvent event)  {

        Stage stage = (Stage) lblDate.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerAddingForm.fxml"))));
            stage.setTitle("Customer Adding Form");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.centerOnScreen();
    }

    @FXML
    void itemBtnOnAction(ActionEvent event) {
        Stage stage = (Stage) lblDate.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ItemAddingForm.fxml"))));
            stage.setTitle("Item Adding Form");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void placeOrderBtnOnAction(ActionEvent event) {

    }

    @FXML
    void statusBtnOnAction(ActionEvent event) {

    }
    @FXML
    void logOutBtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) lblDate.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LogInForm.fxml"))));
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
