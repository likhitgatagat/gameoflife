package com.conway.gameoflife;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class GameEngineTest extends TestCase {
    private GameEngine gameEngine;
    private final int dimesion = 5;

    @Override
    protected void setUp() throws Exception {
        gameEngine = new GameEngine(dimesion);
        gameEngine.initGrid();
    }

    public void testForInitializationOfUnivese() {
        assertEquals(dimesion, gameEngine.getGrid().getCellArray().length);
    }

    public void testForGameRules() {
        Grid grid = gameEngine.getGrid();
        Cell[][] cellArray = grid.getCellArray();
        cellArray[1][2].setStateOfCell(1);
        cellArray[2][2].setStateOfCell(1);
        cellArray[3][2].setStateOfCell(1);
        for (int genItr = 0; genItr < 6; genItr++) {
            gameEngine.startGameOfLife();
        }
    }

}
