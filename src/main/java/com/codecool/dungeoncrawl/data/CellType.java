package com.codecool.dungeoncrawl.data;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    POTION("potion"),
    DOOR("door"),
    SHOPFLOOR("shop-floor"),
    WARNING("!"),
    CORPSE("corpse"),
    ARMOR("armor"),
    WEAPON("weapon"),
    HOLE("hole");


    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }

}
