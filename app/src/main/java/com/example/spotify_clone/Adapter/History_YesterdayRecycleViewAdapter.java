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
import com.example.spotify_clone.OOP.itemHistory_YesterdayRecycleView;
import com.example.spotify_clone.R;

import java.util.List;

public class History_YesterdayRecycleViewAdapter extends RecyclerView.Adapter<History_YesterdayRecycleViewAdapter.ViewHolder> {
    private Context context;
    private List<itemHistory_YesterdayRecycleView> list;
    private int maxVisibleItems;
    private boolean showAllItems;

    public History_YesterdayRecycleViewAdapter(Context context, List<itemHistory_YesterdayRecycleView> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public History_YesterdayRecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_yesterdayrecycleview, parent, false);

        return new ViewHolder(view);
    }

    public void setMaxVisibleItems(int maxVisibleItems) {
        this.maxVisibleItems = maxVisibleItems;
    }

    public boolean toggleShowAllItems() {
        showAllItems = !showAllItems;
        notifyDataSetChanged();
        return showAllItems;
    }


    @Override
    public void onBindViewHolder(@NonNull History_YesterdayRecycleViewAdapter.ViewHolder holder, int position) {
        itemHistory_YesterdayRecycleView item = list.get(position);

        Glide.with(context)
                .load(item.getImageYesterdayHistory())
                .into(holder.item_history_yesterday_recycle_view_img);

        holder.item_history_today_yesterday_view_title.setText(item.getTitleYesterdayHistory());
        holder.item_history_today_yesterday_view_des.setText(item.getDesYesterdayHistory());
        holder.item_history_today_yesterday_view_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        if (showAllItems) {
            return list.size();
        } else {
            return Math.min(list.size(), maxVisibleItems);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView item_history_yesterday_recycle_view_img;
        private TextView item_history_today_yesterday_view_title;
        private TextView item_history_today_yesterday_view_des;
        private ImageView item_history_today_yesterday_view_more;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_history_yesterday_recycle_view_img = itemView.findViewById(R.id.item_history_yesterday_recycle_view_img);
            item_history_today_yesterday_view_title = itemView.findViewById(R.id.item_history_today_yesterday_view_title);
            item_history_today_yesterday_view_des = itemView.findViewById(R.id.item_history_today_yesterday_view_des);
            item_history_today_yesterday_view_more = itemView.findViewById(R.id.item_history_today_yesterday_view_more);

        }
    }
}
