package com.example.spotify_clone.Activity.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify_clone.Activity.OOP.itemTabLayout;
import com.example.spotify_clone.Adapter.TabLayout_ArtistsAdapter;
import com.example.spotify_clone.R;

import java.util.ArrayList;
import java.util.List;


public class ArtistsFragment extends Fragment {
    private RecyclerView fragArtists_recycleView;
    private TabLayout_ArtistsAdapter tabLayout_artistsAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artists, container, false);

        fragArtists_recycleView = view.findViewById(R.id.fragArtists_recycleView);
        tabLayout_artistsAdapter = new TabLayout_ArtistsAdapter(this.getContext(), getItemTabLayoutList());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        fragArtists_recycleView.setLayoutManager(layoutManager);
        fragArtists_recycleView.setAdapter(tabLayout_artistsAdapter);

        return view;
    }

    private List<itemTabLayout> getItemTabLayoutList() {
        List<itemTabLayout> list = new ArrayList<>();
        list.add(new itemTabLayout(R.drawable.img_singer_1, "Lil Baby", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_2, "Taylor Swift", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_3, "Drake", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_4, "Morgan Wallen", "Nghệ sĩ"));

        list.add(new itemTabLayout(R.drawable.img_singer_1, "Lil Baby", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_2, "Taylor Swift", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_3, "Drake", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_4, "Morgan Wallen", "Nghệ sĩ"));

        list.add(new itemTabLayout(R.drawable.img_singer_1, "Lil Baby", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_2, "Taylor Swift", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_3, "Drake", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_4, "Morgan Wallen", "Nghệ sĩ"));

        list.add(new itemTabLayout(R.drawable.img_singer_1, "Lil Baby", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_2, "Taylor Swift", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_3, "Drake", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_4, "Morgan Wallen", "Nghệ sĩ"));

        list.add(new itemTabLayout(R.drawable.img_singer_1, "Lil Baby", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_2, "Taylor Swift", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_3, "Drake", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_4, "Morgan Wallen", "Nghệ sĩ"));

        list.add(new itemTabLayout(R.drawable.img_singer_1, "Lil Baby", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_2, "Taylor Swift", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_3, "Drake", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_4, "Morgan Wallen", "Nghệ sĩ"));

        list.add(new itemTabLayout(R.drawable.img_singer_1, "Lil Baby", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_2, "Taylor Swift", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_3, "Drake", "Nghệ sĩ"));
        list.add(new itemTabLayout(R.drawable.img_singer_4, "Morgan Wallen", "Nghệ sĩ"));

        return list;
    }
}