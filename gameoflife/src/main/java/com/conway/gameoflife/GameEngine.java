package com.conway.gameoflife;

public class GameEngine {

	private int dimension;
	private Grid grid;
	
	public GameEngine(int dimesion) {
		this.dimension = dimesion;
	}
	
	public void initGrid() {
		this.grid = new Grid(dimension);
	}
	
	public Grid getGrid() {
		return grid;
	}

	public void applyGameRules() {
		Cell[][] cellArray =  getGrid().getCellArray();
		
		for(int i = 0; i<cellArray.length; i++) {
			for(int j = 0; j<cellArray.length; j++) {
				
				if(cellArray[i][j].getStateOfCell() == 1)
				{
					ruleForLiveCell(i, j);
				}
				else if(cellArray[i][j].getStateOfCell() == 0)
				{
					rulesForDeadCell(i,j);
				}
			}
		}
	}
	
	public void ruleForLiveCell(int rowNum, int colmNum)
	{
		Cell[][] cellArray =  getGrid().getCellArray();
		//Cell[][] nextGenArray = getGrid().getNextGenArray();
		if(cellArray[rowNum][colmNum].getNumberOfLiveNeighbours() < 2 || cellArray[rowNum][colmNum].getNumberOfLiveNeighbours() > 3)
		{
			getGrid().getNextGenArray()[rowNum][colmNum].setStateOfCell(0);
		}
		else if(cellArray[rowNum][colmNum].getNumberOfLiveNeighbours() == 2 || cellArray[rowNum][colmNum].getNumberOfLiveNeighbours() == 3)
		{
			getGrid().getNextGenArray()[rowNum][colmNum].setStateOfCell(1);
		}
		
	}
	
	public void rulesForDeadCell(int rowNum, int colmNum)
	{
		Cell[][] cellArray =  getGrid().getCellArray();
		//Cell[][] nextGenArray = getGrid().getNextGenArray();
		if(cellArray[rowNum][colmNum].getNumberOfLiveNeighbours() == 3)
		{
			getGrid().getNextGenArray()[rowNum][colmNum].setStateOfCell(1);
		}
	}

}
