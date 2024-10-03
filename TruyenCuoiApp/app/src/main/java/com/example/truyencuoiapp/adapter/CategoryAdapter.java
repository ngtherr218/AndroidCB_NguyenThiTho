package com.example.truyencuoiapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.truyencuoiapp.R;
import com.example.truyencuoiapp.activity.CategoryActivity;
import com.example.truyencuoiapp.activity.DetailStoryActivity;
import com.example.truyencuoiapp.activity.StoryActivity;
import com.example.truyencuoiapp.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CatergoryViewHolder> {
    //Dữ liệu hiện thị là danh sách sinh viên
    private List<Category> listCategory;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;


    public CategoryAdapter(List<Category> listCategory, Context mContext) {
        this.listCategory = listCategory;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CatergoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_item, parent, false);
        return new CatergoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatergoryViewHolder holder, int position) {
        Category category = (Category) listCategory.get(position);
        holder.imgCategory.setImageResource(category.getImgCategory());
        holder.nameCategory.setText(category.getNameCategory());
        // Set sự kiện click cho item, truyền dữ liệu category qua listener
        // Xử lý sự kiện click trực tiếp
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent = new Intent(mContext, StoryActivity.class);
                 intent.putExtra("categoryID", category.getIdCategory());
                 intent.putExtra("categoryName", category.getNameCategory());
                 mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCategory.size();
    }

    class CatergoryViewHolder extends RecyclerView.ViewHolder {
        public TextView nameCategory;
        public ImageView imgCategory;

        public CatergoryViewHolder(@NonNull View itemView) {
            super(itemView);
            nameCategory = itemView.findViewById(R.id.nameCategory);
            imgCategory = itemView.findViewById(R.id.imgCategory);
        }
    }
}
