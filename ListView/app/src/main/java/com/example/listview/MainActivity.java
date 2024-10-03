package com.example.listview;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listview.adapter.ListAdapter;
import com.example.listview.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Product> listProduct;
    ListAdapter productListViewAdapter;
    ListView listViewProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Khoi tao ListProduct
        listProduct = new ArrayList<>();
        listProduct.add(new Product(1, "Iphone 6", 500));
        listProduct.add(new Product(2, "Iphone 7", 700));
        listProduct.add(new Product(3, "Sony Abc", 800));
        listProduct.add(new Product(4, "Samsung XYZ", 900));
        listProduct.add(new Product(5, "SP 5", 500));
        listProduct.add(new Product(6, "SP 6", 700));
        listProduct.add(new Product(7, "SP 7", 800));
        listProduct.add(new Product(8, "SP 8", 900));
        listProduct.add(new Product(11, "Iphone 6", 500));
        listProduct.add(new Product(12, "Iphone 7", 700));
        listProduct.add(new Product(13, "Sony Abc", 800));
        listProduct.add(new Product(14, "Samsung XYZ", 900));
        listProduct.add(new Product(15, "SP 5", 500));
        listProduct.add(new Product(16, "SP 6", 700));
        listProduct.add(new Product(17, "SP 7", 800));
        listProduct.add(new Product(18, "SP 8", 900));

        productListViewAdapter = new ListAdapter(listProduct);
        listViewProduct = findViewById(R.id.lv);
        listViewProduct.setAdapter(productListViewAdapter);
    }
}