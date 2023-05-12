package com.example.spotify_clone.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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