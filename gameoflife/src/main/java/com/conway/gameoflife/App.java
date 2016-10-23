package com.conway.gameoflife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println("***Welcome to Game Of Life***");
        System.out.println("Enter dimension (x) of your universe: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int dimesion = Integer.parseInt(br.readLine());
        GameEngine gameEngine = new GameEngine(dimesion);
        gameEngine.initGrid();
        System.out.println("Do you want to create your own universe?(y/n");
        if (br.readLine().equals("y")) {
            System.out.println("How many live cells are there in initial generation?");
            int numberOfLiveCells = Integer.parseInt(br.readLine());
            for (int i = 0; i < numberOfLiveCells; i++) {
                System.out.println("Enter row and column position of live cell (rowNum colNum)");
                String[] position = br.readLine().split(" ");
                int row = Integer.parseInt(position[0]);
                int col = Integer.parseInt(position[1]);
                if (row >= 0 && row < dimesion && col >= 0 && col < dimesion) {
                    gameEngine.giveLifeToCell(row, col);
                } else {
                    System.out.println("Invalid input for row or column, aborting game...");
                    gameEngine = null;
                    break;
                }
            }
        } else {
            gameEngine.createUniverse();
        }
        System.out.println("How many generations would you like to see?");
        int numberOfGenerations = Integer.parseInt(br.readLine());
        if (gameEngine != null) {
            for (int genItr = 0; genItr < numberOfGenerations; genItr++) {
                gameEngine.startGameOfLife();
            }
        }
    }
}
