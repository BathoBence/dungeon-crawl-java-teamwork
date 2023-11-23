package com.codecool.dungeoncrawl.data;

import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Boss;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.data.actors.Skeleton;

import java.util.HashSet;
import java.util.Set;

public class GameMap {
    private int width;
    private int height;
    private Cell[][] cells;

    private Player player;

    public GameMap(int width, int height, CellType defaultCellType) {
        this.width = width;
        this.height = height;
        cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = new Cell(this, x, y, defaultCellType);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public Set<Actor> getSkeletons(){
        Set<Actor> skeletons = new HashSet<>();
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                Cell cell = getCell(x,y);
                if(cell.getActor()!= null && cell.getActor().getTileName().equals("skeleton")){
                    skeletons.add(cell.getActor());
                }
            }
        }
        return skeletons;
    }

    public Actor getBoss(){
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                Cell cell = getCell(x,y);
                if(cell.getActor()!= null && cell.getActor().getTileName().equals("boss")){
                   return cell.getActor();
                }
            }
        }
        return null;
    }

    public boolean getMapType() {
        return true;
    }
}
