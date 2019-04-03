package SportsHub;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.io.*;
import java.util.ArrayList;
import static SportsHub.Main.accounts;


public class MainController {

    public boolean executed=false;

    public Button loginButton, createAccountButton;
    public TextField usernameTF, passwordTF, newUsernameTF, newPasswordTF, newFirstNameTF, newLastNameTF, newPasswordTF1, newEmailTF;


    public void initialize() {
        accountsLoad();
    }

    @FXML
    public void loginClick(ActionEvent event) throws IOException {

        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts.addAll(Main.getAccountList());

        if (usernameTF.getText().equals("") || passwordTF.getText().equals("")) {
            Alert alert2 = new Alert(Alert.AlertType.WARNING, "Please enter a Username and Password ");
            alert2.showAndWait();
        } else {

            for (Account a : accounts) {
                if (usernameTF.getText().equals(a.getAccountUsername()) && (passwordTF.getText().equals(a.getAccountPassword()))) {
                    Main.setCurrentAccount(a);
                    Window mainWindow = loginButton.getScene().getWindow();
                    Parent editScreeningsRoot = FXMLLoader.load(getClass().getResource("wallPosts.fxml"));
                    mainWindow.getScene().setRoot(editScreeningsRoot);
                    break;

                } else {
                    executed = false;
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Incorrect Username & Password", ButtonType.OK);
                    alert.show();

                }
            }
        }
    }


    public void createAccount(ActionEvent actionEvent) throws IOException {

        String newUsername = newUsernameTF.getText();
        String newPassword = newPasswordTF.getText();
        String newFirstName = newFirstNameTF.getText();
        String newLastName = newLastNameTF.getText();
        String newEmailAddress = newEmailTF.getText();

        if (newUsername.equals("") || newPassword.equals("") ||
                newFirstName.equals("") || newLastName.equals("") || newEmailAddress.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Please Enter First and Last Name, Username, Password and Email Address ");
            alert.showAndWait();
        }
            else if (!newPasswordTF.getText().equals(newPasswordTF1.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Passwords are not the same");
            alert.showAndWait();

            } else {

            accounts.add(new Account(newUsername, newPassword, newFirstName, newLastName, newEmailAddress));

            Writer writer = null;
            try {
                File file = new File("src/SportsHub/csv/accountList.csv");
                writer = new BufferedWriter(new FileWriter(file));
                for (Account account : accounts) {

                    String text = account.getAccountUsername() + "," + account.getAccountPassword() + "," + account.getAccountFirstName() + "," + account.getAccountLastName() + "," + account.getAccountEmailAddress() + "\n";

                    writer.write(text);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Account Created!", ButtonType.OK);
                alert.showAndWait();

                assert writer != null;
                writer.flush();
                writer.close();

            }

        }
    }

    @FXML
    private void accountsLoad() {
        String CsvFile = "src/SportsHub/csv/accountList.csv";

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(CsvFile));

            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");

                Account account = createAccount(attributes);
                accounts.add(account);


            }

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.WARNING,
                    "Failed to Load Account Data", ButtonType.OK);
            alert.showAndWait();

            System.out.println("Error : " + e);
        }
    }
    private static Account createAccount(String[] metadata) {
        String username = metadata[0];
        String password = metadata[1];
        String firstName = metadata[2];
        String lastName = metadata[3];
        String email = metadata[4];

        // create and return account of this metadata
        return new Account(username, password, firstName, lastName, email);
    }
}

