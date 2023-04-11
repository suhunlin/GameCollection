package com.suhun.gamecollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.suhun.gamecollection.databinding.ActivityGuessAbactivityBinding;

public class GuessABActivity extends AppCompatActivity {
    private ActivityGuessAbactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuessAbactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //exit button
        binding.exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}