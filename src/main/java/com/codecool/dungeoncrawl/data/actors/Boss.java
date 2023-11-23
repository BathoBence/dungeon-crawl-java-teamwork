package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import javafx.scene.media.AudioClip;

import java.util.Objects;

public class Boss extends Actor{


    public Boss(Cell cell) {
        super(cell);
        this.setHealth(20);
    }

    @Override
    public String getTileName() {
        return "boss";
    }

    public void attackBack(Actor player){
        player.takingDamage(3);
    }
}
