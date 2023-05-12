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
import com.example.spotify_clone.OOP.itemTabLayout_Artists;
import com.example.spotify_clone.R;

import java.util.List;

public class TabLayout_ArtistsAdapter extends RecyclerView.Adapter<TabLayout_ArtistsAdapter.ViewHolder> {
    private List<itemTabLayout_Artists> itemTabLayoutArtistsList;
    private Context context;

    public TabLayout_ArtistsAdapter(Context context, List<itemTabLayout_Artists> itemTabLayoutArtistsList) {
        this.itemTabLayoutArtistsList = itemTabLayoutArtistsList;
        this.context = context;
    }

    @NonNull
    @Override
    public TabLayout_ArtistsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_tablayout_artists, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TabLayout_ArtistsAdapter.ViewHolder holder, int position) {
        itemTabLayout_Artists item = itemTabLayoutArtistsList.get(position);

        Glide.with(context)
                .load(item.getImage())
                .into(holder.item_layout_img);

        holder.item_layout_Artist.setText(item.getSinger());
        holder.item_layout_Des.setText(item.getDes());
        holder.item_layout_BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "Click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (itemTabLayoutArtistsList != null) {
            return itemTabLayoutArtistsList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView item_layout_img;
        private TextView item_layout_Artist;
        private TextView item_layout_Des;
        private ImageView item_layout_BtnNext;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_layout_img = itemView.findViewById(R.id.item_tab_layout_artist_img);
            item_layout_Artist = itemView.findViewById(R.id.item_tab_layout_artist_Artist);
            item_layout_Des = itemView.findViewById(R.id.item_tab_layout_artist_Des);
            item_layout_BtnNext = itemView.findViewById(R.id.item_tab_layout_artist_BtnNext);
        }
    }
}
