package com.jenb.ntdat.luyentap;

public class ListViewCuaCaiGiDo {
    String tenItem;
    String noiDungItem;
    int anhItem;

    public ListViewCuaCaiGiDo(String tenItem, String noiDungItem, int anhItem) {
        this.tenItem = tenItem;
        this.noiDungItem = noiDungItem;
        this.anhItem = anhItem;
    }

    public String getTenItem() {
        return tenItem;
    }

    public void setTenItem(String tenItem) {
        this.tenItem = tenItem;
    }

    public String getNoiDungItem() {
        return noiDungItem;
    }

    public void setNoiDungItem(String noiDungItem) {
        this.noiDungItem = noiDungItem;
    }

    public int getAnhItem() {
        return anhItem;
    }

    public void setAnhItem(int anhItem) {
        this.anhItem = anhItem;
    }
}
