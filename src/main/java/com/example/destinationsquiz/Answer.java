package com.example.destinationsquiz;

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
    public int checkAnswer(ArrayList<String> answers) throws IOException {
        int score = 0;
        System.out.println("We are in check ans");
        System.out.println(answers);
        System.out.println(Quiz.countrySelected);
        String line = reader.readLine();
        while (!(line.equals(Quiz.countrySelected))){
            line = reader.readLine();
        }
        for (int i = 0; i< Quiz.NUMBEROFQUESTIONS;i++){
            correctAnswers.add(reader.readLine());
            System.out.println(correctAnswers);
        }
        return score;
    }
}
