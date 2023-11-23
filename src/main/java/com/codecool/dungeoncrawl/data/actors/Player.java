package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.sun.source.tree.InstanceOfTree;
import javafx.scene.media.AudioClip;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Player extends Actor {

    private boolean isArmorEquipped;

    private boolean isWeaponEquipped;
    public Player(Cell cell) {
        super(cell);
        isArmorEquipped = false;
        isWeaponEquipped = false;
    }

    public String getTileName()
    {
        if (isWeaponEquipped && isArmorEquipped) {
            return "playerFullyEquipped";
        } else if (isArmorEquipped) {
            return "playerWithArmor";
        } else if (isWeaponEquipped) {
            return "playerWithWeapon";
        } else {
        return "player";
        }
    }

    public void equipArmor() {
        isArmorEquipped = true;
    }

    public void equipWeapon() {
        isWeaponEquipped = true;
    }

    public void attack(){
        Random random = new Random();
        List<Actor> enemies = searchNeighbourCells(this.getCell());
        int playerDamage = 5;
        if(this.isWeaponEquipped){
            playerDamage = 10;
        }
        for(Actor enemy : enemies){
            int remainingHP = enemy.takingDamage(playerDamage);
            if(enemy.getTileName().equals("boss")){
                Boss boss = enemy instanceof Boss ? ((Boss) enemy) : null;
                assert boss != null;
                boss.attackBack(this);
            }
            if(remainingHP<1);{
                if (enemy.getTileName().equalsIgnoreCase("boss")) {
                    AudioClip bossDeath = new AudioClip(Objects.requireNonNull(getClass().getResource("/bossdeath.mp3")).toExternalForm());
                    bossDeath.play();
                }
                this.increaseGold(random.nextInt(5));
            }
        }
    }

    public List<Actor> searchNeighbourCells(Cell cell){
        List<Actor> enemies = new ArrayList<>();
        if((cell.getNeighbor(-1,0)!=cell) && cell.getNeighbor(-1,0).getActor() !=null && cell.getNeighbor(-1,0).getActor().isEnemy()){
            //Add enemy on the Left
            enemies.add(cell.getNeighbor(-1,0).getActor());
        } else if(cell.getY()<19 && cell.getNeighbor(0,1).getActor() !=null && cell.getNeighbor(0,1).getActor().isEnemy()){
            //Add enemy below
            enemies.add(cell.getNeighbor(0,1).getActor());
        } else if(cell.getNeighbor(1,0) != null && cell.getNeighbor(1,0).getActor() !=null && cell.getNeighbor(1,0).getActor().isEnemy()){
            //Add enemy on the Right
            enemies.add(cell.getNeighbor(1,0).getActor());
        } else if(cell.getY()>0 && cell.getNeighbor(0,-1).getActor() !=null && cell.getNeighbor(0,-1).getActor().isEnemy()){
            //Add enemy up
            enemies.add(cell.getNeighbor(0,-1).getActor());
        }
        return enemies;
    }

    public boolean isArmorEquipped() {
        return isArmorEquipped;
    }

    public boolean isWeaponEquipped() {
        return isWeaponEquipped;
    }
}
