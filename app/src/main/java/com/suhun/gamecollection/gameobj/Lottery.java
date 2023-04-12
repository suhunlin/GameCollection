package com.suhun.gamecollection.gameobj;

import android.content.res.Resources;
import android.util.Log;

import com.suhun.gamecollection.databinding.ActivityLotteryBinding;
import java.util.Random;
import java.util.TreeSet;

public class Lottery {
    public String tag = Lottery.class.getSimpleName();
    private int[] lotteryNum;
    private int lotteryLen = 6;

    public Lottery(){
        super();
        lotteryNum = new int[lotteryLen];
    }

    public int[] getLotteryNum() {
        return lotteryNum;
    }

    public void setLotteryNum() {
        this.lotteryNum = createLottery();
    }

    private int[] createLottery(){
        TreeSet<Integer> numSet = new TreeSet<Integer>();

        while(numSet.size()<lotteryLen){
            numSet.add(new Random().nextInt(49)+1);
        }
        int[] tempArray = new int[lotteryLen];int i=0;
        for(Integer num:numSet){
            tempArray[i++] = num;
        }
        for(int j=0;j<tempArray.length;j++){
            Log.d(tag, "The lottery num is " + tempArray[j]);
        }
        return tempArray;
    }

    public void showLottery(Resources resources, ActivityLotteryBinding binding){
        setLotteryNum();
        int[] lotteryNumber = getLotteryNum();
        binding.num0.setText(String.valueOf(lotteryNumber[0]));
        binding.num1.setText(String.valueOf(lotteryNumber[1]));
        binding.num2.setText(String.valueOf(lotteryNumber[2]));
        binding.num3.setText(String.valueOf(lotteryNumber[3]));
        binding.num4.setText(String.valueOf(lotteryNumber[4]));
        binding.num5.setText(String.valueOf(lotteryNumber[5]));
    }
}
