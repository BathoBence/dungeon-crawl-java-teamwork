package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;

public class Cat extends Actor {
    public Cat(Cell cell) {
        super(cell);
        setEnemy(false);
    }

    @Override
    public String getTileName() {
        return "cat";
    }
}
