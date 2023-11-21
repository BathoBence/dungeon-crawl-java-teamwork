package com.codecool.dungeoncrawl.logic;

import java.util.Arrays;
import java.util.Random;

public class MapGenerator {
    public static void main(String[] args) {
        int width = 20; // Width of the map
        int height = 15; // Height of the map

        char[][] randomMap = generateRandomMap(width, height);

        // Print the random map
        printMap(randomMap);
    }

    // Method to generate a random map
    public static char[][] generateRandomMap(int width, int height) {
        Random random = new Random();
        char[][] map = new char[height][width];

        char[] possibleChars = {'#', '.', ' ', '@', 's'}; // Symbols used in the map

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int randIndex = random.nextInt(possibleChars.length);
                map[i][j] = possibleChars[randIndex];
            }
        }
        return map;
    }

    // Method to print the map
    public static void printMap(char[][] map) {
        for (char[] row : map) {
            System.out.println(row);
        }
    }
}
