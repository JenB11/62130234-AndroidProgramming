package com.jenb.ntdat.appdoctruyen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

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
        TruyenAdapter adapter = new TruyenAdapter(this, truyenList);

        recyclerView.setAdapter(adapter);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("truyen")
                .orderBy("time", Query.Direction.DESCENDING)
                .get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    for (DocumentSnapshot doc : queryDocumentSnapshots) {
                        TruyenItem truyen = doc.toObject(TruyenItem.class);
                        truyenList.add(truyen);
                    }
                    adapter.notifyDataSetChanged();
                })
                .addOnFailureListener(e -> Log.e("Firestore", "Lỗi: " + e.getMessage()));

//        TruyenAdapter truyenAdapter = new TruyenAdapter(this, truyenList, Truyen -> {
//            Intent intent = new Intent(TrangChu.this, ChiTietTruyen.class);
//            intent.putExtra("tenTruyen", Truyen.gettenTruyen());
//            intent.putExtra("tacGia", Truyen.getTacGia());
//            intent.putExtra("tinhTrang", Truyen.getTinhTrang());
//            intent.putExtra("theLoai", Truyen.getTheLoai());
//            intent.putExtra("imageUrl", Truyen.getAnh());
//            intent.putExtra("docId", Truyen.getId());  // ID dùng để lấy danh sách chapter
//            startActivity(intent);
//        });
//        recyclerView.setAdapter(truyenAdapter);
        //Xử lý sự kiện khi nhấn vào item

    }
}