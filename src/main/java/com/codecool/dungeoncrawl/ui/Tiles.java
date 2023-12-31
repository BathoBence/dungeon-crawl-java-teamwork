package com.codecool.dungeoncrawl.ui;

import com.codecool.dungeoncrawl.data.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("empty", new Tile(6, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(25, 0));
        tileMap.put("playerWithWeapon", new Tile(27,0));
        tileMap.put("playerWithArmor", new Tile(30,0));
        tileMap.put("playerFullyEquipped", new Tile(28,0));
        tileMap.put("skeleton", new Tile(29, 6));
        tileMap.put("potion", new Tile(23,23));
        tileMap.put("door", new Tile(6,5));
        tileMap.put("merchant", new Tile(24, 2));
        tileMap.put("quest-icon", new Tile(20, 25));
        tileMap.put("shop-floor", new Tile(16, 0));
        tileMap.put("corpse", new Tile(0,15));
        tileMap.put("boss", new Tile(25,8));
        tileMap.put("!",new Tile(20,27));
        tileMap.put("armor", new Tile(2,22));
        tileMap.put("weapon", new Tile(0,30));
        tileMap.put("gold", new Tile(9,25));
        tileMap.put("cat", new Tile(30,7));
        tileMap.put("hole", new Tile(13,17));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }

    public static void drawTile(GraphicsContext context, String s, int x, int y) {
        Tile tile = tileMap.get(s);
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
