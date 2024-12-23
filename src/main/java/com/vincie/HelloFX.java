package com.vincie;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(createContent(), 400, 200);
        stage.setScene(scene);
        stage.show();
    }

    private Parent createContent() {
        HBox hBox = new HBox(new Label("Name:"), new TextField(""));
        hBox.setSpacing(6);
        hBox.setPadding(new Insets(0,0,0,50));
        hBox.setAlignment(Pos.CENTER_LEFT);

        return hBox;
    }

    public static void main(String[] args) {
        HelloFX.launch();
    }
}
