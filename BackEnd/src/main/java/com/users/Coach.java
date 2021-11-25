package com.users;

public class Coach {
    private AccountInformations accountCredentials;
    private UserInformations userInformations;
    public Coach(AccountInformations accountCredentials, UserInformations userInformations){
        this.accountCredentials = accountCredentials;
        this.userInformations = userInformations;
    }

    public AccountInformations getAccountCredentials() {
        return accountCredentials;
    }

    public UserInformations getUserInformations() {
        return userInformations;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "accountCredentials=" + accountCredentials +
                ", userInformations=" + userInformations +
                '}';
    }
}
