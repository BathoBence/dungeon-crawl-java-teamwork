package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;

public class GameLogic {
    private GameMap map;

    public GameLogic() {
        this.map = MapLoader.loadMap();
    }

    public void setMap() {
        String playerGold = getPlayerGold();
         String playerHealth = getPlayerHealth();
        this.map = MapLoader.loadMap();
        map.getPlayer().setHealth(Integer.parseInt(playerHealth));
        map.getPlayer().setGold(Integer.parseInt(playerGold));
    }

    public double getMapWidth() {
        return map.getWidth();
    }

    public double getMapHeight() {
        return map.getHeight();
    }

    public void setup() {
    }

    public Cell getCell(int x, int y) {
        return map.getCell(x, y);
    }

    public String getPlayerHealth() {
        return Integer.toString(map.getPlayer().getHealth());
    }

    public String getPlayerGold() {
        return Integer.toString(map.getPlayer().getGold());
    }


    public GameMap getMap() {
        return map;
    }
}
