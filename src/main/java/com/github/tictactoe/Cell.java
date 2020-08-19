package com.github.tictactoe;

public class Cell {
    char value;

    public Cell(char value){
        this.value = value;
    }

    @Override
    public boolean equals(Object other){
        Cell _cell = (Cell) other;
        return this.value == _cell.value;
    }

    @Override
    public int hashCode(){
        return 31 * (int) value;
    }
}
