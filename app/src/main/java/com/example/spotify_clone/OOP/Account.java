package com.example.spotify_clone.OOP;

public class Account {
    private String FullName;
    private String Email;
    private String Password;
    private String DateCreatedAccount;
    private String DateRegPremium;
    private boolean isPremium;

    public Account(String fullName, String email, String password, String dateCreatedAccount, String dateRegPremium, boolean isPremium) {
        FullName = fullName;
        Email = email;
        Password = password;
        DateCreatedAccount = dateCreatedAccount;
        DateRegPremium = dateRegPremium;
        this.isPremium = isPremium;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDateCreatedAccount() {
        return DateCreatedAccount;
    }

    public void setDateCreatedAccount(String dateCreatedAccount) {
        DateCreatedAccount = dateCreatedAccount;
    }

    public String getDateRegPremium() {
        return DateRegPremium;
    }

    public void setDateRegPremium(String dateRegPremium) {
        DateRegPremium = dateRegPremium;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}
