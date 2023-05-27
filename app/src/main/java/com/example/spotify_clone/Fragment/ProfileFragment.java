package com.example.spotify_clone.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import com.example.spotify_clone.Activity.Login_Activity;
import com.example.spotify_clone.Adapter.Profile_MostlyPlayed_RecycleView;
import com.example.spotify_clone.ClassUtils.CommonUtils;
import com.example.spotify_clone.Interface.OnLogoutListener;
import com.example.spotify_clone.OOP.itemProfile_MostlyPlayed_RecycleView;
import com.example.spotify_clone.R;
import com.example.spotify_clone.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    private FirebaseAuth auth;
    private FirebaseUser currentUser;
    private OnLogoutListener onLogoutListener;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menuProfile_edit) {
            /// ham xu lo
            return true;
        } else if (id == R.id.menuProfile_about) {
            // ham xu li
            return true;
        } else if (id == R.id.menuProfile_logout) {
            FirebaseAuth.getInstance().signOut();
            CommonUtils.showNotification(this.getContext(), "Đăng Xuất", "Bạn vừa đăng xuất khỏi tài khoản");
            Intent intent = new Intent(this.getContext(), Login_Activity.class);
            //startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.option_menu_profile, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // tao menu
        setHasOptionsMenu(true);
        binding.fragProfileSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getContext(), v);
                popupMenu.getMenuInflater().inflate(R.menu.option_menu_profile, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.menuProfile_edit) {
                            /// ham xu lo
                            return true;
                        } else if (id == R.id.menuProfile_about) {
                            // ham xu li
                            return true;
                        } else if (id == R.id.menuProfile_logout) {
                            //FirebaseAuth.getInstance().signOut();
                            //CommonUtils.showNotification(getContext(), "Đăng Xuất", "Bạn vừa đăng xuất khỏi tài khoản");
                            performLogout();
                            //Intent intent = new Intent(getContext(), Login_Activity.class);
                            //startActivity(intent);

                            return true;
                        }
                        return false;
                    }
                });
                popupMenu.show();
            }
        });

        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();
        updateUI();


        Profile_MostlyPlayed_RecycleView profile_mostlyPlayed_recycleView = new Profile_MostlyPlayed_RecycleView(this.getContext(), getData());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);

        binding.fragProfileRecycleViewMostPlayed.setLayoutManager(linearLayoutManager);
        binding.fragProfileRecycleViewMostPlayed.setAdapter(profile_mostlyPlayed_recycleView);


        return view;
    }

    private void updateUI() {
        if (currentUser != null) {
            String name = currentUser.getDisplayName();
            String email = currentUser.getEmail();

            binding.fragProfileNameProfile.setText(name);
            binding.fragProfileEmailProfile.setText(email);
        }

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

    // gui log out den loginActivity
    public void performLogout() {
        if (onLogoutListener != null) {
            onLogoutListener.onLogout();
        }
    }

    public void setOnLogoutListener(OnLogoutListener listener) {
        this.onLogoutListener = listener;
    }
}