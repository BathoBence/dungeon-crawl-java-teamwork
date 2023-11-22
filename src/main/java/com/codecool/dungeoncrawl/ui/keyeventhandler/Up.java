package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Up implements KeyHandler, MovementHandler {
    public static final KeyCode code = KeyCode.UP;

    @Override
    public void perform(KeyEvent event, GameMap map) {
        if(code.equals(event.getCode())){

            if(checkMovementDirection(event,map)){
                map.getPlayer().move(0, -1);
            } else {
                System.out.println("Balls to the walls");
            }
        }
    }

    @Override
    public Boolean checkMovementDirection(KeyEvent event, GameMap map){
        CellType currentCell = map.getCell(map.getPlayer().getX(), map.getPlayer().getY() - 1).getType();
        return currentCell == CellType.FLOOR || currentCell == CellType.POTION || currentCell == CellType.DOOR;
    }
}
