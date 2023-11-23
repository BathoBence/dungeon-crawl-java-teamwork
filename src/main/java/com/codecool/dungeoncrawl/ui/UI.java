package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.ui.elements.MainStage;
import com.codecool.dungeoncrawl.ui.keyeventhandler.KeyHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Set;

public class UI {

    AudioClip moveSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/move.mp3")).toExternalForm());
    private Canvas canvas;
    private GraphicsContext context;

    private MainStage mainStage;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;


    public UI(GameLogic logic, Set<KeyHandler> keyHandlers, String playerName) {
        this.canvas = new Canvas(
                logic.getMapWidth() * Tiles.TILE_WIDTH,
                logic.getMapHeight() * Tiles.TILE_WIDTH);
        this.logic = logic;
        this.context = canvas.getGraphicsContext2D();
        this.mainStage = new MainStage(canvas);
        mainStage.setPlayerNameText(playerName);
        if (logic.getMap().getMapType()) {
        mainStage.setMerchantText(" ");
        }
        this.keyHandlers = keyHandlers;
    }

    public void setUpPain(Stage primaryStage) {
        Scene scene = mainStage.getScene();
        primaryStage.setScene(scene);
        logic.setup();
        refresh();
        scene.setOnKeyPressed(this::onKeyPressed);
    }

    private void onKeyPressed(KeyEvent keyEvent) {
        for (KeyHandler keyHandler : keyHandlers) {
            //moveSound.play();
            keyHandler.perform(keyEvent, logic);
        }
        refresh();
    }

    public void refresh() {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
         mainStage.setMerchantText(logic.getMapType().getLabel());
        for (int x = 0; x < logic.getMapWidth(); x++) {
            for (int y = 0; y < logic.getMapHeight(); y++) {
                Cell cell = logic.getCell(x, y);
                if (cell.getActor() != null) {
                    if (cell.getActor().getTileName().equalsIgnoreCase("merchant")) {
                        Tiles.drawTile(context, "quest-icon", x, y - 1);
                    }
                    Tiles.drawTile(context, cell.getActor(), x, y);
                } else {
                    if (cell.getType().getTileName().equalsIgnoreCase("weapon") ||cell.getType().getTileName().equalsIgnoreCase("armor")){
                        Tiles.drawTile(context,"gold",x, y - 1);
                        System.out.println("hi gold");
                    }
                    Tiles.drawTile(context, cell, x, y);
                }
            }
        }
        mainStage.setHealthLabelText(logic.getPlayerHealth());
        mainStage.setGoldLabelText(logic.getPlayerGold());
    }
}
