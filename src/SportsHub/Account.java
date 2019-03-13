package SportsHub;

import java.util.ArrayList;

public class Account {

    private String accountUsername;
    private String accountNumber;
    private String accountPassword;
    private ArrayList<Account> accounts;

    

    public String getAccountUsername() {
        return accountUsername;
    }

    public void setAccountUsername(String accountUsername) {
        this.accountUsername = accountUsername;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }


    public Account (String accountUsername, String accountNumber, String accountPassword) {
        this.accountUsername = accountUsername;
        this.accountNumber = accountNumber;
        this.accountPassword = accountPassword;
    }

}
