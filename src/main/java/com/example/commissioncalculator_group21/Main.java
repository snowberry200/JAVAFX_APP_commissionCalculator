package com.example.commissioncalculator_group21;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        //try to load and display the FXML FILE
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("scene.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Assignment 1__Group 21__!");
            stage.setScene(scene);
            stage.show();

        }
        //catch and print any error
        catch(Exception e){
            e.printStackTrace();

        }

    }
    //  main method where application is launched
    public static void main(String[] args) {
        launch();
    }
}