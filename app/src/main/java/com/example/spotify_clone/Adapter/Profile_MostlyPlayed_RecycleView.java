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
import com.example.spotify_clone.OOP.itemProfile_MostlyPlayed_RecycleView;
import com.example.spotify_clone.R;

import java.util.List;

public class Profile_MostlyPlayed_RecycleView extends RecyclerView.Adapter<Profile_MostlyPlayed_RecycleView.ViewHolder> {
    private Context context;
    private List<itemProfile_MostlyPlayed_RecycleView> list;

    public Profile_MostlyPlayed_RecycleView(Context context, List<itemProfile_MostlyPlayed_RecycleView> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Profile_MostlyPlayed_RecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile_mostlyplayed, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Profile_MostlyPlayed_RecycleView.ViewHolder holder, int position) {
        itemProfile_MostlyPlayed_RecycleView item = list.get(position);

        Glide.with(context)
                .load(item.getImageProfile_MostlyPlayed())
                .into(holder.item_profile_mostly_played_img);

        holder.item_profile_mostly_played_title.setText(item.getTitleProfile_MostlyPlayed());
        holder.item_profile_mostly_played_des.setText(item.getDesProfile_MostlyPlayed());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView item_profile_mostly_played_img;
        private TextView item_profile_mostly_played_title;
        private TextView item_profile_mostly_played_des;
        private ImageView item_profile_mostly_played_more;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_profile_mostly_played_img = itemView.findViewById(R.id.item_profile_mostly_played_img);
            item_profile_mostly_played_title = itemView.findViewById(R.id.item_profile_mostly_played_title);
            item_profile_mostly_played_des = itemView.findViewById(R.id.item_profile_mostly_played_des);
            item_profile_mostly_played_more = itemView.findViewById(R.id.item_profile_mostly_played_more);
        }
    }
}
