package com.conway.gameoflife;

public class Cell {

    private int stateOfCell;
    private int numberOfLiveNeighbours;
    private int rowNum;
    private int columnNum;

    public Cell(int state, int rowNum, int ColumnNum) {
        this.setStateOfCell(state);
        this.setRowNum(rowNum);
        this.setColumnNum(columnNum);
    }

    public int getStateOfCell() {
        return stateOfCell;
    }

    public void setStateOfCell(int stateOfCell) {
        this.stateOfCell = stateOfCell;
    }

    public int getNumberOfLiveNeighbours() {
        return numberOfLiveNeighbours;
    }

    public void setNumberOfLiveNeighbours(int numberOfLiveNeighbours) {
        this.numberOfLiveNeighbours = numberOfLiveNeighbours;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }
}
