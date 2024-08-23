package com.example.randomapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Activity2 extends AppCompatActivity {
    private Button btRandom;
    private ImageButton ibBack;
    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        iv = findViewById(R.id.iv);
        btRandom = findViewById(R.id.btRandom);
        ibBack = findViewById(R.id.ibBack);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int number = random.nextInt(6);
                switch (number+1){
                    case 1: iv.setImageResource(R.drawable.one);break;
                    case 2: iv.setImageResource(R.drawable.two);break;
                    case 3: iv.setImageResource(R.drawable.three);break;
                    case 4: iv.setImageResource(R.drawable.four);break;
                    case 5: iv.setImageResource(R.drawable.five);break;
                    case 6: iv.setImageResource(R.drawable.six);break;
                }
            }
        });
    }
}
