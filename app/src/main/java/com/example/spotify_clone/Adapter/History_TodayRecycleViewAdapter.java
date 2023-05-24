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
import com.example.spotify_clone.OOP.itemHistory_TodayRecycleView;
import com.example.spotify_clone.R;

import java.util.List;

public class History_TodayRecycleViewAdapter extends RecyclerView.Adapter<History_TodayRecycleViewAdapter.ViewHolder> {
    private Context context;
    private List<itemHistory_TodayRecycleView> list;

    public History_TodayRecycleViewAdapter(Context context, List<itemHistory_TodayRecycleView> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public History_TodayRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_history_todayrecycleview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull History_TodayRecycleViewAdapter.ViewHolder holder, int position) {
        itemHistory_TodayRecycleView item = list.get(position);

        Glide.with(context)
                .load(item.getImageTodayHistory())
                .into(holder.item_history_today_recycle_view_img);

        holder.item_history_today_recycle_view_title.setText(item.getTitleTodayHistory());
        holder.item_history_today_recycle_view_des.setText(item.getDesTodayHistory());
        holder.item_history_today_recycle_view_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if(list.size() != 0) {
            return list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView item_history_today_recycle_view_img;
        private TextView item_history_today_recycle_view_title;
        private TextView item_history_today_recycle_view_des;
        private ImageView item_history_today_recycle_view_more;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_history_today_recycle_view_img = itemView.findViewById(R.id.item_history_today_recycle_view_img);
            item_history_today_recycle_view_title = itemView.findViewById(R.id.item_history_today_recycle_view_title);
            item_history_today_recycle_view_des = itemView.findViewById(R.id.item_history_today_recycle_view_des);
            item_history_today_recycle_view_more = itemView.findViewById(R.id.item_history_today_recycle_view_more);
        }
    }
}
