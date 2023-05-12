package com.example.spotify_clone.OOP;

public class itemTabLayout_Podcast {
    private int imagePodcast;
    private String titlePodcast;
    private String desPodcast;

    public itemTabLayout_Podcast(int imagePodcast, String titlePodcast, String desPodcast) {
        this.imagePodcast = imagePodcast;
        this.titlePodcast = titlePodcast;
        this.desPodcast = desPodcast;
    }

    public int getImagePodcast() {
        return imagePodcast;
    }

    public void setImagePodcast(int imagePodcast) {
        this.imagePodcast = imagePodcast;
    }

    public String getTitlePodcast() {
        return titlePodcast;
    }

    public void setTitlePodcast(String titlePodcast) {
        this.titlePodcast = titlePodcast;
    }

    public String getDesPodcast() {
        return desPodcast;
    }

    public void setDesPodcast(String desPodcast) {
        this.desPodcast = desPodcast;
    }
}
