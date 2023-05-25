package com.example.spotify_clone.OOP;

public class itemHistory_YesterdayRecycleView {
    private int imageYesterdayHistory;
    private String titleYesterdayHistory;
    private String desYesterdayHistory;

    public itemHistory_YesterdayRecycleView(int imageYesterdayHistory, String titleYesterdayHistory, String desYesterdayHistory) {
        this.imageYesterdayHistory = imageYesterdayHistory;
        this.titleYesterdayHistory = titleYesterdayHistory;
        this.desYesterdayHistory = desYesterdayHistory;
    }

    public int getImageYesterdayHistory() {
        return imageYesterdayHistory;
    }

    public void setImageYesterdayHistory(int imageYesterdayHistory) {
        this.imageYesterdayHistory = imageYesterdayHistory;
    }

    public String getTitleYesterdayHistory() {
        return titleYesterdayHistory;
    }

    public void setTitleYesterdayHistory(String titleYesterdayHistory) {
        this.titleYesterdayHistory = titleYesterdayHistory;
    }

    public String getDesYesterdayHistory() {
        return desYesterdayHistory;
    }

    public void setDesYesterdayHistory(String desYesterdayHistory) {
        this.desYesterdayHistory = desYesterdayHistory;
    }
}
