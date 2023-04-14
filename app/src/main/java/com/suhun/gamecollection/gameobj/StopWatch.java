package com.suhun.gamecollection.gameobj;

import android.util.Log;

import com.suhun.gamecollection.databinding.ActivityStopWatchBinding;

import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {
    String tag = StopWatch.class.getSimpleName();
    private ActivityStopWatchBinding binding;
    private boolean isStart;
    private Timer timer = new Timer();
    private MyTask myTask;
    private int counter = 0;

    private class MyTask extends TimerTask{
        @Override
        public void run() {
            counter++;
            Log.d(tag, "Counter:"+counter);

        }
    }

    public StopWatch(ActivityStopWatchBinding binding){
        this.binding = binding;
    }

    public void showLeft(){

    }

    public void showRight(){
        isStart = !isStart;
        if(isStart){//如果還沒開始計時，右邊按鈕字串改為Stop,左邊按鈕字串改為Lap
            binding.rightBtn.setText("Stop");
            binding.leftBtn.setText("Lap");
            doStart();
        }else{//如果已經開始計時，，右邊按鈕字串改為Start,左邊按鈕字串改為Reset
            binding.rightBtn.setText("Start");
            binding.leftBtn.setText("Reset");
            doStop();
        }
    }
    private void doStart(){
        myTask = new MyTask();
        timer.schedule(myTask, 10, 10);
    }

    private void doStop(){
        if(myTask != null){
            myTask.cancel();
            binding.clock.setText("00:00:00.0");
        }
    }
}
