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
import com.example.spotify_clone.OOP.itemPlaylist_PlaylistRecycleView;
import com.example.spotify_clone.R;

import java.util.List;

public class Playlist_PlaylistRecycleViewAdapter extends RecyclerView.Adapter<Playlist_PlaylistRecycleViewAdapter.ViewHolder> {
    private Context context;
    private List<itemPlaylist_PlaylistRecycleView> listItem;

    public Playlist_PlaylistRecycleViewAdapter(Context context, List<itemPlaylist_PlaylistRecycleView> listItem) {
        this.context = context;
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public Playlist_PlaylistRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_playlist_recycleview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Playlist_PlaylistRecycleViewAdapter.ViewHolder holder, int position) {
        itemPlaylist_PlaylistRecycleView item = listItem.get(position);
        Glide.with(context)
                .load(item.getImagePlaylist())
                .into(holder.item_playlist_recycle_view_image);

        holder.item_playlist_recycle_view_title.setText(item.getTitlePlaylist());
        holder.item_playlist_recycle_view_countSong.setText(item.getCountSongPlaylist());
    }

    @Override
    public int getItemCount() {
        if(listItem.size() != 0) {
            return listItem.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView item_playlist_recycle_view_image;
        private TextView item_playlist_recycle_view_title;
        private TextView item_playlist_recycle_view_countSong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_playlist_recycle_view_image = itemView.findViewById(R.id.item_playlist_recycle_view_image);
            item_playlist_recycle_view_title = itemView.findViewById(R.id.item_playlist_recycle_view_title);
            item_playlist_recycle_view_countSong = itemView.findViewById(R.id.item_playlist_recycle_view_countSong);
        }
    }
}
