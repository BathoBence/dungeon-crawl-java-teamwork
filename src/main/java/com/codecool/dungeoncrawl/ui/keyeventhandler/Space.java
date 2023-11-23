package com.codecool.dungeoncrawl.ui.keyeventhandler;

import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.logic.GameLogic;
import com.codecool.dungeoncrawl.logic.MapLoader;
import com.codecool.dungeoncrawl.ui.elements.MapTypes;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;

import java.util.Objects;

public class Space implements KeyHandler {
    public static final KeyCode code = KeyCode.SPACE;

    AudioClip itemSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/buy-item.mp3")).toExternalForm());

    @Override
    public void perform(KeyEvent event, GameLogic logic) {
        if (code.equals(event.getCode())) {
            if (logic.getMap().getPlayer().getCell().getType() == CellType.POTION) {
                logic.getMap().getPlayer().increaseHealth(10);

                logic.getMap().getPlayer().increaseGold(10);
                AudioClip potionSound = new AudioClip(Objects.requireNonNull(getClass().getResource("/potion.mp3")).toExternalForm());
                potionSound.play();
                System.out.println("potion");
                logic.getMap().getPlayer().getCell().setType(CellType.FLOOR);
            } else if (logic.getMap().getPlayer().getCell().getType() == CellType.DOOR) {
                logic.setMap();
            } else if (logic.getMap().getPlayer().getCell().getType() == CellType.WEAPON) {
                if (logic.getMap().getPlayer().getGold() > 50) {
                    logic.getMap().getPlayer().equipWeapon();
                    itemSound.play();
                    logic.getMap().getPlayer().removeGold(50);
                }

            }
            else if (logic.getMap().getPlayer().getCell().getType() == CellType.ARMOR) {
                if (logic.getMap().getPlayer().getGold() > 50) {
                    itemSound.play();
                    logic.getMap().getPlayer().equipArmor();
                    logic.getMap().getPlayer().increaseHealth(30);
                    System.out.println(logic.getMap().getPlayer().isArmorEquipped());
                    logic.getMap().getPlayer().removeGold(50);
                }
            }
        }
    }
}

