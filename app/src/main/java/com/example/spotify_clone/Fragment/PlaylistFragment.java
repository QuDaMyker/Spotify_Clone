package com.example.spotify_clone.Fragment;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.spotify_clone.Adapter.Playlist_PlaylistRecycleViewAdapter;
import com.example.spotify_clone.OOP.itemPlaylist_PlaylistRecycleView;
import com.example.spotify_clone.R;
import com.example.spotify_clone.databinding.FragmentPlaylistBinding;

import java.util.ArrayList;
import java.util.List;


public class PlaylistFragment extends Fragment {
    FragmentPlaylistBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPlaylistBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        Playlist_PlaylistRecycleViewAdapter playlistRecycleViewAdapter = new Playlist_PlaylistRecycleViewAdapter(this.getContext(), getList());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);

        binding.fragPlaylistRecyclerView.setLayoutManager(gridLayoutManager);
        binding.fragPlaylistRecyclerView.setAdapter(playlistRecycleViewAdapter);

        return rootView;
    }

    private List<itemPlaylist_PlaylistRecycleView> getList(){
        List<itemPlaylist_PlaylistRecycleView> list = new ArrayList<>();
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_1, "Likes Songs", "128 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_2, "Happier", "45 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_3, "Sadness", "21 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_4, "Birthday", "99 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_1, "Summer", "23 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_2, "Alone", "15 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_3, "Sweet", "9 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_4, "HighSchool", "55 Songs"));

        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_1, "Likes Songs", "128 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_2, "Happier", "45 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_3, "Sadness", "21 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_4, "Birthday", "99 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_1, "Summer", "23 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_2, "Alone", "15 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_3, "Sweet", "9 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_4, "HighSchool", "55 Songs"));

        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_1, "Likes Songs", "128 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_2, "Happier", "45 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_3, "Sadness", "21 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_hit_4, "Birthday", "99 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_1, "Summer", "23 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_2, "Alone", "15 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_3, "Sweet", "9 Songs"));
        list.add(new itemPlaylist_PlaylistRecycleView(R.drawable.img_album_4, "HighSchool", "55 Songs"));

        return list;
    }
}

