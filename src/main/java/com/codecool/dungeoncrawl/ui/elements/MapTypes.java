package com.codecool.dungeoncrawl.ui.elements;

public enum MapTypes {

    MAIN("/map.txt","Defeat the boss! \n" +
            "If you feel too weak, earn\n" +
            "gold from monsters and buy\n" +
            "items from the merchant!"),
    SHOP("/shop.txt","Finally a friendly face... \n" +
            "The merchant welcomes you.\n" +
            "Each item costs 50 Gold!\n" +
            "You can buy armor for HP\n" +
            "multiple times! \n");
    private final String path;
    private final String label;

    public String getLabel() {
        return label;
    }
    public String getPath() {
        return path;
    }

    MapTypes(String path, String label) {
        this.path = path;
        this.label = label;


    }
}
