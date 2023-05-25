package com.example.spotify_clone.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify_clone.Adapter.Profile_MostlyPlayed_RecycleView;
import com.example.spotify_clone.OOP.itemProfile_MostlyPlayed_RecycleView;
import com.example.spotify_clone.R;
import com.example.spotify_clone.databinding.FragmentProfileBinding;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        Profile_MostlyPlayed_RecycleView profile_mostlyPlayed_recycleView = new Profile_MostlyPlayed_RecycleView(this.getContext(), getData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);

        binding.fragProfileRecycleViewMostPlayed.setLayoutManager(linearLayoutManager);
        binding.fragProfileRecycleViewMostPlayed.setAdapter(profile_mostlyPlayed_recycleView);


        return view;
    }
    private List<itemProfile_MostlyPlayed_RecycleView> getData() {
        List<itemProfile_MostlyPlayed_RecycleView> list = new ArrayList<>();
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_1, "Dekat Di Hati", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_2, "Bigger Than The Whole", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_3, "Matilda", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_4, "Holand", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_5, "Dekat Di Hati Dekat Di Hati Dekat Di Hati", "RAN"));

        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_1, "Dekat Di Hati", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_2, "Bigger Than The Whole", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_3, "Matilda", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_4, "Holand", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_5, "Dekat Di Hati Dekat Di Hati Dekat Di Hati", "RAN"));

        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_1, "Dekat Di Hati", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_2, "Bigger Than The Whole", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_3, "Matilda", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_4, "Holand", "RAN"));
        list.add(new itemProfile_MostlyPlayed_RecycleView(R.drawable.img_album_5, "Dekat Di Hati Dekat Di Hati Dekat Di Hati", "RAN"));

        return list;
    }
}