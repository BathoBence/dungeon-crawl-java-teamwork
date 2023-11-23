package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Weapon extends Item{
    public Weapon(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "weapon";
    }
}
