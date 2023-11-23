package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.Drawable;
import com.codecool.dungeoncrawl.data.items.Potion;
import com.codecool.dungeoncrawl.logic.GameLogic;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;

import java.awt.event.KeyEvent;

import java.util.Objects;
import java.util.Random;

public abstract class Actor implements Drawable {
    private Cell cell;
    private int health = 10;

    private int gold = 0;

    public Actor(Cell cell) {
        this.cell = cell;
        this.cell.setActor(this);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if(nextCell.getType() != CellType.WALL && nextCell.getActor() == null){
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
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

    public void increaseHealth(int bonusHealth) {
        this.health = health + bonusHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }


    public int takingDamage(int damage){
        this.health -= damage;
        if(this.health <=0){
            this.getCell().setActor(null);
            this.getCell().setType(CellType.CORPSE);
            return 0;
        }
        return health;
    }
    public void increaseGold(int bonusGold) {
        this.gold = gold + bonusGold;
    }

    public void moveRandomDirection(Actor player){
        Random random = new Random();
        int randomInt = random.nextInt(4);
        if(!isPlayerNearby(this)) {
            switch (randomInt + 1) {
                case 1:
                    //Up
                    this.move(0, -1);
                    break;
                case 2:
                    //Down
                    this.move(0, 1);
                    break;
                case 3:
                    //Right
                    this.move(1, 0);
                    break;
                case 4:
                    //Left
                    this.move(-1, 0);
                    break;
            }
        } else {
            player.takingDamage(2);
        }
    }

    public boolean isPlayerNearby(Actor skeleton){
        return (skeleton.getCell().getNeighbor(1, 0).getActor() != null && skeleton.getCell().getNeighbor(1, 0).getActor().getTileName().equals("player")) ||
                (skeleton.getCell().getNeighbor(-1, 0).getActor() != null && skeleton.getCell().getNeighbor(-1, 0).getActor().getTileName().equals("player")) ||
                (skeleton.getCell().getNeighbor(0, 1).getActor() != null && skeleton.getCell().getNeighbor(0, 1).getActor().getTileName().equals("player")) ||
                skeleton.getCell().getNeighbor(0, -1).getActor() != null && skeleton.getCell().getNeighbor(0, -1).getActor().getTileName().equals("player");
    }
}
