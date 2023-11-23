package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.sun.source.tree.InstanceOfTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player extends Actor {
    public Player(Cell cell) {
        super(cell);
    }

    public String getTileName() {
        return "player";
    }

    public void attack(){
        if(this.getTileName().equals("player")){
            Random random = new Random();
            List<Actor> enemies = searchNeighbourCells(this.getCell());
            for(Actor enemy : enemies){
                int remainingHP = enemy.takingDamage(5);
                if(enemy.getTileName().equals("boss")){
                    Boss boss = enemy instanceof Boss ? ((Boss) enemy) : null;
                    assert boss != null;
                    boss.attackBack(this);
                }
                if(remainingHP<1);{
                    this.increaseGold(random.nextInt(5));
                }
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

}
