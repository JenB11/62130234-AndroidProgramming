package com.jenb.ntdat.appdoctruyen;

public class TruyenItem {
    private String title;
    private String lastChapter;
    private String time;
    private String thumbnailUrl;
    private boolean isFull;
    private boolean isNew;

    String trangThai;

    public TruyenItem() {} // Required for Firebase

    // Getters
    public String getTitle() { return title; }
    public String getLastChapter() { return lastChapter; }
    public String getTime() { return time; }
    public String getThumbnailUrl() { return thumbnailUrl; }
    public boolean isFull() { return isFull; }
    public boolean isNew() { return isNew; }
    public String getTrangThai() { return trangThai; }

}
