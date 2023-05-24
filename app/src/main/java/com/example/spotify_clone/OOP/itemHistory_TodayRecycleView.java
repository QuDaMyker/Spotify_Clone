package com.example.spotify_clone.OOP;

public class itemHistory_TodayRecycleView {
    private int imageTodayHistory;
    private String titleTodayHistory;
    private String desTodayHistory;

    public itemHistory_TodayRecycleView(int imageTodayHistory, String titleTodayHistory, String desTodayHistory) {
        this.imageTodayHistory = imageTodayHistory;
        this.titleTodayHistory = titleTodayHistory;
        this.desTodayHistory = desTodayHistory;
    }

    public int getImageTodayHistory() {
        return imageTodayHistory;
    }

    public void setImageTodayHistory(int imageTodayHistory) {
        this.imageTodayHistory = imageTodayHistory;
    }

    public String getTitleTodayHistory() {
        return titleTodayHistory;
    }

    public void setTitleTodayHistory(String titleTodayHistory) {
        this.titleTodayHistory = titleTodayHistory;
    }

    public String getDesTodayHistory() {
        return desTodayHistory;
    }

    public void setDesTodayHistory(String desTodayHistory) {
        this.desTodayHistory = desTodayHistory;
    }
}
