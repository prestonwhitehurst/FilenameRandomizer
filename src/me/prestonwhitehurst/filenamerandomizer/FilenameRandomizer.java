package com.resmagnus.filenamerandomizer;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FilenameRandomizer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Filename Randomizer");
        FilenameRandomizerModel model = new FilenameRandomizerModel();
        FilenameRandomizerView view = new FilenameRandomizerView();
        FilenameRandomizerController controller = new FilenameRandomizerController(primaryStage, model, view);
        Scene scene = new Scene(controller.getView(), 425, 135);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        getLastWindowLocation(primaryStage);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            Double x = primaryStage.getX();
            Double y = primaryStage.getY();
            File file = new File(System.getProperty("user.dir") + "/lastWindowLocation.txt");
            try {
                FileWriter fw = new FileWriter(file);
                fw.write(x + "\n");
                fw.write(String.valueOf(y));
                fw.close();
            }catch(IOException ex) {
                System.out.println("Could not find file");
            }
            primaryStage.close();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void getLastWindowLocation(Stage primaryStage) {
        File file = new File(System.getProperty("user.dir") + "/lastWindowLocation.txt");

        if(!file.exists()) {
            try {
                primaryStage.centerOnScreen();
                FileWriter fw = new FileWriter(file);
                fw.write(primaryStage.getX() + "\n");
                fw.write(String.valueOf(primaryStage.getY()));
                fw.close();
            }catch(IOException e) {
                System.out.println("Could Not Create File");
            }
        }

        else {
            try {
                Scanner scanner = new Scanner(file);
                String x = scanner.nextLine();
                String y = scanner.nextLine();
                x = x.replace("\n", "");
                y = y.replace("\n", "");
                primaryStage.setX(Double.parseDouble(x));
                primaryStage.setY(Double.parseDouble(y));
            }catch(FileNotFoundException e) {
                System.out.println("File Not Found");
                primaryStage.centerOnScreen();
            }
        }
    }
}
