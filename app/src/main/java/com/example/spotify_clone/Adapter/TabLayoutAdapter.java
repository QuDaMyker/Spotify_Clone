package com.example.spotify_clone.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.spotify_clone.Activity.Fragment.AlbumFragment;
import com.example.spotify_clone.Activity.Fragment.ArtistsFragment;
import com.example.spotify_clone.Activity.Fragment.GenreFragment;
import com.example.spotify_clone.Activity.Fragment.PodcastFragment;

public class TabLayoutAdapter extends FragmentStateAdapter {
    public TabLayoutAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1: {
                return new ArtistsFragment();
            }
            case 2: {
                return new AlbumFragment();
            }
            case 3: {
                return new PodcastFragment();
            }
            case 4: {
                return new GenreFragment();
            }
        }
        return new ArtistsFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}


