package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.logic.MapLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;

import java.util.Objects;

public class Space implements KeyHandler {
    public static final KeyCode code = KeyCode.SPACE;

    @Override
    public void perform(KeyEvent event, GameLogic logic) {
        if (code.equals(event.getCode())){
            if (logic.getMap().getPlayer().getCell().getType() == CellType.POTION) {
                logic.getMap().getPlayer().increaseHealth(10);

                logic.getMap().getPlayer().increaseGold(10);
                AudioClip potionSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/potion.mp3")).toExternalForm());
                potionSound.play();
                System.out.println("potion");
                logic.getMap().getPlayer().getCell().setType(CellType.FLOOR);
            }
            else if (logic.getMap().getPlayer().getCell().getType() == CellType.DOOR) {
                    logic.setMap();
                System.out.println("hi");
                }
            }
    }
}

