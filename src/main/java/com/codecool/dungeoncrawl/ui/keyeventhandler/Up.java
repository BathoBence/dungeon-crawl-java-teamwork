package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.logic.GameLogic;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Set;

public class Up implements KeyHandler {
    public static final KeyCode code = KeyCode.UP;


    @Override
    public void perform(KeyEvent event, GameLogic logic) {
        if (code.equals(event.getCode())) {
            logic.getMap().getPlayer().move(0, -1);
            logic.getMap().getPlayer().attack();
            Set<Actor> skeletons = logic.getMap().getSkeletons();
            Actor boss = logic.getMap().getBoss();
            for (Actor skeleton : skeletons) {
                skeleton.moveRandomDirection(logic.getMap().getPlayer());
            }
        }
    }
}
