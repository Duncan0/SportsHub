package SportsHub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashSet;

public class Main extends Application {

    static Account currentAccount;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sportsHubInterface.fxml"));
        primaryStage.setTitle("Sports Hub: Social Network");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

    static HashSet<Account> accounts = new HashSet<Account>();

    static HashSet<Account> getAccountList() {

        return accounts;
    }

    static Account getCurrentAccount() {

        return currentAccount;
    }

    static void setCurrentAccount(Account currentAccount) {

        Main.currentAccount = currentAccount;
    }

}
