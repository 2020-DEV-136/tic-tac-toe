package com.github.tictactoe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.tictactoe.BOARDRESULT.WINNER;

public class Game {

    List<Player> players = new ArrayList<>();
    Board board;

    Player currentPlayer;
    int currentPlayerIndex = 0;

    public Game(List<Player> players, Board board) {
        this.players = players;
        this.currentPlayer = players.get(currentPlayerIndex);
        this.board = board;
    }

    public void start() throws IOException {
        play();
    }

    private void play() throws IOException {
        System.out.println("-------------------");
        System.out.println(board.toString());
        System.out.println(currentPlayer.name + " Please enter the cell number : ");
        currentPlayer.askToPlay(board);
        BOARDRESULT boardResult = board.check();

        if(!gameOver(boardResult)){
            changePlayer();
            play();
        }else{
            System.out.println(board.toString());
        }
    }

    private void changePlayer() {
        updatePlayerIndex();
        currentPlayer = players.get(currentPlayerIndex);
    }

    private void updatePlayerIndex() {
        if(currentPlayerIndex == players.size() - 1){
            currentPlayerIndex = 0;
        }else {
            currentPlayerIndex = currentPlayerIndex + 1;
        }
    }

    private boolean gameOver(BOARDRESULT boardResult) {
        switch (boardResult){
            case WINNER:
            case DRAW:
                informPlayers(boardResult);
                return true;
            default:
                return false;
        }
    }

    private void informPlayers(BOARDRESULT boardResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("The game is over with the result: " + boardResult + ".");
         if(boardResult == WINNER){
             sb.append(" Winner is " + currentPlayer.name);
         }
        System.out.println(sb.toString());
    }
}
