package com.codecool.dungeoncrawl.data.items;

import com.codecool.dungeoncrawl.data.Cell;

public class Armor extends Item {
    public Armor(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "armor";
    }
}
