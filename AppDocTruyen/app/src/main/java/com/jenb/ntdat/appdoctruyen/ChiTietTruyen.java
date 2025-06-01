package com.jenb.ntdat.appdoctruyen;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ChiTietTruyen extends AppCompatActivity {

    ListView lvChapters;

    FirebaseFirestore db;
    ChapterAdapter chapterAdapter;
    List<ChapterItem> chapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chi_tiet_truyen);


        // Nhận dữ liệu từ intent
        Intent intent = getIntent();
        String tenTruyen = intent.getStringExtra("tenTruyen");
        String tacGia = intent.getStringExtra("tacGia");
        String tinhTrang = intent.getStringExtra("tinhTrang");
        ArrayList<String> theLoai = intent.getStringArrayListExtra("theLoai");
        if (theLoai == null || theLoai.isEmpty()) {
            theLoai = new ArrayList<>();
            theLoai.add("Chưa rõ");
        }
        if (tacGia == null || tacGia.trim().isEmpty()) {
            tacGia = "Chưa rõ";
        }
        String imageUrl = intent.getStringExtra("imageUrl");
        String mangaId = intent.getStringExtra("docId");

        TextView tvTenTruyen = findViewById(R.id.textTen);
        TextView tvTacGia = findViewById(R.id.txtTacGia);
        TextView tvTinhTrang = findViewById(R.id.txtTinhTrang);
        TextView tvTheLoai = findViewById(R.id.txtTheLoai);
        ImageView imgTruyen = findViewById(R.id.imgTruyen1);

        tvTenTruyen.setText(tenTruyen);
        tvTacGia.setText(tacGia);
        tvTinhTrang.setText(tinhTrang);
        tvTheLoai.setText(TextUtils.join(", ", theLoai));

        // Load ảnh bằng Glide
        Glide.with(this)
                .load("http://10.0.2.2:8080/" + imageUrl)
                .placeholder(R.drawable.nen1)
                .into(imgTruyen);

        lvChapters = findViewById(R.id.lvChapters);
        chapterList = new ArrayList<>();
        chapterAdapter = new ChapterAdapter(this, chapterList);
        lvChapters = findViewById(R.id.lvChapters);
        lvChapters.setAdapter(chapterAdapter);


        if (mangaId != null && !mangaId.isEmpty()) {
            loadChapterList(mangaId);
        } else {
            Toast.makeText(this, "Không có ID để tải chương", Toast.LENGTH_SHORT).show();
        }

        lvChapters.setOnItemClickListener((parent, view, position, id) -> {
            ChapterItem selectedChapter = chapterList.get(position);
            String chapterId = selectedChapter.getId();
            String chapterTitle = selectedChapter.getChapter();
            if (chapterId != null && !chapterId.isEmpty()) {

                ArrayList<String> chapterIds = new ArrayList<>();
                ArrayList<String> chapterTitles = new ArrayList<>();
                for (ChapterItem item : chapterList) {
                    chapterIds.add(item.getId());
                    chapterTitles.add(item.getChapter());
                }

                Intent intentDocTruyen = new Intent(ChiTietTruyen.this, DocTruyen.class);
                intentDocTruyen.putExtra("chapterId", chapterId);
                intentDocTruyen.putExtra("chapterTitle", chapterTitle);

                intentDocTruyen.putStringArrayListExtra("chapterIds", chapterIds);
                intentDocTruyen.putStringArrayListExtra("chapterTitles", chapterTitles);
                startActivity(intentDocTruyen);
            } else {
                Toast.makeText(ChiTietTruyen.this, "Chương không có ID", Toast.LENGTH_SHORT).show();
            }
        });


    }
    private void loadChapterList(String mangaId) {
        db = FirebaseFirestore.getInstance();

        db.collection("chapters")
                .whereEqualTo("id", mangaId)
                .orderBy("chapter")
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    chapterList.clear();
                    for (DocumentSnapshot doc : queryDocumentSnapshots) {
                        String chapterTitle = doc.getString("chapter");
                        String time = doc.getString("time");
                        if (chapterTitle != null) {
                            chapterList.add(new ChapterItem(chapterTitle, time, doc.getId()));
                        }
                    }

                    Collections.sort(chapterList, Comparator.comparingInt(ChapterItem::getChapterNumber));
                    chapterAdapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Lỗi tải chương: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

}