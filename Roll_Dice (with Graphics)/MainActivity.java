package com.example.constraintlayoutapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, Runnable{
    //References to Dice Image
    ImageView imgDice;

    //Contains the ids of all dice drawables
    int diceIDs[];

    //Used for indexing the dice images with the mod()
    int current = -1;

    //Contains the starting time
    long start;

    //Contains the ending time
    long end;

    //How long you want the cycling of images to go for (in milliseconds)
    long cycleDuration = 3000;

    //References to Roll Button
    Button rollButton;

    //References to Display Roll #
    TextView displayRoll, rollDisplay;

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
        rollDisplay = (TextView) findViewById(R.id.rollDisplay);

    }

    //Starts Cycling through images for a duration, then stops displaying the right side of the dice
    public void rollDice(){
        start = System.currentTimeMillis();
        end = start + cycleDuration;
        run();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.rollButton:
                //Start Time
                rollButton.setVisibility(View.GONE);
                rollDisplay.setVisibility(View.VISIBLE);
                rollDice();
                break;
        }
    }

    //Used for cycling through dice images
    public static int mod(int a, int b){
        int r = a % b;
        //Is r < 0? then return r + b else return r (valid)
        return r < 0? r + b: r;
    }

    @Override
    public void run() {
        //Changes the image based on current value which is altered and managed by the mod() above
        if(System.currentTimeMillis() < end){
            imgDice.setImageResource((diceIDs[mod(++current, diceIDs.length)]));
            imgDice.getHandler().postDelayed(this, 150L);
        }else{
            //Random Object
            Random rand = new Random();

            //Generate Random Roll
            int generateRoll = rand.nextInt(6) + 1;

            //Display correct dice image and the dice roll value
            imgDice.setImageResource(diceIDs[generateRoll - 1]);
            displayRoll.setText("Dice Rolled: " + generateRoll);

            //Reset Button Display
            rollButton.setVisibility(View.VISIBLE);
            rollDisplay.setVisibility(View.GONE);

            return;
        }
    }
}
