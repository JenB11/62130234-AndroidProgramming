package com.jenb.ntdat.appdoctruyen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

public class TrangChu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_trang_chu);
        RecyclerView recyclerView = findViewById(R.id.rcvTruyen);
        recyclerView.setHasFixedSize(true);
        
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        
        List<TruyenItem> truyenList = new ArrayList<>();
        String serverBaseUrl = "http://10.0.2.2:8080/";
        TruyenAdapter adapter = new TruyenAdapter(this, truyenList, truyenItem -> {
            Intent intent = new Intent(TrangChu.this, ChiTietTruyen.class);
            intent.putExtra("tenTruyen", truyenItem.getTitle());
            intent.putExtra("tacGia", truyenItem.getAuthor());
            intent.putExtra("tinhTrang", truyenItem.getStatus());
            intent.putStringArrayListExtra("theLoai", new ArrayList<>(truyenItem.getTheloai()));
            intent.putExtra("imageUrl", truyenItem.getThumbnailPath());
            intent.putExtra("docId", truyenItem.getId());
            startActivity(intent);
        }, serverBaseUrl);
        recyclerView.setAdapter(adapter);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("truyen")
                .orderBy("time", Query.Direction.DESCENDING)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (DocumentSnapshot doc : queryDocumentSnapshots) {
                        TruyenItem truyen = doc.toObject(TruyenItem.class);
                        truyen.setId(doc.getId());
                        truyenList.add(truyen);
                    }
                    adapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> Log.e("Firestore", "Lỗi: " + e.getMessage()));
    }
}