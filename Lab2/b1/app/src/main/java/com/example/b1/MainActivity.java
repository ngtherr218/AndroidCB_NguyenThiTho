package com.example.b1;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    FrameLayout main;
    ImageView img;

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
        main = findViewById(R.id.main);
        img = findViewById(R.id.img);

        List<Integer> list = new ArrayList<Integer>();
        list.add(R.drawable.img);
        list.add(R.drawable.img_1);
        list.add(R.drawable.img_2);
        list.add(R.drawable.img_3);
        list.add(R.drawable.img_4);
        list.add(R.drawable.img_5);
        list.add(R.drawable.img_6);
        list.add(R.drawable.img_7);
        list.add(R.drawable.img_8);
        list.add(R.drawable.img_9);
        list.add(R.drawable.img_10);
        list.add(R.drawable.img_11);
        list.add(R.drawable.img_12);
        list.add(R.drawable.img_13);
        list.add(R.drawable.img_14);
        list.add(R.drawable.img_15);
        list.add(R.drawable.img_16);
        list.add(R.drawable.img_17);
        list.add(R.drawable.img_18);
        list.add(R.drawable.img_19);

        int a = new Random().nextInt(list.size());
        img.setImageResource(list.get(a));

        int r = new Random().nextInt(256);
        int g = new Random().nextInt(256);
        int b = new Random().nextInt(256);
        main.setBackgroundColor(Color.rgb(r, g, b));

    }
}