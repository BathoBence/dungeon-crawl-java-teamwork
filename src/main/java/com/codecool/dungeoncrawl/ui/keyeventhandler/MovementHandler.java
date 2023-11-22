package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.GameMap;
import javafx.scene.input.KeyEvent;


public interface MovementHandler{


    Boolean checkMovementDirection(KeyEvent event, GameMap map);
}
