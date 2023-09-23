package com.example.destinationsquiz;

import javafx.application.Application;
import javafx.stage.Stage;

import static com.example.destinationsquiz.SelectCountries.*;

public class Runner extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Destinations Quiz");
        primaryStage.show();
        primaryStage.setScene(CreateSelectCountriesScene(primaryStage));
    }
}
