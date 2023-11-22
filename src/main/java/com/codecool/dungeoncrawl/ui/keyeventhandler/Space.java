package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.logic.MapLoader;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Space implements KeyHandler {
    public static final KeyCode code = KeyCode.SPACE;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())){
            if (map.getPlayer().getCell().getType() == CellType.POTION) {
                map.getPlayer().increaseHealth(10);
                map.getPlayer().getCell().setType(CellType.FLOOR);
            }
        }

    }
}

