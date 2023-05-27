package com.example.spotify_clone.OOP;

public class Account {
    private String ID;
    private String FullName;
    private String Email;
    private String Password;
    private String DateCreatedAccount;
    private String DateRegPremium;
    private boolean isPremium;
    private String ImageProfile;

    public Account() {
    }

    public Account(String ID, String fullName, String email, String password, String dateCreatedAccount, String dateRegPremium, boolean isPremium, String imageProfile) {
        this.ID = ID;
        FullName = fullName;
        Email = email;
        Password = password;
        DateCreatedAccount = dateCreatedAccount;
        DateRegPremium = dateRegPremium;
        this.isPremium = isPremium;
        ImageProfile = imageProfile;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getImageProfile() {
        return ImageProfile;
    }

    public void setImageProfile(String imageProfile) {
        ImageProfile = imageProfile;
    }
}
