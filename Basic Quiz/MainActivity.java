package com.example.constraintlayoutapp5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button submitButton, generateQuestion;
    TextView questionText, response;
    Random rand = new Random();
    Question questions[];
    Question selected;

    RadioButton selectedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        response = findViewById(R.id.response);
        radioGroup = findViewById(R.id.answerGroup);
        questionText = findViewById(R.id.questionField);


        questions = generateQuestions();

        generateQuestion = findViewById(R.id.questionButton);
        generateQuestion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int randInt = rand.nextInt(4);
                selected = questions[randInt];
                String answers[] = selected.getAnswers();

                questionText.setText(selected.getQuestion());
                //Changing text dynamically
                for(int i = 0; i < radioGroup.getChildCount(); i++){
                    ((RadioButton) radioGroup.getChildAt(i)).setText(answers[i]);
                }
            }
        });

        submitButton = findViewById(R.id.submit);
        submitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(selectedButton.getText().equals(selected.getAnswers()[selected.getAnswerIndex()])){
                    response.setText("Answer: Correct");
                }else{
                    response.setText("Incorrect: Try Again!");
                }
            }
        });
    }


    //automatically called when clicking a radio button in a radio group
    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        selectedButton = findViewById(radioId);
    }

    private Question[] generateQuestions(){
        Question q1 = new Question("What is the longest that an elephant has ever lived?", new String[]{"17 Years", "49 Years", "86 Years", "142 Years"}, 3);
        Question q2 = new Question("How Many rings are on the Olympic Flag?", new String[]{"None", "4", "5", "7"}, 2);
        Question q3 = new Question("What is a tarsier?", new String[]{"Primate", "Lizard", "Bird", "None of the Above"}, 0);
        Question q4 = new Question("How did Spider-Man get his powers?", new String[]{"Military Experiment Gone Awry", "Born with them", "Woke up with them after a strange dream", "Bitten by a radioactive spider"}, 3);
        Question q5 = new Question("In darts, what's the most points you can score with a single throw?", new String[]{"20", "50", "60", "100"}, 1);

        return new Question[]{q1, q2, q3, q4, q5};
    }
}
