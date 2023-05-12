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
import com.example.spotify_clone.OOP.itemTabLayout_Album;
import com.example.spotify_clone.OOP.itemTabLayout_Artists;
import com.example.spotify_clone.R;

import java.util.List;

public class TabLayout_AlbumAdapter extends RecyclerView.Adapter<TabLayout_AlbumAdapter.ViewHolder> {
    private List<itemTabLayout_Album> itemTabLayoutAlbumList;
    private Context context;

    public TabLayout_AlbumAdapter(Context context, List<itemTabLayout_Album> itemTabLayoutAlbumList) {
        this.itemTabLayoutAlbumList = itemTabLayoutAlbumList;
        this.context = context;
    }

    @NonNull
    @Override
    public TabLayout_AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_tablayout_album, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TabLayout_AlbumAdapter.ViewHolder holder, int position) {
        itemTabLayout_Album item = itemTabLayoutAlbumList.get(position);

        Glide.with(context)
                .load(item.getImageAlbum())
                .into(holder.item_tab_layout_album_img);
        holder.item_tab_layout_album_Title.setText(item.getTitleAlbum());
        holder.item_tab_layout_album_Des.setText(item.getDesAlbum());
        holder.item_tab_layout_album_BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "Click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (itemTabLayoutAlbumList != null) {
            return itemTabLayoutAlbumList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView item_tab_layout_album_img;
        private TextView item_tab_layout_album_Title;
        private TextView item_tab_layout_album_Des;
        private ImageView item_tab_layout_album_BtnNext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_tab_layout_album_img = itemView.findViewById(R.id.item_tab_layout_album_img);
            item_tab_layout_album_Title = itemView.findViewById(R.id.item_tab_layout_album_Title);
            item_tab_layout_album_Des = itemView.findViewById(R.id.item_tab_layout_album_Des);
            item_tab_layout_album_BtnNext = itemView.findViewById(R.id.item_tab_layout_album_BtnNext);
        }
    }
}
