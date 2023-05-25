package com.example.spotify_clone.OOP;

public class itemProfile_MostlyPlayed_RecycleView {
    private int imageProfile_MostlyPlayed;
    private String titleProfile_MostlyPlayed;
    private String desProfile_MostlyPlayed;

    public itemProfile_MostlyPlayed_RecycleView(int imageProfile_MostlyPlayed, String titleProfile_MostlyPlayed, String desProfile_MostlyPlayed) {
        this.imageProfile_MostlyPlayed = imageProfile_MostlyPlayed;
        this.titleProfile_MostlyPlayed = titleProfile_MostlyPlayed;
        this.desProfile_MostlyPlayed = desProfile_MostlyPlayed;
    }

    public int getImageProfile_MostlyPlayed() {
        return imageProfile_MostlyPlayed;
    }

    public void setImageProfile_MostlyPlayed(int imageProfile_MostlyPlayed) {
        this.imageProfile_MostlyPlayed = imageProfile_MostlyPlayed;
    }

    public String getTitleProfile_MostlyPlayed() {
        return titleProfile_MostlyPlayed;
    }

    public void setTitleProfile_MostlyPlayed(String titleProfile_MostlyPlayed) {
        this.titleProfile_MostlyPlayed = titleProfile_MostlyPlayed;
    }

    public String getDesProfile_MostlyPlayed() {
        return desProfile_MostlyPlayed;
    }

    public void setDesProfile_MostlyPlayed(String desProfile_MostlyPlayed) {
        this.desProfile_MostlyPlayed = desProfile_MostlyPlayed;
    }
}
