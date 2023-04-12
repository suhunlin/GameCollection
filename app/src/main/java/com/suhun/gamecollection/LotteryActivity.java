package com.suhun.gamecollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.suhun.gamecollection.databinding.ActivityLotteryBinding;
import com.suhun.gamecollection.gameobj.Lottery;

public class LotteryActivity extends AppCompatActivity {
    private ActivityLotteryBinding binding;
    private Lottery lottery = new Lottery();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLotteryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottery.showLottery(getResources(), binding);
            }
        });
        binding.exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}