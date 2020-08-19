package com.github.tictactoe;

import java.io.IOException;

public class DummyPlayer extends Player{

    public DummyPlayer(String placeHolder, char symbol) throws IOException {
        super(placeHolder, symbol);
    }

    @Override
    protected String getUserInput(){
        return "Bot";
    }

    @Override
    protected String getUserInputForCell(){
        return "1";
    }

}
