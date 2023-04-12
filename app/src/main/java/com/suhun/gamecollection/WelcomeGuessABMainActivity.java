package com.suhun.gamecollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.suhun.gamecollection.databinding.ActivityWelcomeGuessAbmainBinding;

public class WelcomeGuessABMainActivity extends AppCompatActivity {
    private ActivityWelcomeGuessAbmainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeGuessAbmainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}