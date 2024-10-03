package com.example.truyencuoiapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.truyencuoiapp.R;

public class DetailStoryActivity extends AppCompatActivity {
    TextView categoryName,storyName,detailStory;
    ImageView iv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_story_activity);
        categoryName = findViewById(R.id.nameCategory);
        storyName = findViewById(R.id.nameStory);
        detailStory = findViewById(R.id.detailStory);
        iv = findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        String storyname = intent.getStringExtra("storyName");
        String storydetail = intent.getStringExtra("storyDetail");
        String nameCategory = intent.getStringExtra("categoryName"); // Nhận categoryName
        detailStory.setText(storydetail);
        categoryName.setText(nameCategory);
        storyName.setText(storyname);
    }
}
