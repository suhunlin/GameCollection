package com.suhun.gamecollection.gameobj;

import com.suhun.gamecollection.databinding.ActivityStopWatchBinding;

public class StopWatch {
    private boolean isStart;

    public void showLeft(){

    }

    public void showRight(ActivityStopWatchBinding binding){
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

    }

    private void doStop(){

    }
}
