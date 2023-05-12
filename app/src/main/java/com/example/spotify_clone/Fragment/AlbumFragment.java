package com.example.spotify_clone.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotify_clone.Adapter.TabLayout_AlbumAdapter;
import com.example.spotify_clone.OOP.itemTabLayout_Album;
import com.example.spotify_clone.R;

import java.util.ArrayList;
import java.util.List;


public class AlbumFragment extends Fragment {
    private RecyclerView fragAlbum_recycleView;
    private TabLayout_AlbumAdapter tabLayout_albumAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_album, container, false);

        fragAlbum_recycleView =view.findViewById(R.id.fragAlbum_recycleView);
        tabLayout_albumAdapter = new TabLayout_AlbumAdapter(this.getContext(), getItemTabLayoutList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        fragAlbum_recycleView.setLayoutManager(linearLayoutManager);
        fragAlbum_recycleView.setAdapter(tabLayout_albumAdapter);

        return view;
    }

    private List<itemTabLayout_Album> getItemTabLayoutList() {
        List<itemTabLayout_Album> listAlbum = new ArrayList<>();
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_1,"Un Verano Sin Ti", "Bad Bunny"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_2,"MAÑANA SERÁ BONITO", "KAROL G"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_3,"One Thing At A Time", "Morgan Wallen"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_4,"Sos", "SZA"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_5,"HEROES & VILLAINS", "Metro Boomin"));

        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_1,"Un Verano Sin Ti", "Bad Bunny"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_2,"MAÑANA SERÁ BONITO", "KAROL G"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_3,"One Thing At A Time", "Morgan Wallen"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_4,"Sos", "SZA"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_5,"HEROES & VILLAINS", "Metro Boomin"));

        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_1,"Un Verano Sin Ti", "Bad Bunny"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_2,"MAÑANA SERÁ BONITO", "KAROL G"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_3,"One Thing At A Time", "Morgan Wallen"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_4,"Sos", "SZA"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_5,"HEROES & VILLAINS", "Metro Boomin"));

        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_1,"Un Verano Sin Ti", "Bad Bunny"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_2,"MAÑANA SERÁ BONITO", "KAROL G"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_3,"One Thing At A Time", "Morgan Wallen"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_4,"Sos", "SZA"));
        listAlbum.add(new itemTabLayout_Album(R.drawable.img_album_5,"HEROES & VILLAINS", "Metro Boomin"));
        return listAlbum;
    }
}