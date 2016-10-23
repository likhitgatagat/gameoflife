package com.conway.gameoflife;

public class GameEngine {

    private int dimension;
    private Grid grid;

    public GameEngine(int dimesion) {
        this.dimension = dimesion;
    }

    public void initGrid() {
        this.grid = new Grid(dimension);
        this.grid.populateGrid(grid.getCellArray());
        this.grid.populateGrid(grid.getNextGenArray());
    }

    public Grid getGrid() {
        return grid;
    }

    public void giveLifeToCell(int row, int col) {
        this.grid.getCellArray()[row][col].setStateOfCell(1);
    }

    public void createUniverse() {
        for (int itrRow = 0; itrRow < dimension; itrRow++) {
            for (int itrCol = 0; itrCol < dimension; itrCol++) {
                int life = ((int) (Math.random() * Math.pow(dimension, 2))) % 2;
                if (life == 1) {
                    giveLifeToCell(itrRow, itrCol);
                }
            }
        }
        System.out.println("Generated Initial Universe: ");
        grid.printArray(grid.getCellArray());
    }

    public void startGameOfLife() {
        grid.setLiveNeighboursCount();
        applyGameRules();
        grid.printArray(grid.getNextGenArray());
        System.out.println();
        grid.shuffleGenerations();
    }

    private void applyGameRules() {
        Cell[][] cellArray = getGrid().getCellArray();

        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray.length; j++) {

                if (cellArray[i][j].getStateOfCell() == 1) {
                    ruleForLiveCell(i, j);
                } else if (cellArray[i][j].getStateOfCell() == 0) {
                    rulesForDeadCell(i, j);
                }
            }
        }
    }

    private void ruleForLiveCell(int rowNum, int colmNum) {
        Cell[][] cellArray = getGrid().getCellArray();
        if (cellArray[rowNum][colmNum].getNumberOfLiveNeighbours() < 2
                || cellArray[rowNum][colmNum].getNumberOfLiveNeighbours() > 3) {
            getGrid().getNextGenArray()[rowNum][colmNum].setStateOfCell(0);
        } else if (cellArray[rowNum][colmNum].getNumberOfLiveNeighbours() == 2
                || cellArray[rowNum][colmNum].getNumberOfLiveNeighbours() == 3) {
            getGrid().getNextGenArray()[rowNum][colmNum].setStateOfCell(1);
        }

    }

    private void rulesForDeadCell(int rowNum, int colmNum) {
        Cell[][] cellArray = getGrid().getCellArray();
        if (cellArray[rowNum][colmNum].getNumberOfLiveNeighbours() == 3) {
            getGrid().getNextGenArray()[rowNum][colmNum].setStateOfCell(1);
        }
    }

}
