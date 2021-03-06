package com.conway.gameoflife;

public class Grid {

    private Cell[][] cellArray;
    private Cell[][] nextGenArray;
    private int dimensions;

    public Grid(int dimension) {
        this.dimensions = dimension;
        this.cellArray = new Cell[dimension][dimension];
        this.nextGenArray = new Cell[dimension][dimension];
    }

    public Cell[][] getCellArray() {
        return cellArray;
    }

    public void populateGrid(Cell[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = new Cell(0, i, j);
            }
        }
    }

    public void shuffleGenerations() {
        this.cellArray = this.nextGenArray;
        this.nextGenArray = new Cell[dimensions][dimensions];
        populateGrid(this.nextGenArray);
    }

    public void printArray(Cell[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j].getStateOfCell());
            }
            System.out.println();
        }
    }

    public void setLiveNeighboursCount() {
        for (int i = 0; i < cellArray.length; i++) {
            for (int j = 0; j < cellArray.length; j++) {
                cellArray[i][j].setNumberOfLiveNeighbours(getLiveNeighbourCount(i, j));
            }
        }
    }

    public int getLiveNeighbourCount(int rowNum, int colNum) {
        int liveNeighbourCount = 0;
        int arrayLength = cellArray.length;
        if (rowNum - 1 >= 0) {
            liveNeighbourCount = cellArray[rowNum - 1][colNum].getStateOfCell() == 1 ? liveNeighbourCount + 1
                    : liveNeighbourCount;
        }

        if (rowNum + 1 < arrayLength) {
            liveNeighbourCount = cellArray[rowNum + 1][colNum].getStateOfCell() == 1 ? liveNeighbourCount + 1
                    : liveNeighbourCount;
        }

        if (colNum - 1 >= 0) {
            liveNeighbourCount = cellArray[rowNum][colNum - 1].getStateOfCell() == 1 ? liveNeighbourCount + 1
                    : liveNeighbourCount;
        }

        if (colNum + 1 < arrayLength) {
            liveNeighbourCount = cellArray[rowNum][colNum + 1].getStateOfCell() == 1 ? liveNeighbourCount + 1
                    : liveNeighbourCount;

        }
        if (rowNum + 1 < arrayLength && colNum + 1 < arrayLength) {
            liveNeighbourCount = cellArray[rowNum + 1][colNum + 1].getStateOfCell() == 1 ? liveNeighbourCount + 1
                    : liveNeighbourCount;

        }
        if (rowNum - 1 >= 0 && colNum - 1 >= 0) {
            liveNeighbourCount = cellArray[rowNum - 1][colNum - 1].getStateOfCell() == 1 ? liveNeighbourCount + 1
                    : liveNeighbourCount;
        }
        if (rowNum + 1 < arrayLength && colNum - 1 >= 0) {
            liveNeighbourCount = cellArray[rowNum + 1][colNum - 1].getStateOfCell() == 1 ? liveNeighbourCount + 1
                    : liveNeighbourCount;

        }
        if (rowNum - 1 >= 0 && colNum + 1 < arrayLength) {
            liveNeighbourCount = cellArray[rowNum - 1][colNum + 1].getStateOfCell() == 1 ? liveNeighbourCount + 1
                    : liveNeighbourCount;

        }

        return liveNeighbourCount;
    }

    public Cell[][] getNextGenArray() {
        return nextGenArray;
    }

    public void setNextGenArray(Cell[][] nextGenArray) {
        this.nextGenArray = nextGenArray;
    }
}
