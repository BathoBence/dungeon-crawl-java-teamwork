package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.Actor;
import com.codecool.dungeoncrawl.data.actors.Player;
import com.codecool.dungeoncrawl.ui.elements.MapTypes;
import com.codecool.dungeoncrawl.ui.elements.StatusPane;
import jdk.jshell.Snippet;

public class GameLogic {

    private MapTypes mapType;
    private GameMap map;

    private StatusPane statusPane;

    public GameLogic() {
        this.mapType = MapTypes.MAIN;
        this.map = MapLoader.loadMap(mapType.getPath());
    }

    public void setMap() {
        if (mapType == MapTypes.MAIN) {
            mapType = MapTypes.SHOP;
        }  else {
        mapType = MapTypes.MAIN;
        }
        boolean isArmorEquipped = map.getPlayer().isArmorEquipped();
        boolean isWeaponEquipped = map.getPlayer().isWeaponEquipped();
        String playerGold = getPlayerGold();
         String playerHealth = getPlayerHealth();
        this.map = MapLoader.loadMap(mapType.getPath());
        map.getPlayer().setHealth(Integer.parseInt(playerHealth));
        map.getPlayer().setGold(Integer.parseInt(playerGold));
        if (isArmorEquipped) {
            map.getPlayer().equipArmor();
        }
        if (isWeaponEquipped) {
            map.getPlayer().equipWeapon();
        }

    }

    public MapTypes getMapType() {
        return mapType;
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
