package com.github.tictactoe;

import com.github.tictactoe.BOARDRESULT;
import com.github.tictactoe.Board;
import com.github.tictactoe.Cell;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class BoardTest {

    Board board = new Board();

    @Test
    public void noArgumentConstructorTest(){
        assertEquals(3, board.rows.size());
        assertEquals(3, board.columns.size());
        assertEquals(9,board.cells.size());
    }

    @Test
    public void getCellTest(){
        Cell cell = board.getCell("2");
        assertEquals((int)'2', cell.value);
    }

    @Test
    public void getInvalidCellTest(){
        Cell cell = board.getCell("InvalidCell");
        assertNull(cell);
    }

    @Test
    public void getInvalidCellNumberTest(){
        Cell cell = board.getCell("10");
        assertNull(cell);
    }

    @Test
    public void getOccupiedCellNumberTest(){
        Board board = new Board();
        board.cells.get(0).value = 'X';
        Cell cell = board.getCell("1");
        assertNull(cell);
    }

    @Test
    public void toStringTest(){
        assertEquals("| 1 | 2 | 3 | \n" +
                "| 4 | 5 | 6 | \n" +
                "| 7 | 8 | 9 | \n",board.toString());
    }

    @Test
    public void checkContinueStateTest(){
        assertEquals(BOARDRESULT.CONTINUE,board.check());
    }

    @Test
    public void checkWinnerInRowTest(){
        Board board = new Board();
        prepareToWin(board.rows.get(0));
        assertEquals(BOARDRESULT.WINNER,board.check());
    }

    @Test
    public void checkWinnerInColumnTest(){
        Board board = new Board();
        prepareToWin(board.columns.get(0));
        assertEquals(BOARDRESULT.WINNER,board.check());
    }

    @Test
    public void checkWinnerInLeftDiagonalTest(){
        Board board = new Board();
        prepareToWin(Arrays.asList(board.cells.get(0), board.cells.get(4), board.cells.get(8)));
        assertEquals(BOARDRESULT.WINNER,board.check());
    }

    @Test
    public void checkWinnerInRightDiagonalTest(){
        Board board = new Board();
        prepareToWin(Arrays.asList(board.cells.get(2), board.cells.get(4), board.cells.get(6)));
        assertEquals(BOARDRESULT.WINNER,board.check());
    }

    @Test
    public void checkDrawTest(){
        Board board = new Board();
        prepareToDraw(board.cells);
        System.out.println(board.toString());
        assertEquals(BOARDRESULT.DRAW,board.check());
    }

    private void prepareToDraw(List<Cell> cells) {
        cells.get(0).value = 'X';
        cells.get(1).value = 'O';
        cells.get(2).value = 'O';
        cells.get(3).value = 'O';
        cells.get(4).value = 'O';
        cells.get(5).value = 'X';
        cells.get(6).value = 'X';
        cells.get(7).value = 'X';
        cells.get(8).value = 'O';
    }

    private void prepareToWin(List<Cell> cells) {
        for(Cell cell : cells){
            cell.value = 'X';
        }
    }
}
