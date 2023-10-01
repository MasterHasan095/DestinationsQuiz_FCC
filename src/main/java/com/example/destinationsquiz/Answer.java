package com.example.destinationsquiz;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Answer {
    BufferedReader reader;
    private ArrayList<String> correctAnswers = new ArrayList<>();
    public Answer() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader("TextFiles/answers.txt"));
    }
    public int checkAnswer(ArrayList<String> chosenAnswers) throws IOException {
        int score = 0;
        String line = reader.readLine();
        while (!(line.equals(Quiz.countrySelected))){
            line = reader.readLine();
        }
        for (int i = 0; i< Quiz.NUMBEROFQUESTIONS;i++){
            correctAnswers.add(reader.readLine());
        }
        for (int i = 0; i< Quiz.NUMBEROFQUESTIONS;i++){
            String correctAnswer = correctAnswers.get(i);
            String chosenAnswer = chosenAnswers.get(i);
            if (correctAnswer.equals(chosenAnswer)){
                score++;
            }
        }
        return score;
    }

    public Scene scoreCheck(int score){
        VBox finalVBOX = new VBox();
        if (score != 5){
            Label lbl1 = new Label("Sorry but you didnt score in full");
            Label lbl2 = new Label("We can't add you in lucky draw");
            Label lbl3 = new Label("But chill you did well");
            Label lbl4 = new Label("Your score was : " + score);
            finalVBOX.getChildren().addAll(lbl1,lbl2,lbl3,lbl4);
        }
        return new Scene(finalVBOX,1000,1000);
    }

}
