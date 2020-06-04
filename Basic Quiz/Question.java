package com.example.constraintlayoutapp5;

public class Question {
    private String question;
    private int answerIndex;
    private String answers[];

    public String getQuestion(){ return this.question;}
    public int getAnswerIndex(){return this.answerIndex;}
    public String[] getAnswers(){return this.answers;}

    public Question(){}

    public Question(String question, String answers[], int answerIndex){
        this.question = question;
        this.answers = answers;
        this.answerIndex = answerIndex;
    }
}
