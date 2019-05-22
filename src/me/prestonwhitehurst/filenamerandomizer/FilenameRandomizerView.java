package com.resmagnus.filenamerandomizer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FilenameRandomizerView {
    private VBox root;
    private HBox hBox;
    private TextField folderPathTextField;
    private Button chooseFolderButton;
    private Button randomizeButton;
    private Label statusLabel;

    public FilenameRandomizerView() {
        folderPathTextField = new TextField();
        folderPathTextField.setEditable(false);
        folderPathTextField.setMaxWidth(300);
        folderPathTextField.setPrefWidth(300);
        chooseFolderButton = new Button("Choose folder");
        randomizeButton = new Button("Randomize!");
        statusLabel = new Label();

        hBox = new HBox();
        root = new VBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(folderPathTextField, chooseFolderButton);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(hBox, randomizeButton, statusLabel);
    }

    public VBox getRoot() {
        return root;
    }

    public TextField getFolderPathTextField() {
        return folderPathTextField;
    }

    public Button getChooseFolderButton() {
        return chooseFolderButton;
    }

    public Button getRandomizeButton() {
        return randomizeButton;
    }

    public Label getStatusLabel() {
        return statusLabel;
    }
}