package com.vincie;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloFX extends Application {

    private final StringProperty greeting = new SimpleStringProperty("");
    private final StringProperty name = new SimpleStringProperty("");

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent(), 400, 200);
        stage.setScene(scene);
        stage.show();
    }

    private Region createContent() {
        VBox results = new VBox(20, createInputRow(), createOutputLabel(), createGreetingButton());
        results.setAlignment(Pos.CENTER);
        results.getStylesheets().add(this.getClass().getResource("/css/beginners.css").toExternalForm());
        return results;
    }

    private Node createGreetingButton() {
        Button results = new Button("Hello");
        results.setOnAction(evt -> setGreeting());
        return results;
    }

    private Node createInputRow() {
        TextField textField = new TextField("");
        textField.textProperty().bindBidirectional(name);
        Label namePrompt = new Label("Name:");
        namePrompt.getStyleClass().add("prompt-label");
        HBox hBox = new HBox(6, namePrompt, textField);
        hBox.setAlignment(Pos.CENTER);
        return hBox;
    }

    private Node createOutputLabel() {
        Label results = new Label("");
        results.getStyleClass().add("greeting-label");
        results.textProperty().bind(greeting);
        return results;
    }

    private void setGreeting() {
        greeting.set("Hello " + name.get());
    }

    public static void main(String[] args) {
        HelloFX.launch();
    }
}
