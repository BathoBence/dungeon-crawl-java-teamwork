package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;

import java.util.Random;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if(nextCell.getType() != CellType.WALL && nextCell.getActor()== null){
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public int getHealth() {
        return health;
    }

    public void increaseHealth(int bonusHealth){
        health += bonusHealth;
    }

    public Cell getCell() {
        return cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

    public void moveRandomDirection(){
        Random random = new Random();
        int randomInt = random.nextInt(4);
        switch (randomInt+1){
            case 1:
                //Up
                this.move(0,-1);
                break;
            case 2:
                //Down
                this.move(0,1);
                break;
            case 3:
                //Right
                this.move(1,0);
                break;
            case 4:
                //Left
                this.move(-1,0);
                break;
        }
    };
}
