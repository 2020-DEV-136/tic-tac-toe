package com.github.tictactoe;

import org.junit.jupiter.api.Test;
import static junit.framework.Assert.assertEquals;
import java.io.IOException;

public class PlayerTest {

    DummyPlayer player = new DummyPlayer("Player1", 'X');

    public PlayerTest() throws IOException {
    }

    @Test
    public void constructorTest() throws IOException {
        assertEquals("Bot",player.name);
        assertEquals('X',player.symbol);
    }

    @Test
    public void askToPlayTest() throws IOException {
        Board board = new Board();
        player.askToPlay(board);
        assertEquals('X', board.cells.get(0).value);
    }
}
