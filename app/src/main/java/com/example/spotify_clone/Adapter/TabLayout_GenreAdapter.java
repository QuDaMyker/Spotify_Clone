package com.example.spotify_clone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spotify_clone.OOP.itemTabLayout_Genre;
import com.example.spotify_clone.R;

import java.util.List;

public class TabLayout_GenreAdapter extends RecyclerView.Adapter<TabLayout_GenreAdapter.ViewHolder> {
    private Context context;
    private List<itemTabLayout_Genre> itemTabLayout_genreList;

    public TabLayout_GenreAdapter(Context context, List<itemTabLayout_Genre> itemTabLayout_genreList) {
        this.context = context;
        this.itemTabLayout_genreList = itemTabLayout_genreList;
    }

    @NonNull
    @Override
    public TabLayout_GenreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_tablayout_genre, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TabLayout_GenreAdapter.ViewHolder holder, int position) {
        itemTabLayout_Genre item = itemTabLayout_genreList.get(position);

        Glide.with(context)
                .load(item.getImageGenre())
                .into(holder.item_tab_layout_genre_img);

        holder.item_tab_layout_genre_Title.setText(item.getTitleGenre());
        holder.item_tab_layout_genre_Des.setText(item.getDesGenre());
        holder.item_tab_layout_genre_BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "Click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(itemTabLayout_genreList != null) {
            return itemTabLayout_genreList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView item_tab_layout_genre_img;
        private TextView item_tab_layout_genre_Title;
        private TextView item_tab_layout_genre_Des;
        private ImageView item_tab_layout_genre_BtnNext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_tab_layout_genre_img = itemView.findViewById(R.id.item_tab_layout_genre_img);
            item_tab_layout_genre_Title = itemView.findViewById(R.id.item_tab_layout_genre_Title);
            item_tab_layout_genre_Des = itemView.findViewById(R.id.item_tab_layout_genre_Des);
            item_tab_layout_genre_BtnNext = itemView.findViewById(R.id.item_tab_layout_genre_BtnNext);
        }
    }
}
