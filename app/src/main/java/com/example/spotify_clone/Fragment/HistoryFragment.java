package com.example.spotify_clone.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify_clone.Adapter.History_TodayRecycleViewAdapter;
import com.example.spotify_clone.Adapter.History_YesterdayRecycleViewAdapter;
import com.example.spotify_clone.OOP.itemHistory_TodayRecycleView;
import com.example.spotify_clone.OOP.itemHistory_YesterdayRecycleView;
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

        History_TodayRecycleViewAdapter history_todayRecycleViewAdapter = new History_TodayRecycleViewAdapter(this.getContext(), getListDataToday());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        binding.fragHistoryRecyclerViewToday.setLayoutManager(linearLayoutManager);
        binding.fragHistoryRecyclerViewToday.setAdapter(history_todayRecycleViewAdapter);

        int maxVisibleItems = 3;
        history_todayRecycleViewAdapter.setMaxVisibleItems(maxVisibleItems);
        binding.seeAllButtonToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị hoặc ẩn tất cả các item
                boolean showAllItems = history_todayRecycleViewAdapter.toggleShowAllItems();
                if (showAllItems) {
                    binding.seeAllButtonToday.setText("Hide All");
                } else {
                    binding.seeAllButtonToday.setText("See All");
                }
            }
        });

        History_YesterdayRecycleViewAdapter history_yesterdayRecycleViewAdapter = new History_YesterdayRecycleViewAdapter(this.getContext(), getListDataYesterday());
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        binding.fragHistoryRecyclerViewYesterday.setLayoutManager(linearLayoutManager1);
        binding.fragHistoryRecyclerViewYesterday.setAdapter(history_yesterdayRecycleViewAdapter);
        history_yesterdayRecycleViewAdapter.setMaxVisibleItems(maxVisibleItems);
        binding.seeAllButtonYesterday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiển thị hoặc ẩn tất cả các item
                boolean showAllItems = history_yesterdayRecycleViewAdapter.toggleShowAllItems();
                if (showAllItems) {
                    binding.seeAllButtonYesterday.setText("Hide All");
                } else {
                    binding.seeAllButtonYesterday.setText("See All");
                }
            }
        });
        return view;


    }

    private List<itemHistory_TodayRecycleView> getListDataToday() {
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

    private List<itemHistory_YesterdayRecycleView> getListDataYesterday() {
        List<itemHistory_YesterdayRecycleView> list = new ArrayList<>();

        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_genre_1, "Happiers", "Playlist"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_genre_2, "Dekat Di Hati", "RAN"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_genre_3, "ReMaja", "Hivils"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_genre_4, "Happiers", "Playlist"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_genre_5, "Happiers", "Playlist"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_hit_3, "Happiers", "Playlist"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_hit_4, "Happiers", "Playlist"));

        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_genre_1, "Happiers", "Playlist"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_genre_2, "Dekat Di Hati", "RAN"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_genre_3, "ReMaja", "Hivils"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_genre_4, "Happiers", "Playlist"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_genre_5, "Happiers", "Playlist"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_hit_3, "Happiers", "Playlist"));
        list.add(new itemHistory_YesterdayRecycleView(R.drawable.img_hit_4, "Happiers", "Playlist"));
        return list;

    }
}