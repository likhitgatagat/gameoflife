package com.conway.gameoflife;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class GameEngineTest 
    extends TestCase
{
    private GameEngine gameEngine;
    private final int dimesion = 5;
    
	@Override
	protected void setUp() throws Exception {
    	gameEngine = new GameEngine(dimesion);
    	gameEngine.initGrid();
	}
	
    public void testForInitializationOfUnivese()
    {
        assertEquals(dimesion, gameEngine.getGrid().getCellArray().length);
    }
    
    /*public void testIfGridIsPopulatedWithCells() {
    	Grid grid = gameEngine.getGrid(); 
    	grid.populateGrid();
    	Cell[][] cellArray = grid.getCellArray();
    	cellArray[1][2].setStateOfCell(1);
    	cellArray[2][2].setStateOfCell(1);
    	cellArray[3][2].setStateOfCell(1);
    	grid.printGrid();
    	assertTrue(grid.getCellArray()[4][3] instanceof Cell);
    }*/
    
    public void testForGameRules() {
    	Grid grid = gameEngine.getGrid(); 
    	grid.populateGrid();
    	Cell[][] cellArray = grid.getCellArray();
    	cellArray[1][2].setStateOfCell(1);
    	cellArray[2][2].setStateOfCell(1);
    	cellArray[3][2].setStateOfCell(1);
    	grid.setLiveNeboursCount();
    	gameEngine.applyGameRules();
    	grid.printArray(grid.getCellArray());
    	System.out.println();
    	grid.printArray(grid.getNextGenArray());
    }
    
}
