package com.example.destinationsquiz;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Quiz {

    private final int NUMBEROFQUESTIONS = 5;
    private final int NUMBEROFOPTIONS = 4;
    private final int QUESTIONLENGTH = NUMBEROFQUESTIONS * (NUMBEROFOPTIONS +1);

    private Scene scene;
    private static ScrollPane rootScroll = new ScrollPane();
    private static VBox root = new VBox();
private Stage primaryStage;
    public void CreateQuizScene(){
        rootScroll.setContent(root);setScene(rootScroll);
    }

    public void loadQuiz(Button btn) throws IOException {
        BufferedReader reader;
        String buttonClicked = btn.getText();
        reader = new BufferedReader(new FileReader("TextFiles/questions.txt"));
        String line = reader.readLine();
        while (!(line.equals(buttonClicked))){
            line = reader.readLine();
        }
        for (int i = 0; i < QUESTIONLENGTH; i++){
            for (int j =0; j < NUMBEROFQUESTIONS; j++){
                VBox questionVBOX = new VBox();
                ToggleGroup question = new ToggleGroup();
                Text questionText = new Text(reader.readLine());
                questionVBOX.getChildren().add(questionText);
                for (int k = 0; k < NUMBEROFOPTIONS;k++){
                    RadioButton radioButton = new RadioButton();
                    radioButton.setText(reader.readLine());
                    radioButton.setToggleGroup(question);
                    questionVBOX.getChildren().add(radioButton);
                }
                root.getChildren().add(questionVBOX);
            }
        }
    CreateQuizScene();
    }
}
