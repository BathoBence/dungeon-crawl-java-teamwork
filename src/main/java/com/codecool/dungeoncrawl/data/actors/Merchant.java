package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Merchant extends Actor{

    public Merchant(Cell cell) {
        super(cell);
        this.setFriendly();
    }

    @Override
    public String getTileName() {
        return "merchant";
    }
}
