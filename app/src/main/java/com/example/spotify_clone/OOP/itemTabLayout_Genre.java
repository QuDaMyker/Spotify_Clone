package com.example.spotify_clone.OOP;

public class itemTabLayout_Genre {
    private int imageGenre;
    private String titleGenre;
    private String desGenre;

    public itemTabLayout_Genre(int imageGenre, String titleGenre, String desGenre) {
        this.imageGenre = imageGenre;
        this.titleGenre = titleGenre;
        this.desGenre = desGenre;
    }

    public int getImageGenre() {
        return imageGenre;
    }

    public void setImageGenre(int imageGenre) {
        this.imageGenre = imageGenre;
    }

    public String getTitleGenre() {
        return titleGenre;
    }

    public void setTitleGenre(String titleGenre) {
        this.titleGenre = titleGenre;
    }

    public String getDesGenre() {
        return desGenre;
    }

    public void setDesGenre(String desGenre) {
        this.desGenre = desGenre;
    }
}
