package com.example.destinationsquiz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Answer {
    BufferedReader reader;
    public Answer() throws FileNotFoundException {
        reader = new BufferedReader(new FileReader("TextFiles/answers.txt"));
    }
    public int checkAnswer(){
        int score = 0;
        System.out.println("We are in check ans");
        return score;
    }
}
