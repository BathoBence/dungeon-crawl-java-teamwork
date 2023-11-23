package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

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
