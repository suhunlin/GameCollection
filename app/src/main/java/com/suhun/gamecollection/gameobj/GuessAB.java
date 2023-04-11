package com.suhun.gamecollection.gameobj;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.Log;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class GuessAB {
    public String tag = GuessAB.class.getSimpleName();
    private String answer;
    private int guessCounter;
    private int answerLen;
    private int tempWhich;

    public GuessAB(){
        super();
        this.answerLen = 4;
        initGame();
    }

    public void initGame(){
        guessCounter = 0;
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

    public void showSettingAlertDialog(Context context, Resources resources){
        String[] items = {"2", "3", "4", "5"};
        int checkedItem=0;

        for(int i=0;i<items.length;i++){
            if(items[i].equals(String.valueOf(answerLen))){
                checkedItem = i;
            }
        }
        new AlertDialog.Builder(context)
                .setTitle("Setting Guess Answer Length")
                .setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(tag, "SingleChoiceItems move to " + which);
                        tempWhich = which;
                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        answerLen = Integer.valueOf(items[tempWhich]);
                        Log.d(tag, "Reset answerLen " + answerLen);
                        initGame();
                    }
                })
                .setNeutralButton("Cancel", null)
                .create()
                .show();
    }
}
