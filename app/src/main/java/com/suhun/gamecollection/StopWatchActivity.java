package com.suhun.gamecollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.suhun.gamecollection.databinding.ActivityStopWatchBinding;
import com.suhun.gamecollection.gameobj.StopWatch;

public class StopWatchActivity extends AppCompatActivity {
    String tag = StopWatchActivity.class.getSimpleName();
    private ActivityStopWatchBinding binding;
    private StopWatch stopWatch = new StopWatch();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStopWatchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void leftFun(View view){

    }

    public void rightFun(View view){
        stopWatch.showRight(binding);
    }


    public void exitFun(View view){
        finish();
    }
}