package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Set;

public class Down implements KeyHandler{
    public static final KeyCode code = KeyCode.DOWN;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if (code.equals(event.getCode())) {
            map.getPlayer().move(0, 1);
            map.getPlayer().attack();
            Set<Actor> skeletons = map.getSkeletons();
            for (Actor skeleton : skeletons) {
                skeleton.moveRandomDirection(map.getPlayer());
            }
        }
    }
}
