package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Set;

public class Right implements KeyHandler{
    public static final KeyCode code = KeyCode.RIGHT;

    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())) {
            map.getPlayer().move(1, 0);
            Set<Actor> skeletons = map.getSkeletons();
            for (Actor skeleton : skeletons) {
                skeleton.moveRandomDirection();
            }
        }
    }
}
