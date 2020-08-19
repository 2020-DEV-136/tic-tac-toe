package com.github.tictactoe;

import java.io.IOException;
import java.util.Arrays;

public class TicTacToeApplication {

    public static void main(String[] args) throws IOException {

        Game game = new Game(
                Arrays.asList(
                        new Player("Player1",'X'),
                        new Player("Player2",'O')
                ),
                new Board()
        );

        game.start();
    }
}
