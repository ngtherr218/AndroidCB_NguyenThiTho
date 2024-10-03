package com.example.truyencuoiapp.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.truyencuoiapp.R;
import com.example.truyencuoiapp.adapter.CategoryAdapter;
import com.example.truyencuoiapp.model.Category;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    RecyclerView rvCategory;
    CategoryAdapter adapter;
    ArrayList<Category> listCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);
        rvCategory = findViewById(R.id.rv_category);

        listCategory = new ArrayList<>();
        listCategory.add(new Category(1, "Con gái", R.drawable.img1));
        listCategory.add(new Category(2, "Con trai", R.drawable.img2));
        listCategory.add(new Category(3, "Công sở", R.drawable.img3));
        listCategory.add(new Category(4, "Cười 18", R.drawable.img4));
        listCategory.add(new Category(5, "Cực hài", R.drawable.img5));
        listCategory.add(new Category(6, "Dân gian", R.drawable.img6));
        listCategory.add(new Category(7, "Gia đình", R.drawable.img7));
        listCategory.add(new Category(8, "Giao thông", R.drawable.img8));
        listCategory.add(new Category(9, "Học sinh", R.drawable.img9));
        listCategory.add(new Category(10, "Giáo viên", R.drawable.img10));
        listCategory.add(new Category(11, "Xã hội", R.drawable.img11));
        listCategory.add(new Category(12, "Đời sống", R.drawable.img12));

        adapter = new CategoryAdapter(listCategory, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        rvCategory.setAdapter(adapter);
        rvCategory.setLayoutManager(linearLayoutManager);


    }
}