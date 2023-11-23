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
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())){
            if (map.getPlayer().getCell().getType() == CellType.POTION) {
                map.getPlayer().increaseHealth(10);
                map.getPlayer().increaseGold(10);
                AudioClip potionSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/potion.mp3")).toExternalForm());
                potionSound.play();
                System.out.println("potion");
                map.getPlayer().getCell().setType(CellType.FLOOR);
            }
            else if (map.getPlayer().getCell().getType() == CellType.DOOR) {
                    MapLoader.changeMaps(1);
                System.out.println("hi");
                }
            }
    }
}

