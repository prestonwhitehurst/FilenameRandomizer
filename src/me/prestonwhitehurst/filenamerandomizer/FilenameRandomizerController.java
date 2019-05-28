package com.resmagnus.filenamerandomizer;

import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import java.io.IOException;

public class FilenameRandomizerController {
    private FilenameRandomizerModel model;
    private FilenameRandomizerView view;
    private DirectoryChooser directoryChooser;

    public FilenameRandomizerController(Stage primaryStage, FilenameRandomizerModel model, FilenameRandomizerView view) {
        this.model = model;
        this.view = view;
        directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Open Resource File");
        view.getChooseFolderButton().setOnAction(e -> chooseFolderButtonClicked(primaryStage));
        view.getRandomizeButton().setOnAction(e -> randomizeButtonClicked());
    }

    public VBox getView() {
        return view.getRoot();
    }

    public void chooseFolderButtonClicked(Stage primaryStage) {
        view.getStatusLabel().setText("");

        try {
            File f = directoryChooser.showDialog(primaryStage);
            model.setFolder(f);
            view.getFolderPathTextField().setText(model.getFolder().getAbsolutePath());
        }catch(NullPointerException e) {
            System.out.println("User has cancelled folder selection.");
        }
        
    }

    public void randomizeButtonClicked() {
        File[] files = model.getFiles();
        
        if(files != null) {
            String fileName;
            String originalExtension;
            
            for(File file : files) {
                
                if(file.isFile()) {
                    fileName = file.getName();
                    originalExtension = FilenameUtils.getExtension(fileName);
                    File newFile = new File(model.getFolder().getAbsolutePath() +
                            "/" + RandomString.create(8) + "." + originalExtension);
                    
                    try {
                        FileUtils.moveFile(file, newFile);
                    }catch (IOException e) {
                        Alert dialog = new Alert(Alert.AlertType.ERROR);
                        dialog.setHeaderText("File(s) Could Not Be Renamed");
                        dialog.setContentText(e.getMessage());
                        dialog.setResizable(true);
                        dialog.getDialogPane().setPrefSize(480, 320);
                        dialog.showAndWait();
                    }
                    
                }
                
            }
            
            view.getStatusLabel().setText("Files have been successfully renamed");
        }
    }
}
