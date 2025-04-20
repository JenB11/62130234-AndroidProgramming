package com.jenb.ntdat.thanhdat;

public class ActivityChucNang4_HoatDong {
    String tenTieuDe;
    String thoiGian;
    int hinhAnh;

    public ActivityChucNang4_HoatDong(String thoiGian, String tenTieuDe, int hinhAnh) {
        this.thoiGian = thoiGian;
        this.tenTieuDe = tenTieuDe;
        this.hinhAnh = hinhAnh;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTenTieuDe() {
        return tenTieuDe;
    }

    public void setTenTieuDe(String tenTieuDe) {
        this.tenTieuDe = tenTieuDe;
    }
}
