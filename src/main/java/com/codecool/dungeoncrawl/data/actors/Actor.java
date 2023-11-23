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
    AudioClip moveSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/move.mp3")).toExternalForm());
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
            if (nextCell.getActor().getTileName().equals("player")) {
                moveSound.setVolume(0.8);
                    moveSound.play();


            }
            cell = nextCell;
        }
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
    public void increaseGold(int bonusGold) {
        this.gold = gold + bonusGold;
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
