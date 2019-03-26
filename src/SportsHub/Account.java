package SportsHub;

import java.util.ArrayList;

public class Account {

    private String accountUsername;
    private String accountPassword;
    private String accountFirstName;
    private String accountLastName;

    @Override
    public String toString() {
        return "Account{" +
                "accountUsername='" + accountUsername + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", accountFirstName='" + accountFirstName + '\'' +
                ", accountLastName='" + accountLastName + '\'' +
                ", accountEmailAddress='" + accountEmailAddress + '\'' +
                '}';
    }

    private String accountEmailAddress;




    public String getAccountUsername() {
        return accountUsername;
    }
    public void setAccountUsername(String accountUsername) {
        this.accountUsername = accountUsername;
    }


    public String getAccountPassword() {
        return accountPassword;
    }
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }


    public String getAccountFirstName() {
        return accountFirstName;
    }
    public void setAccountFirstName(String accountFirstName) {
        this.accountFirstName = accountFirstName;
    }


    public String getAccountLastName() {
        return accountLastName;
    }
    public void setAccountLastName(String accountLastName) {
        this.accountLastName = accountLastName;
    }


    public String getAccountEmailAddress() {
        return accountEmailAddress;
    }
    public void setAccountEmailAddress(String emailAddress) {
        this.accountEmailAddress = emailAddress;
    }


    public Account (String accountUsername, String accountPassword, String accountFirstName, String accountLastName, String emailAddress) {
        this.accountUsername = accountUsername;
        this.accountPassword = accountPassword;
        this.accountFirstName = accountFirstName;
        this.accountLastName = accountLastName;
        this.accountEmailAddress = emailAddress;

    }

}
