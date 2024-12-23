package com.vincie;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent(), 400, 200);
        stage.setScene(scene);
        stage.show();
    }

    private Parent createContent() {
        TextField inputTextField = new TextField("");
        HBox inputRow = new HBox(new Label("Name:"), inputTextField);
        inputRow.setSpacing(6);
        inputRow.setAlignment(Pos.CENTER);
        Label outputLabel = new Label("");
        Button actionButton = new Button("Hello");
        actionButton.setOnAction(event -> outputLabel.setText("Hello " + inputTextField.getText()));
        inputTextField.setOnKeyPressed(event -> {
           if (event.getCode() == KeyCode.ENTER) {
               outputLabel.setText("Hello " + inputTextField.getText());
           }
        });
        VBox results = new VBox(20, inputRow, outputLabel, actionButton);
        results.setAlignment(Pos.CENTER);
        return results;
    }

    public static void main(String[] args) {
        HelloFX.launch();
    }
}
