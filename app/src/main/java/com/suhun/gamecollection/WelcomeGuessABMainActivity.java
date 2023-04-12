package com.suhun.gamecollection;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.suhun.gamecollection.databinding.ActivityWelcomeGuessAbmainBinding;

public class WelcomeGuessABMainActivity extends AppCompatActivity {
    String tag = WelcomeGuessABMainActivity.class.getSimpleName();
    private ActivityWelcomeGuessAbmainBinding binding;
    private ActivityResultLauncher goActivityCallback =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            Log.d(tag, "----Go Back WelcomeGuessABMainActivity-----");

                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWelcomeGuessAbmainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeGuessABMainActivity.this, GuessABActivity.class);
                goActivityCallback.launch(intent);
                finish();
            }
        });
    }
}