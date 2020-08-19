package com.github.tictactoe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Board {

    List<List<Cell>> rows = new ArrayList();
    List<List<Cell>> columns = new ArrayList();
    List<Cell> cells = new ArrayList<>();

    char cellValue = '1';


    public Board() {
        initRows();
        initColumns();
    }

    private void initColumns() {
        initEmptyColumns();
        fillColumns();
    }

    private void fillColumns() {
        for(int rowNumber = 0; rowNumber < rows.size(); rowNumber++){
            List<Cell> row = rows.get(rowNumber);
            for(int cellNumber = 0; cellNumber < row.size(); cellNumber++){
                columns.get(cellNumber).set(rowNumber, row.get(cellNumber));
            }
        }
    }

    private void initEmptyColumns() {
        for(int i = 0; i < 3; i++){
            List<Cell> column = new ArrayList<>();
            for(int j = 0; j < 3; j++){
                column.add(null);
            }
            columns.add(column);
        }

    }

    private void initRows() {
        for(int rowNumber = 0; rowNumber < 3; rowNumber++){
            List<Cell> row = new ArrayList<>();
            addCells(row);
            rows.add(row);
        }
    }

    private void addCells(List<Cell> cells) {
        for(int cellNumber = 0; cellNumber < 3; cellNumber++){
            Cell cell = new Cell(cellValue);
            cells.add(cell);
            this.cells.add(cell);
            cellValue++;
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int rowNumber = 0; rowNumber < rows.size(); rowNumber++){
            StringBuilder _sb = new StringBuilder("| ");
            List<Cell> row = rows.get(rowNumber);
            for(int cellNumber = 0; cellNumber < columns.size(); cellNumber++){
                _sb.append(row.get(cellNumber).value);
                _sb.append(" | ");
            }
            sb.append(_sb.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public Cell getCell(String cellNumber) {
        try {
            Integer _cellNumber = Integer.parseInt(cellNumber);
            return checkBoard(_cellNumber - 1);
        } catch (Exception e){
            System.out.println("Invalid number, please chose another number");
            return null;
        }
    }

    private Cell checkBoard(Integer cellNumber) {
        try{
            Cell cell = cells.get(cellNumber);
            if(isValid(cell)){
                return cell;
            } else {
                System.out.println("Invalid number, please chose another number");
                return null;
            }
        } catch (Exception e){
        }
        System.out.println("Invalid number, please chose another number");
        return null;
    }

    private boolean isValid(Cell cell) {
        if(cell.value >= '1' && cell.value <= '9'){
            return true;
        }
        return false;
    }

    public BOARDRESULT check() {
        if(isWinner()){
            return BOARDRESULT.WINNER;
        } else if(isDraw()){
            return BOARDRESULT.DRAW;
        } else {
            return BOARDRESULT.CONTINUE;
        }
    }

    private boolean isWinner() {
        return isWinner(rows) || isWinner(columns) || isWinner(rows, columns);
    }

    private boolean isWinner(List<List<Cell>> rows, List<List<Cell>> columns) {
        return isWinner(cells.get(0), cells.get(4), cells.get(8)) ||
                isWinner(cells.get(2), cells.get(4), cells.get(6));
    }

    private boolean isWinner(Cell cell1, Cell cell2, Cell cell3) {
        return cell1.equals(cell2) && cell2.equals(cell3);
    }

    private boolean isWinner(List<List<Cell>> listOfCells) {
        for(List<Cell> cells : listOfCells){
            Set<Cell> _cells = new HashSet<>(cells);

            if(_cells.size() == 1){
                return true;
            }
        }

        return false;
    }

    private boolean isDraw() {
        return !hasAvailableCells();
    }

    private boolean hasAvailableCells() {
        for(Cell cell : cells){
            if(cell.value >= '1' && cell.value <= '9'){
                return true;
            }
        }

        return false;
    }
}
