package com.example.spotify_clone.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.spotify_clone.Fragment.AlbumFragment;
import com.example.spotify_clone.Fragment.ArtistsFragment;
import com.example.spotify_clone.Fragment.GenreFragment;
import com.example.spotify_clone.Fragment.PodcastFragment;

public class TabLayoutAdapter extends FragmentStateAdapter {
    public TabLayoutAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: {
                return new ArtistsFragment();
            }
            case 1: {
                return new AlbumFragment();
            }
            case 2: {
                return new PodcastFragment();
            }
            case 3: {
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


