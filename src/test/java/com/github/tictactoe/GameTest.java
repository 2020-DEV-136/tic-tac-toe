package com.github.tictactoe;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class GameTest {

    Board board = new Board();
    static List<Player> players = new ArrayList<>();
    static {
        try {
            players.add(new DummyPlayer("Bot",'X'));
            players.add(new DummyPlayer("Noob",'O'));
        } catch (IOException e) {
            e.getMessage();
        }
    }
    Game game = new Game(players, board);

    @Test
    public void constructorTest() throws IOException {
        assertEquals('X',game.players.get(0).symbol);
        assertEquals('O',game.players.get(1).symbol);
    }
}
