package com.jenb.ntdat.replacing_fragments_dynamically;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//1. Tạo DB     openOrCreateDatabase(Tên file csdl, quyen truy cap, null)
        SQLiteDatabase csdl = openOrCreateDatabase("qlSach.db", MODE_PRIVATE,null);
//2. Tạo bảng
//2.1. Lệnh SQL tạo bảng
        String sqlXoaBangSach ="DROP TABLE IF EXISTS BOOKS";
        String sqlTaoBangSach ="CREATE TABLE BOOKS(BookID integer PRIMARY KEY " +
                ", BookName text" +
                ", Page integer"+
                ", Price Float " +
                ", Description text)";
        csdl.execSQL(sqlXoaBangSach);
        csdl.execSQL(sqlTaoBangSach);


    }
}