package com.github.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player {

    String name;
    char symbol;

    public Player(String placeHolder, char symbol) throws IOException {
        System.out.println("Enter name for " + placeHolder);
        this.symbol = symbol;
        this.name = getUserInput();
    }

    protected String getUserInput() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        return in.readLine();
    }

    public void askToPlay(Board board) throws IOException {
        String cellNumber = getUserInputForCell();
        Cell cell = board.getCell(cellNumber);

        if(cell != null){
            play(cell);
        } else {
            askToPlay(board);
        }
    }

    protected String getUserInputForCell() throws IOException {
        return getUserInput();
    }

    private void play(Cell cell) {
        cell.value = this.symbol;
    }

}
