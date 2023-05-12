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
import com.example.spotify_clone.OOP.itemTabLayout_Podcast;
import com.example.spotify_clone.R;

import java.util.List;

public class TabLayout_PodcastAdapter extends RecyclerView.Adapter<TabLayout_PodcastAdapter.ViewHolder> {
    private Context context;
    private List<itemTabLayout_Podcast> itemTabLayoutPodcastList;

    public TabLayout_PodcastAdapter(Context context, List<itemTabLayout_Podcast> itemTabLayoutPodcastList) {
        this.context = context;
        this.itemTabLayoutPodcastList = itemTabLayoutPodcastList;
    }

    @NonNull
    @Override
    public TabLayout_PodcastAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_tablayout_podcast, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TabLayout_PodcastAdapter.ViewHolder holder, int position) {
        itemTabLayout_Podcast item = itemTabLayoutPodcastList.get(position);

        Glide.with(context)
                .load(item.getImagePodcast())
                .into(holder.item_tab_layout_podcast_img);

        holder.item_tab_layout_podcast_Title.setText(item.getTitlePodcast());
        holder.item_tab_layout_podcast_Des.setText(item.getDesPodcast());
        holder.item_tab_layout_podcast_BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "Click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(itemTabLayoutPodcastList != null) {
            return itemTabLayoutPodcastList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView item_tab_layout_podcast_img;
        private TextView item_tab_layout_podcast_Title;
        private TextView item_tab_layout_podcast_Des;
        private ImageView item_tab_layout_podcast_BtnNext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_tab_layout_podcast_img = itemView.findViewById(R.id.item_tab_layout_podcast_img);
            item_tab_layout_podcast_Title = itemView.findViewById(R.id.item_tab_layout_podcast_Title);
            item_tab_layout_podcast_Des = itemView.findViewById(R.id.item_tab_layout_podcast_Des);
            item_tab_layout_podcast_BtnNext = itemView.findViewById(R.id.item_tab_layout_podcast_BtnNext);
        }
    }
}
