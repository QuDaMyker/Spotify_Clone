package com.example.spotify_clone.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify_clone.Adapter.History_TodayRecycleViewAdapter;
import com.example.spotify_clone.OOP.itemHistory_TodayRecycleView;
import com.example.spotify_clone.R;
import com.example.spotify_clone.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {
    private FragmentHistoryBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        History_TodayRecycleViewAdapter history_todayRecycleViewAdapter = new History_TodayRecycleViewAdapter(this.getContext(), getListData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        binding.fragHistoryRecyclerViewToday.setLayoutManager(linearLayoutManager);
        binding.fragHistoryRecyclerViewToday.setAdapter(history_todayRecycleViewAdapter);

        int maxVisibleItems = 5;
        history_todayRecycleViewAdapter.setMaxVisibleItems(maxVisibleItems);
        binding.seeAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị hoặc ẩn tất cả các item
                boolean showAllItems = history_todayRecycleViewAdapter.toggleShowAllItems();
                if (showAllItems) {
                    binding.seeAllButton.setText("Hide All");
                } else {
                    binding.seeAllButton.setText("See All");
                }
            }
        });

        return view;


    }

    private List<itemHistory_TodayRecycleView> getListData() {
        List<itemHistory_TodayRecycleView> list = new ArrayList<>();

        list.add(new itemHistory_TodayRecycleView(R.drawable.img_album_1, "Happiers", "Playlist"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_album_2, "Dekat Di Hati", "RAN"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_album_3, "ReMaja", "Hivils"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_hit_1, "Happiers", "Playlist"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_hit_2, "Happiers", "Playlist"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_hit_3, "Happiers", "Playlist"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_hit_4, "Happiers", "Playlist"));

        list.add(new itemHistory_TodayRecycleView(R.drawable.img_album_1, "Happiers", "Playlist"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_album_2, "Dekat Di Hati", "RAN"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_album_3, "ReMaja", "Hivils"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_hit_1, "Happiers", "Playlist"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_hit_2, "Happiers", "Playlist"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_hit_3, "Happiers", "Playlist"));
        list.add(new itemHistory_TodayRecycleView(R.drawable.img_hit_4, "Happiers", "Playlist"));

        return list;

    }
}