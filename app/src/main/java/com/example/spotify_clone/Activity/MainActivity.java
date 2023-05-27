package com.example.spotify_clone.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.spotify_clone.ClassUtils.CommonUtils;
import com.example.spotify_clone.Fragment.HistoryFragment;
import com.example.spotify_clone.Fragment.HomeFragment;
import com.example.spotify_clone.Fragment.PlaylistFragment;
import com.example.spotify_clone.Fragment.ProfileFragment;
import com.example.spotify_clone.Interface.OnLogoutListener;
import com.example.spotify_clone.R;
import com.example.spotify_clone.databinding.ActivityMainBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements OnLogoutListener {
    private ActivityMainBinding binding;
    private GoogleSignInClient gClient;
    private GoogleSignInOptions gOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setDefaultFragment();


        gOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                        .build();
        gClient = GoogleSignIn.getClient(MainActivity.this, gOptions);

        GoogleSignInAccount gAccount = GoogleSignIn.getLastSignedInAccount(MainActivity.this);
        if(gAccount != null) {
            String gName = gAccount.getDisplayName();
            String gEmail = gAccount.getEmail();
        }

        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.playlist) {
                replaceFragment(new PlaylistFragment());
            } else if (item.getItemId() == R.id.history) {
                replaceFragment(new HistoryFragment());
            } else if (item.getItemId() == R.id.profile) {
                ProfileFragment profileFragment = new ProfileFragment();
                profileFragment.setOnLogoutListener(this);
                replaceFragment(profileFragment);
            }

            return true;
        });
    }

    private void setDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, new HomeFragment());
        fragmentTransaction.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onLogout() {
        gClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                CommonUtils.showNotification(MainActivity.this, "Đăng Xuất", "Bạn vừa đăng xuất khỏi tài khoản");
                Intent intent = new Intent(MainActivity.this, Splash_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

    }
}