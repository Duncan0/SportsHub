package SportsHub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SportsHub extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sportsHubInterface.fxml"));
        primaryStage.setTitle("Sports Hub : Social Network");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

}
