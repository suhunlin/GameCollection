package com.suhun.gamecollection.gameobj;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class GuessAB {
    public String tag = GuessAB.class.getSimpleName();
    private String answer;
    private int answerLen;

    public GuessAB(){
        super();
        this.answerLen = 4;
        setAnswer();
    }

    private void setAnswer(){
        this.answer = createAnswer();
        Log.d(tag, "The answer is " + this.answer);
    }

    private String createAnswer(){
        HashSet<Integer> numSet = new HashSet<Integer>();
        while(numSet.size()<this.answerLen){
            numSet.add(new Random().nextInt(10));
        }
        List<Integer> numList = new ArrayList<Integer>();
        for(Integer num:numSet){
            numList.add(num);
        }
        Collections.shuffle(numList);
        StringBuffer stringBuffer = new StringBuffer();
        for(Integer num:numList){
            stringBuffer.append(num);
        }
        return stringBuffer.toString();
    }
}
