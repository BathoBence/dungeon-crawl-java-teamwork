package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;

import java.util.ArrayList;
import java.util.List;
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
            return "player4";
        } else if (isArmorEquipped) {
            return "player3";
        } else if (isWeaponEquipped) {
            return "player2";
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
        if(this.getTileName().equals("player")){
            Random random = new Random();
            List<Actor> enemies = searchNeighbourCells(this.getCell());
            for(Actor enemy : enemies){
                System.out.println(enemy.getTileName());
                System.out.println(enemy.getHealth());
                if(enemy.takingDamage(5)==0);{
                    this.increaseGold(random.nextInt(5));
                }
                System.out.println(enemy.getHealth());
            }
        }
    }

    public List<Actor> searchNeighbourCells(Cell cell){
        List<Actor> enemies = new ArrayList<>();
        if(cell.getNeighbor(-1,0).getActor() !=null){
            //Add enemy on the Left
            enemies.add(cell.getNeighbor(-1,0).getActor());
        } else if(cell.getNeighbor(0,1).getActor() !=null){
            //Add enemy below
            enemies.add(cell.getNeighbor(0,1).getActor());
        } else if(cell.getNeighbor(1,0).getActor() !=null){
            //Add enemy on the Right
            enemies.add(cell.getNeighbor(1,0).getActor());
        } else if(cell.getNeighbor(0,-1).getActor() !=null){
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
