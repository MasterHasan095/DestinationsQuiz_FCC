package com.example.destinationsquiz;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Quiz {
    public static Scene CreateQuizScene(Stage primaryStage){
        Pane pane = new Pane();
        return new Scene(pane,1000,800);
    }
}
