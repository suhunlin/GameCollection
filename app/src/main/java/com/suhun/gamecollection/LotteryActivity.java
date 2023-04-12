package com.suhun.gamecollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.suhun.gamecollection.databinding.ActivityLotteryBinding;

public class LotteryActivity extends AppCompatActivity {
    private ActivityLotteryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLotteryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}