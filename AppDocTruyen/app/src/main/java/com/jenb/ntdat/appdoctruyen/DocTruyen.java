package com.jenb.ntdat.appdoctruyen;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class DocTruyen extends AppCompatActivity {

    LinearLayout layoutImages;
    FirebaseFirestore db;
    FirebaseStorage storage;
    Button btnPrevChapter, btnNextChapter;
    TextView txtChuong;
    ArrayList<String> chapterIds;
    ArrayList<String> chapterTitles;
    int currentChapterIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_doc_truyen);
        txtChuong = findViewById(R.id.txtChuong);
        layoutImages = findViewById(R.id.layoutImages);
        db = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();
        String chapterTitle = getIntent().getStringExtra("chapterTitle");
        String chapterId = getIntent().getStringExtra("chapterId");

        chapterIds = getIntent().getStringArrayListExtra("chapterIds");
        chapterTitles = getIntent().getStringArrayListExtra("chapterTitles");
        if (chapterId == null || chapterId.isEmpty()) {
            Toast.makeText(this, "Không nhận được ID chương", Toast.LENGTH_SHORT).show();
            return;
        }
        if (chapterIds != null) {
            currentChapterIndex = chapterIds.indexOf(chapterId);
        }

        if (chapterTitle != null && !chapterTitle.isEmpty()) {
            txtChuong.setText(chapterTitle);
        } else {
            txtChuong.setText("Tiêu đề chương không rõ");
        }

        loadImages(chapterId);

        btnPrevChapter = findViewById(R.id.btnPrevChapter);
        btnNextChapter = findViewById(R.id.btnNextChapter);

        btnPrevChapter.setOnClickListener(v -> {
            if (chapterIds != null && currentChapterIndex > 0) {
                currentChapterIndex--;
                String prevId = chapterIds.get(currentChapterIndex);
                String prevTitle = chapterTitles.get(currentChapterIndex);
                txtChuong.setText(prevTitle);
                loadImages(prevId);
            } else {
                Toast.makeText(this, "Đây là chương đầu tiên", Toast.LENGTH_SHORT).show();
            }
        });

        btnNextChapter.setOnClickListener(v -> {
            if (chapterIds != null && currentChapterIndex < chapterIds.size() - 1) {
                currentChapterIndex++;
                String nextId = chapterIds.get(currentChapterIndex);
                String nextTitle = chapterTitles.get(currentChapterIndex);
                txtChuong.setText(nextTitle);
                loadImages(nextId);
            } else {
                Toast.makeText(this, "Đây là chương cuối cùng", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void loadImages(String chapterId) {
        db.collection("chitietchapter")
                .document(chapterId)
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        List<String> images = (List<String>) documentSnapshot.get("images");
                        if (images != null && !images.isEmpty()) {
                            layoutImages.removeAllViews();

                            for (String imageUrl : images) {
                                if (imageUrl == null || imageUrl.isEmpty()) continue;

                                String fixedImageUrl = imageUrl.replace("\\", "/");

                                String fullUrl = "http://10.0.2.2:8080/" + fixedImageUrl;

                                Log.d("DocTruyen", "Loading image URL: " + fullUrl);

                                ImageView imageView = new ImageView(this);
                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.MATCH_PARENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT);
                                params.setMargins(0, 16, 0, 16);
                                imageView.setLayoutParams(params);
                                imageView.setAdjustViewBounds(true);

                                Glide.with(this)
                                        .load(fullUrl)
                                        .placeholder(R.drawable.nen1)
                                        .error(R.drawable.nen1)
                                        .into(imageView);

                                layoutImages.addView(imageView);
                            }

                        } else {
                            Toast.makeText(this, "Chương chưa có ảnh", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(this, "Chương không tồn tại", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Lỗi tải ảnh: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

}