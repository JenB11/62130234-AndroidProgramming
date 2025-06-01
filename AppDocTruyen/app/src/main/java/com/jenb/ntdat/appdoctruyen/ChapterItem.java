package com.jenb.ntdat.appdoctruyen;

public class ChapterItem {
    private String chapter;
    private String time;
    private String Id;
    public ChapterItem() {}

    public ChapterItem(String chapter, String time, String id) {
        this.chapter = chapter;
        this.time = time;
        Id = id;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getChapterNumber() {
        try {
            return Integer.parseInt(chapter.replaceAll("[^0-9]", ""));
        } catch (Exception e) {
            return 0;
        }
    }

}
