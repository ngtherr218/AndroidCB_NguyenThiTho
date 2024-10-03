package com.example.truyencuoiapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.truyencuoiapp.R;
import com.example.truyencuoiapp.activity.DetailStoryActivity;
import com.example.truyencuoiapp.activity.StoryActivity;
import com.example.truyencuoiapp.model.Category;
import com.example.truyencuoiapp.model.Story;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {
    //Dữ liệu hiện thị là danh sách sinh viên
    private List<Story> storyList;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;
    private String nameCategory;//truyền vào nameCategory để chuyển tiếp sang màn sau

    public StoryAdapter(List<Story> storyList, Context mContext, String nameCategory) {
        this.storyList = storyList;
        this.mContext = mContext;
        this.nameCategory = nameCategory;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.story_item, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        Story story = (Story) storyList.get(position);
        holder.nameStory.setText(story.getNameStory());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailStoryActivity.class);
                intent.putExtra("storyDetail", story.getDetailStory());
                intent.putExtra("storyName",story.getNameStory());
                intent.putExtra("categoryName", nameCategory); // Truyền categoryName
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return storyList.size();
    }

     class StoryViewHolder extends RecyclerView.ViewHolder {
        public TextView nameStory;
        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            nameStory = itemView.findViewById(R.id.nameStory);
        }
    }
}
