package com.example.spotify_clone.Activity.OOP;

public class itemTabLayout {
    private int Image;
    private String Singer;
    private String Des;

    public itemTabLayout(int image, String singer, String des) {
        Image = image;
        Singer = singer;
        Des = des;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getSinger() {
        return Singer;
    }

    public void setSinger(String singer) {
        Singer = singer;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }
}
