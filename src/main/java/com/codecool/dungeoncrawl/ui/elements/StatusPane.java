package com.codecool.dungeoncrawl.ui.elements;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class StatusPane {
    public static final int RIGHT_PANEL_WIDTH = 200;
    public static final int RIGHT_PANEL_PADDING = 10;
    private GridPane ui;

    private Label playerName;
    private Label merchantTextLabel;
    private Label healthTextLabel;
    private Label healthValueLabel;
    private Label goldTextLabel;
    private Label goldValueLabel;

    public StatusPane() {
        ui = new GridPane();

        playerName = new Label();
        healthTextLabel = new Label("Health: ");
        healthValueLabel = new Label();
        goldTextLabel = new Label("Gold: ");
        goldValueLabel = new Label();
        merchantTextLabel = new Label();
    }

    public BorderPane build() {

        ui.setPrefWidth(RIGHT_PANEL_WIDTH);
        ui.setPadding(new Insets(RIGHT_PANEL_PADDING));

        ui.add(playerName, 0, 0);
        ui.add(healthTextLabel, 0, 1);
        ui.add(healthValueLabel, 1, 1);
        ui.add(goldTextLabel, 0, 2);
        ui.add(goldValueLabel, 1, 2);
        ui.add(merchantTextLabel, 0, 3);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(ui);
        return borderPane;
    }

    public void setHealthValue(String text) {
        healthValueLabel.setText(text);
    }

    public void setGoldValue(String text) {
        goldValueLabel.setText(text);
    }

    public void setPlayerName(String text) {
        playerName.setText(text);
    }

    public void setMerchantText(String text) {
        merchantTextLabel.setText(text);
    }
}
