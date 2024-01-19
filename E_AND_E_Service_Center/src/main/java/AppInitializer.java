import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/SingUpForm.fxml"))));
       // stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/PasswordForm.fxml"))));
        stage.centerOnScreen();
        stage.setTitle("Log in Form");
        stage.setResizable(false);
        stage.getIcons().add(new Image("img/appIcon.png"));
        stage.show();
    }
}
