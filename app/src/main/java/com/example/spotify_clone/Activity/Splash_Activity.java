package com.example.spotify_clone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Toast;

import com.example.spotify_clone.databinding.ActivitySplashBinding;


public class Splash_Activity extends AppCompatActivity {
    private ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int totalTime = 1000;

        CountDownTimer countDownTimer = new CountDownTimer(totalTime, 1) {
            @Override
            public void onTick(long millisUntilFinished) {
                int progress = (int) ((millisUntilFinished / (float) totalTime) * 100);

                binding.splashProgress.setProgress(progress);
                binding.splashPercent.setText(String.valueOf(100 - progress) + "%");
            }

            @Override
            public void onFinish() {
                binding.splashProgress.setProgress(100);
                startActivity(new Intent(Splash_Activity.this, GetStarted_Activity.class));
                finish();
            }
        };
        countDownTimer.start();

    }
}