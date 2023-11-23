package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.ui.UI;
import com.codecool.dungeoncrawl.ui.keyeventhandler.*;
import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Game extends Application {
    private UI ui;
    private GameLogic logic;
    private Set<KeyHandler> keyHandlers;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name to start your adventure!");
        String playerName = scanner.nextLine();
        this.keyHandlers = Set.of(new Up(), new Down(), new Left(), new Right(), new Space());
        this.logic = new GameLogic();
        this.ui = new UI(logic, keyHandlers, playerName);
        ui.setUpPain(primaryStage);

        primaryStage.setTitle("Dungeon Crawl");
        primaryStage.show();
    }

    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }
}
