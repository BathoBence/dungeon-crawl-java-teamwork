package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Left implements KeyHandler, MovementHandler {
    public static final KeyCode code = KeyCode.LEFT;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if(code.equals(event.getCode())){
            if(checkMovementDirection(event,map)){
                map.getPlayer().move(-1, 0);
            } else {
                System.out.println("Balls to the walls");
            }
        }
    }


    @Override
        public Boolean checkMovementDirection(KeyEvent event, GameMap map){
            CellType currentCell = map.getCell(map.getPlayer().getX() - 1, map.getPlayer().getY()).getType();
            return currentCell == CellType.FLOOR || currentCell == CellType.POTION;
    }
}
