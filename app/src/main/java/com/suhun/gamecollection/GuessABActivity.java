package com.suhun.gamecollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.suhun.gamecollection.databinding.ActivityGuessAbactivityBinding;
import com.suhun.gamecollection.gameobj.GuessAB;

public class GuessABActivity extends AppCompatActivity {
    private ActivityGuessAbactivityBinding binding;
    private GuessAB guessAB = new GuessAB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuessAbactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //reset button
        binding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guessAB.showResetAlertDialog(GuessABActivity.this, getResources(), binding);

            }
        });
        //setting button
        binding.setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guessAB.showSettingAlertDialog(GuessABActivity.this, getResources());
            }
        });
        //exit button
        binding.exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}