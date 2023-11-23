package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.data.Cell;
import com.codecool.dungeoncrawl.data.CellType;
import com.codecool.dungeoncrawl.data.GameMap;
import com.codecool.dungeoncrawl.data.actors.*;
import com.codecool.dungeoncrawl.data.items.Armor;
import com.codecool.dungeoncrawl.data.items.Door;
import com.codecool.dungeoncrawl.data.items.Item;
import com.codecool.dungeoncrawl.data.items.Potion;
import com.codecool.dungeoncrawl.data.items.Weapon;
import com.codecool.dungeoncrawl.ui.elements.MainStage;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {



    public static GameMap loadMap(String path) {

        InputStream is = MapLoader.class.getResourceAsStream(path);

        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine();

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Skeleton(cell);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'P':
                            cell.setType(CellType.POTION);
                            new Potion(cell);
                            break;
                        case 'D':
                            cell.setType(CellType.DOOR);
                            new Door(cell);
                            break;
                        case 'B':
                            cell.setType(CellType.FLOOR);
                            new Boss(cell);
                            break;
                        case '!':
                            cell.setType((CellType.WARNING));
                            break;
                        case 'M':
                            cell.setType(CellType.FLOOR);
                            new Merchant(cell);
                            break;
                        case ',':
                            cell.setType(CellType.SHOPFLOOR);
                            break;
                        case 'A':
                            cell.setType(CellType.ARMOR);
                            new Armor(cell);
                            break;
                        case 'W':
                            cell.setType(CellType.WEAPON);
                            new Weapon(cell);
                            break;
                        case 'C':
                            cell.setType(CellType.SHOPFLOOR);
                            new Cat(cell);
                            break;
                        case 'H':
                            cell.setType(CellType.HOLE);
                            break;
                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
