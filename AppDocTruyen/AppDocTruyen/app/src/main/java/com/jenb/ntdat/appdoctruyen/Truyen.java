package com.jenb.ntdat.appdoctruyen;

public class Truyen {
    private String id;
    private String tenTruyen;
    private String anh;
    private String tacGia;
    private String tinhTrang;
    private String theLoai;
    private String lastChapter;
    private String timeUpdate;

    public Truyen() {}
    public Truyen(String id, String tenTruyen, String anh, String timeUpdate, String theLoai, String lastChapter, String tinhTrang, String tacGia) {
        this.id = id;
        this.tenTruyen = tenTruyen;
        this.anh = anh;
        this.timeUpdate = timeUpdate;
        this.theLoai = theLoai;
        this.lastChapter = lastChapter;
        this.tinhTrang = tinhTrang;
        this.tacGia = tacGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenTruyen() {
        return tenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        this.tenTruyen = tenTruyen;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getLastChapter() {
        return lastChapter;
    }

    public void setLastChapter(String lastChapter) {
        this.lastChapter = lastChapter;
    }

    public String getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(String timeUpdate) {
        this.timeUpdate = timeUpdate;
    }
}
