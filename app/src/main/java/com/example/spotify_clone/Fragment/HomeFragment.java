package com.example.spotify_clone.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify_clone.OOP.TodayHits;
import com.example.spotify_clone.OOP.Photo;
import com.example.spotify_clone.Adapter.ListTodayHitsAdapter;
import com.example.spotify_clone.Adapter.PhotoAdapter;
import com.example.spotify_clone.Adapter.TabLayoutAdapter;
import com.example.spotify_clone.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment {
    // slider viewpager
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    // recycle album
    private RecyclerView fragHome_listAlbum;
    private ListTodayHitsAdapter listTodayHitsAdapter;
    private TabLayout fragHome_tab_layout;
    private ViewPager2 fragHome_viewPager2;
    private TabLayoutAdapter tabLayoutAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // slider viewpager
        viewPager = view.findViewById(R.id.viewpager);
        circleIndicator = view.findViewById(R.id.circle_indicator);

        photoAdapter = new PhotoAdapter(this.getContext(), getListPhoto());
        viewPager.setAdapter(photoAdapter);

        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());


        // recycle Album
        fragHome_listAlbum = view.findViewById(R.id.fragHome_listAlbum);
        listTodayHitsAdapter = new ListTodayHitsAdapter(this.getContext(), getListAlbum());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false);
        fragHome_listAlbum.setLayoutManager(layoutManager);
        fragHome_listAlbum.setAdapter(listTodayHitsAdapter);

        // tablayout
        fragHome_tab_layout = view.findViewById(R.id.fragHome_tab_layout);
        fragHome_viewPager2 = view.findViewById(R.id.fragHome_viewPager2);

        fragHome_tab_layout.addTab(fragHome_tab_layout.newTab().setText("Artists"));
        fragHome_tab_layout.addTab(fragHome_tab_layout.newTab().setText("Album"));
        fragHome_tab_layout.addTab(fragHome_tab_layout.newTab().setText("Podcast"));
        fragHome_tab_layout.addTab(fragHome_tab_layout.newTab().setText("Genre"));

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        tabLayoutAdapter = new TabLayoutAdapter(fragmentManager, getLifecycle());
        fragHome_viewPager2.setAdapter(tabLayoutAdapter);


        fragHome_tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragHome_viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        fragHome_viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                fragHome_tab_layout.selectTab(fragHome_tab_layout.getTabAt(position));
            }
        });

        return view;
    }

    private List<Photo> getListPhoto() {
        List<Photo> photoList = new ArrayList<>();

        photoList.add(new Photo(R.drawable.img_slider));
        photoList.add(new Photo(R.drawable.img_hit_1));
        photoList.add(new Photo(R.drawable.img_hit_2));
        photoList.add(new Photo(R.drawable.img_hit_3));
        photoList.add(new Photo(R.drawable.img_hit_4));

        return photoList;
    }

    private List<TodayHits> getListAlbum() {
        List<TodayHits> todayHitsList = new ArrayList<>();

        todayHitsList.add(new TodayHits(R.drawable.img_hit_1, "Are You There God? It's Me, Margaret (Movie Tie-In Edition)", "Are You There God? It's Me, Margaret (Movie Tie-In Edition)"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_2, "Crying in H Mart: A Memoir", "Michelle Zauner"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_3, "Demon in the Wood Graphic Novel", "Leigh Bardugo"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_4, "The Song of Achilles: A Novel", "Madeline Miller"));

        todayHitsList.add(new TodayHits(R.drawable.img_hit_1, "Are You There God? It's Me, Margaret (Movie Tie-In Edition)", "Are You There God? It's Me, Margaret (Movie Tie-In Edition)"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_2, "Crying in H Mart: A Memoir", "Michelle Zauner"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_3, "Demon in the Wood Graphic Novel", "Leigh Bardugo"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_4, "The Song of Achilles: A Novel", "Madeline Miller"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_1, "Are You There God? It's Me, Margaret (Movie Tie-In Edition)", "Are You There God? It's Me, Margaret (Movie Tie-In Edition)"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_2, "Crying in H Mart: A Memoir", "Michelle Zauner"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_3, "Demon in the Wood Graphic Novel", "Leigh Bardugo"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_4, "The Song of Achilles: A Novel", "Madeline Miller"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_1, "Are You There God? It's Me, Margaret (Movie Tie-In Edition)", "Are You There God? It's Me, Margaret (Movie Tie-In Edition)"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_2, "Crying in H Mart: A Memoir", "Michelle Zauner"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_3, "Demon in the Wood Graphic Novel", "Leigh Bardugo"));
        todayHitsList.add(new TodayHits(R.drawable.img_hit_4, "The Song of Achilles: A Novel", "Madeline Miller"));
        return todayHitsList;
    }


}