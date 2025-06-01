package com.jenb.ntdat.appdoctruyen;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

public class ChiTietTruyen extends AppCompatActivity {

    TextView textTen, txtTacGia, txtTinhTrang, txtTheLoai;
    ImageView imgTruyen1;
    ListView lvChapters;

    FirebaseFirestore db;
    ChapterAdapter chapterAdapter;
    List<String> chapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chi_tiet_truyen);

        textTen = findViewById(R.id.textTen);
        txtTacGia = findViewById(R.id.txtTacGia);
        txtTinhTrang = findViewById(R.id.txtTinhTrang);
        txtTheLoai = findViewById(R.id.txtTheLoai);
        imgTruyen1 = findViewById(R.id.imgTruyen1);
        lvChapters = findViewById(R.id.lvChapters);

        // Lấy dữ liệu từ Intent
        String tenTruyen = getIntent().getStringExtra("tenTruyen");
        String tacGia = getIntent().getStringExtra("tacGia");
        String tinhTrang = getIntent().getStringExtra("tinhTrang");
        String theLoai = getIntent().getStringExtra("theLoai");
        String imageUrl = getIntent().getStringExtra("imageUrl");
        String docId = getIntent().getStringExtra("docId");

        // Gán dữ liệu
        textTen.setText(tenTruyen);
        txtTacGia.setText(tacGia);
        txtTinhTrang.setText(tinhTrang);
        txtTheLoai.setText(theLoai);
        Glide.with(this).load(imageUrl).into(imgTruyen1);  // dùng Glide để load ảnh

        // Load danh sách chapter
        chapterList = new ArrayList<String>();
        chapterAdapter = new ChapterAdapter(this, chapterList);
        lvChapters.setAdapter(chapterAdapter);

        db = FirebaseFirestore.getInstance();
        db.collection("chapters")
                .document(docId)
                .collection("list")
                .orderBy("index", Query.Direction.ASCENDING)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (DocumentSnapshot doc : queryDocumentSnapshots) {
                        String name = doc.getString("name");
                        chapterList.add(tenTruyen);
                    }
                    chapterAdapter.notifyDataSetChanged();
                });

        lvChapters.setOnItemClickListener((adapterView, view, position, id) -> {
            String chapterName = chapterList.get(position);
            Toast.makeText(this, "Đọc: " + chapterName, Toast.LENGTH_SHORT).show();
            // Tùy bạn xử lý chuyển sang trang đọc chapter tại đây
        });
    }
}