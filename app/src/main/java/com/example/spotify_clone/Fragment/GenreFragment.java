package com.example.spotify_clone.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify_clone.Adapter.TabLayout_GenreAdapter;
import com.example.spotify_clone.OOP.itemTabLayout_Artists;
import com.example.spotify_clone.OOP.itemTabLayout_Genre;
import com.example.spotify_clone.R;

import java.util.ArrayList;
import java.util.List;

public class GenreFragment extends Fragment {
    private RecyclerView fragGenre_recycleView;
    private TabLayout_GenreAdapter tabLayout_genreAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_genre, container, false);
        fragGenre_recycleView = view.findViewById(R.id.fragGenre_recycleView);
        tabLayout_genreAdapter = new TabLayout_GenreAdapter(this.getContext(), getItemTabLayoutList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        fragGenre_recycleView.setLayoutManager(linearLayoutManager);
        fragGenre_recycleView.setAdapter(tabLayout_genreAdapter);

        return view;
    }

    private List<itemTabLayout_Genre> getItemTabLayoutList() {
        List<itemTabLayout_Genre> list = new ArrayList<>();
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_1, "Hip-Hop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_2, "Pop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_3, "Đồng quê", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_4, "La-tinh", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_5, "Rock", ""));

        list.add(new itemTabLayout_Genre(R.drawable.img_genre_1, "Hip-Hop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_2, "Pop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_3, "Đồng quê", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_4, "La-tinh", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_5, "Rock", ""));

        list.add(new itemTabLayout_Genre(R.drawable.img_genre_1, "Hip-Hop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_2, "Pop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_3, "Đồng quê", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_4, "La-tinh", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_5, "Rock", ""));

        list.add(new itemTabLayout_Genre(R.drawable.img_genre_1, "Hip-Hop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_2, "Pop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_3, "Đồng quê", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_4, "La-tinh", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_5, "Rock", ""));

        list.add(new itemTabLayout_Genre(R.drawable.img_genre_1, "Hip-Hop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_2, "Pop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_3, "Đồng quê", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_4, "La-tinh", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_5, "Rock", ""));

        list.add(new itemTabLayout_Genre(R.drawable.img_genre_1, "Hip-Hop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_2, "Pop", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_3, "Đồng quê", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_4, "La-tinh", ""));
        list.add(new itemTabLayout_Genre(R.drawable.img_genre_5, "Rock", ""));
        return list;
    }
}