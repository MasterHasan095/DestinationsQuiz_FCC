package com.example.destinationsquiz;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SelectCountries {
    private static ArrayList<Button> countriesButtons = new ArrayList<>();

    public static Scene CreateSelectCountriesScene(Stage primaryStage) throws IOException {
        VBox mainPane = new VBox();
        Quiz quiz = new Quiz();

        BufferedReader reader;
        reader = new BufferedReader(new FileReader("TextFiles/countries.txt"));
        String name;
        while ((name = reader.readLine()) != null) {
            Button btn = new Button(name);
            btn.setOnAction(e -> {
                quiz.loadQuiz(btn);
            });
            btn.setPrefWidth(150);
            btn.setPrefHeight(70);
            countriesButtons.add(btn);
        }
        GridPane grid = new GridPane();
        int counter = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid.add(countriesButtons.get(counter), j, i);
                counter++;
            }
        }
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        mainPane.setAlignment(Pos.CENTER);
        mainPane.getChildren().add(grid);


        return new Scene(mainPane, 1200, 700);
    }

    public static ArrayList<Button> getCountriesButtons() {
        return countriesButtons;
    }

}
