package com.suhun.gamecollection.gameobj;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;

import com.suhun.gamecollection.R;
import com.suhun.gamecollection.databinding.ActivityStopWatchBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {
    String tag = StopWatch.class.getSimpleName();
    private ActivityStopWatchBinding binding;
    private Context context;
    private boolean isStart;
    private Timer timer = new Timer();
    private MyTask myTask;
    public int counter = 0;
    private UiHandler uiHandler = new UiHandler();
    private SimpleAdapter simpleAdapter;
    private List<HashMap<String, String>> data = new ArrayList<>();
    private String[] from = {"itemKen"};
    private int[] to = {R.id.list_item};

    private class MyTask extends TimerTask{
        @Override
        public void run() {
            counter++;
            Log.d(tag, "Counter:"+counter);
            uiHandler.sendEmptyMessage(0);
        }
    }

    private class UiHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            binding.clock.setText(String.valueOf(counter));
        }
    }

    public StopWatch(Context context, ActivityStopWatchBinding binding){
        this.binding = binding;
        this.context = context;
        initListView();
        testInitListView(); //test method to test ListView
    }

    public void initListView(){
        simpleAdapter = new SimpleAdapter(context, data, R.layout.item, from, to);
        binding.lapData.setAdapter(simpleAdapter);
    }

    private void testInitListView(){
        HashMap<String, String> hashData = new HashMap<>();
        hashData.put(from[0], "Suhun Test");
        data.add(0,hashData);
        simpleAdapter.notifyDataSetChanged();
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
            counter = 0;
            binding.clock.setText("00:00:00.0");
        }
    }
}
