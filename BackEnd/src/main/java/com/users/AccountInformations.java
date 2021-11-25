package com.users;

public class AccountInformations {
    private String username;
    private String password;
    public AccountInformations(String username, String password){
        this.username = username;
        this.password = password;
    }
    public void ChangeUsername(String newUsername){
        this.username = newUsername;
    }
    public void ChangePassword(String newPassword){
        this.password = newPassword;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "AccountInformations{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
