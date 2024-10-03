package com.example.truyencuoiapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.truyencuoiapp.R;

public class FirstActivity extends AppCompatActivity {
    ConstraintLayout main;
    boolean isChanged = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.first_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        main = findViewById(R.id.main);

        // Đặt Handler để tự động chuyển đổi sau 3 giây
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               if(!isChanged){
                   Intent intent = new Intent(FirstActivity.this, CategoryActivity.class);
                   startActivity(intent);
                   finish();
               }
            }
        }, 3000); // Thời gian chờ là 3000 milliseconds (3 giây)

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isChanged=true;
                Intent intent = new Intent(FirstActivity.this, CategoryActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
