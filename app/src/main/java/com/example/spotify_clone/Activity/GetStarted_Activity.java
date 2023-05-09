package com.example.spotify_clone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.spotify_clone.R;
import com.example.spotify_clone.databinding.ActivityGetStartedBinding;

public class GetStarted_Activity extends AppCompatActivity {
    private ActivityGetStartedBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGetStartedBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.getStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GetStarted_Activity.this, Signup_Activity.class));
                finish();
            }
        });
    }
}