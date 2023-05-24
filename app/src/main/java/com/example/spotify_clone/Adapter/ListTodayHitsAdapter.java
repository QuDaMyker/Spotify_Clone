package com.example.spotify_clone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spotify_clone.OOP.TodayHits;
import com.example.spotify_clone.R;

import java.util.List;

public class ListTodayHitsAdapter extends RecyclerView.Adapter<ListTodayHitsAdapter.ViewHolder> {
    private List<TodayHits> todayHitsList;
    private Context context;

    public ListTodayHitsAdapter(Context context, List<TodayHits> todayHitsList) {
        this.todayHitsList = todayHitsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListTodayHitsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hit, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListTodayHitsAdapter.ViewHolder holder, int position) {
        TodayHits todayHits = todayHitsList.get(position);
        Glide.with(context)
                .load(todayHits.getImageAlbum())
                .into(holder.itemAlbum_img);

        holder.itemAlbum_title.setText(todayHits.getTitleAlbum());
        holder.itemAlbum_des.setText(todayHits.getDesAlbum());
    }

    @Override
    public int getItemCount() {
        if (todayHitsList != null) {
            return todayHitsList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemAlbum_img;
        private TextView itemAlbum_title;
        private TextView itemAlbum_des;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemAlbum_img = itemView.findViewById(R.id.itemHit_img);
            itemAlbum_title = itemView.findViewById(R.id.itemHit_title);
            itemAlbum_des = itemView.findViewById(R.id.itemHit_des);
        }
    }
}
