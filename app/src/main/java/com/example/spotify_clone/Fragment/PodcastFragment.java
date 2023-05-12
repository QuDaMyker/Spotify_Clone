package com.example.spotify_clone.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify_clone.Adapter.TabLayout_PodcastAdapter;
import com.example.spotify_clone.OOP.itemTabLayout_Artists;
import com.example.spotify_clone.OOP.itemTabLayout_Podcast;
import com.example.spotify_clone.R;

import java.util.ArrayList;
import java.util.List;


public class PodcastFragment extends Fragment {
    private RecyclerView fragPodcast_recycleView;
    private TabLayout_PodcastAdapter tabLayout_podcastAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_podcast, container, false);
        fragPodcast_recycleView = view.findViewById(R.id.fragPodcast_recycleView);
        tabLayout_podcastAdapter = new TabLayout_PodcastAdapter(this.getContext(), getItemTabLayoutList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        fragPodcast_recycleView.setLayoutManager(linearLayoutManager);
        fragPodcast_recycleView.setAdapter(tabLayout_podcastAdapter);

        return view;
    }

    private List<itemTabLayout_Podcast> getItemTabLayoutList() {
        List<itemTabLayout_Podcast> list = new ArrayList<>();
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_1, "Morgan Wallen Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_2, "Zach Bryan Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_3, "Taylor Swift Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_4, "Luke Combs Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_5, "Drake Radio", "Của Spotify"));

        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_1, "Morgan Wallen Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_2, "Zach Bryan Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_3, "Taylor Swift Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_4, "Luke Combs Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_5, "Drake Radio", "Của Spotify"));

        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_1, "Morgan Wallen Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_2, "Zach Bryan Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_3, "Taylor Swift Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_4, "Luke Combs Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_5, "Drake Radio", "Của Spotify"));

        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_1, "Morgan Wallen Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_2, "Zach Bryan Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_3, "Taylor Swift Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_4, "Luke Combs Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_5, "Drake Radio", "Của Spotify"));

        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_1, "Morgan Wallen Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_2, "Zach Bryan Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_3, "Taylor Swift Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_4, "Luke Combs Radio", "Của Spotify"));
        list.add(new itemTabLayout_Podcast(R.drawable.img_podcast_5, "Drake Radio", "Của Spotify"));

        return list;
    }
}