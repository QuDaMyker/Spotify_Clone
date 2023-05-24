package com.example.spotify_clone.OOP;

public class itemPlaylist_PlaylistRecycleView {
    private int imagePlaylist;
    private String titlePlaylist;
    private String countSongPlaylist;

    public itemPlaylist_PlaylistRecycleView(int imagePlaylist, String titlePlaylist, String countSongPlaylist) {
        this.imagePlaylist = imagePlaylist;
        this.titlePlaylist = titlePlaylist;
        this.countSongPlaylist = countSongPlaylist;
    }

    public int getImagePlaylist() {
        return imagePlaylist;
    }

    public void setImagePlaylist(int imagePlaylist) {
        this.imagePlaylist = imagePlaylist;
    }

    public String getTitlePlaylist() {
        return titlePlaylist;
    }

    public void setTitlePlaylist(String titlePlaylist) {
        this.titlePlaylist = titlePlaylist;
    }

    public String getCountSongPlaylist() {
        return countSongPlaylist;
    }

    public void setCountSongPlaylist(String countSongPlaylist) {
        this.countSongPlaylist = countSongPlaylist;
    }
}
