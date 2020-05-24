package com.example.constraintlayoutapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable {
    //References to Dice Image
    ImageView imgDice;

    int diceIDs[];


    //References to Roll Button
    Button rollButton;

    //References to Display Roll #
    TextView displayRoll;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Store Values to preceding variables
        imgDice = (ImageView) findViewById(R.id.diceViewer);

        //Stores the ids of all dice images from the drawable resource folder
        diceIDs = new int[]{R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6};

        //Button Properties
        rollButton = (Button) findViewById(R.id.rollButton);
        rollButton.setOnClickListener(this);

        displayRoll = (TextView) findViewById(R.id.displayRoll);

    }

    //Starts Cycling through images for a duration, then stops displaying the right side of the dice
    public void rollDice(){
        //Random
        Random rand = new Random();

        run();

        rollButton.setClickable(true);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.rollButton:
                //Start Time
                rollDice();
                rollButton.setClickable(false);
                break;
        }
    }

    //Returns an index that we want
    public static int mod(int a, int b){
        int r = a % b;
        //Is r < 0? then return r + b else return r (valid)
        return r < 0? r + b: r;
    }

    @Override
    public void run() {
        //Changes the image based on current value which is altered and managed by the mod() above
        imgDice.setImageResource((diceIDs[mod(++current, diceIDs.length)]));
        imgDice.getHandler().postDelayed(this, 500L);
        Log.d("Cycle Time: ", "This is being cycled afaklsdjf;aksdjf;aksjdf;aksdjfljfk;ds");
    }
}
