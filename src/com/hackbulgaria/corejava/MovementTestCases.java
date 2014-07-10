package com.hackbulgaria.corejava;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovementTestCases {

    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        int[][] newBoard = new int[][]{
            {0,8,2,0},
            {0,2,4,0},
            {0,2,2,0},
            {0,2,8,0}
        };
        game.setBoard(newBoard);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        int[][] expectedBoard = new int[][]{
                {0,0,2,0},
                {0,8,4,0},
                {0,2,2,0},
                {0,4,8,0}
            };
        this.game.moveDown();

        assertArrayEquals(game.getBoard(), expectedBoard);
    }

}
