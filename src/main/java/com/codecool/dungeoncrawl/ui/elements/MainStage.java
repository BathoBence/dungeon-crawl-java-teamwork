package com.codecool.dungeoncrawl.ui.elements;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;

public class MainStage {
    private Canvas canvas;
    private Scene scene;
    private StatusPane statusPane;

    public MainStage(Canvas canvas) {
        this.canvas = canvas;
        statusPane = new StatusPane();
        scene = setUpScene();
    }

    public Scene setUpScene() {
        BorderPane borderPane = statusPane.build();
        borderPane.setCenter(canvas);
        Scene scene = new Scene(borderPane);
        return scene;
    }
    public Scene getScene() {
        return scene;
    }
    public void setHealthLabelText(String text) {
        this.statusPane.setHealthValue(text);
    }

    public void setGoldLabelText(String text) {
        this.statusPane.setGoldValue(text);
    }

    public StatusPane getStatusPane() {
        return statusPane;
    }

    public void setPlayerNameText(String playerName) {
        this.statusPane.setPlayerName(playerName);
    }

    public void setMerchantText(String text) {
        this.statusPane.setMerchantText(text);
    }
}
