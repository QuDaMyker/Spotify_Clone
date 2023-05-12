package com.example.spotify_clone.OOP;

public class TodayHits {
    private int imageAlbum;
    private String titleAlbum;
    private String desAlbum;

    public TodayHits(int imageAlbum, String titleAlbum, String desAlbum) {
        this.imageAlbum = imageAlbum;
        this.titleAlbum = titleAlbum;
        this.desAlbum = desAlbum;
    }

    public int getImageAlbum() {
        return imageAlbum;
    }

    public void setImageAlbum(int imageAlbum) {
        this.imageAlbum = imageAlbum;
    }

    public String getTitleAlbum() {
        return titleAlbum;
    }

    public void setTitleAlbum(String titleAlbum) {
        this.titleAlbum = titleAlbum;
    }

    public String getDesAlbum() {
        return desAlbum;
    }

    public void setDesAlbum(String desAlbum) {
        this.desAlbum = desAlbum;
    }
}
