package com.jenb.ntdat.appdoctruyen;

import java.util.List;

public class TruyenItem {
    private String id;
    private String title;          // Tên truyện
    private String thumbnailPath;   // Ảnh
    private String author;         // Tác giả
    private String status;      // Tình trạng
    private List<String> theloai;
    private String lastChapter;    // Chap mới nhất
    private String time;           // Thời gian cập nhật
    private String manga_slug;

    public TruyenItem() {
    }

    public TruyenItem(String id, String title, String thumbnailUrl, String time, List<String> theLoai,
                      String lastChapter, String tinhTrang, String author, String mangaSlug) {
        this.id = id;
        this.title = title;
        this.thumbnailPath = thumbnailUrl;
        this.time = time;
        this.theloai = theLoai;
        this.lastChapter = lastChapter;
        this.status = tinhTrang;
        this.author = author;
        manga_slug = mangaSlug;

    }


    // ==== Getter & Setter ====
    public String getManga_slug() {
        return manga_slug;
    }
    public void setManga_slug(String manga_slug) {
        this.manga_slug = manga_slug;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String tinhTrang) {
        this.status = tinhTrang;
    }

    public List<String> getTheloai() {
        return theloai;
    }
    public void setTheloai(List<String> theloai) {
        this.theloai = theloai;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTenTruyen() {
        return title;
    }

    public void setTenTruyen(String tenTruyen) {
        this.title = tenTruyen;
    }

    public String getAnh() {
        return thumbnailPath;
    }

    public void setAnh(String anh) {
        this.thumbnailPath = anh;
    }

    public String getTacGia() {
        return author;
    }

    public void setTacGia(String tacGia) {
        this.author = tacGia;
    }

    public String getTimeUpdate() {
        return time;
    }

    public void setTimeUpdate(String timeUpdate) {
        this.time = timeUpdate;
    }
}
