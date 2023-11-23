package com.codecool.dungeoncrawl.data.actors;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;

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
                System.out.println(enemy.getTileName());
                System.out.println(enemy.getHealth());
                if(enemy.takingDamage(5)<1);{
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

}
