package com.suhun.gamecollection.gameobj;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.suhun.gamecollection.databinding.ActivityGuessAbactivityBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class GuessAB {
    public String tag = GuessAB.class.getSimpleName();
    private String answer;
    private int guessCounter;
    private int guessLimit;
    private int answerLen;
    private int tempWhich;

    public GuessAB(){
        super();
        this.answerLen = 4;
        this.guessLimit = 10;
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

    public String checkResult(Context context, String userInput){
        String result = "Type length error!!!";
        if(userInput==null){
            Toast.makeText(context, "Input digit null, need "+answerLen+"digits", Toast.LENGTH_LONG).show();
        }else if(userInput.length()>answerLen){
           Toast.makeText(context, "Input digit to long only need "+answerLen+"digits", Toast.LENGTH_LONG).show();
        }else if(userInput.length()<answerLen){
            Toast.makeText(context, "Input digit to short only need "+answerLen+"digits", Toast.LENGTH_LONG).show();
        }else{
            guessCounter++;
            result = check(userInput);
        }
        return result;
    }

    private String check(String userInput){
        int a=0, b=0;
        for(int i=0;i<answer.length();i++){
            if(answer.charAt(i)==userInput.charAt(i)){
                a++;
            }else if(answer.contains(""+userInput.charAt(i))){
                b++;
            }
        }
        return String.format("%dA%dB",a,b).toString();
    }

    public void showSettingAlertDialog(Context context, Resources resources){
        String[] items = {"2", "3", "4", "5"};
        int checkedItem=0;

        for(int i=0;i<items.length;i++){
            if(items[i].equals(String.valueOf(answerLen))){
                checkedItem = i;
                tempWhich = i;
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
                .setCancelable(false)
                .create()
                .show();
    }

    public void showResetAlertDialog(Context context, Resources resources, ActivityGuessAbactivityBinding binding){
        new AlertDialog.Builder(context)
                .setTitle("Reset Game")
                .setMessage("Are you sure?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        initGame();
                        binding.log.setText("");
                        binding.userInput.setText("");
                    }
                })
                .setNeutralButton("Cancel", null)
                .setCancelable(false)
                .create()
                .show();
    }

    public void showGuessAlertDialog(Context context, Resources resources, ActivityGuessAbactivityBinding binding){
        String userInput = binding.userInput.getText().toString();
        String result = checkResult(context, userInput);
        String message ;
        DialogInterface.OnClickListener positiveListener=null;
        if(isGuessResult(result)){//not null or input too long or input too short
            //not over guess limit
            if(guessCounter<guessLimit){
                if(result.equals(answerLen+"A0B")){//guess success
                    message = "You got it!!!Reset game?";
                    positiveListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            initGame();
                            binding.log.setText("");
                        }
                    };
                }else{//guess fail
                    message = userInput + ":" + result + "\t" + guessCounter + "times \n";
                    binding.log.append(message);
                }
            }else{//over guess limit
                message = "Over game limit " + guessLimit + "Reset game";
                positiveListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        initGame();
                        binding.log.setText("");
                    }
                };
            }
            binding.userInput.setText("");
            new AlertDialog.Builder(context)
                    .setTitle("Guess Result")
                    .setMessage(message)
                    .setPositiveButton("Ok", positiveListener)
                    .setNeutralButton("Cancel", null)
                    .setCancelable(false)
                    .create()
                    .show();
        }
    }
    Boolean isGuessResult(String result){//check the first letter is 0-9
        int tempResult = Integer.valueOf(result.charAt(0));

        if(tempResult>=48 &&tempResult<=57){//mapping to ASCII 0=48 9=57
            return true;
        }else{
            return false;
        }
    }
}
