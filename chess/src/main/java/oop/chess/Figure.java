package oop.chess;

import java.util.ArrayList;

abstract class Figure {

    private final String color;
    private Position position;

    public Figure(String color, Position position) {
        this.color = color;
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public String getColor() {
        return this.color;
    }

    abstract public ArrayList<Position> possibleMoves(Board board);
    public boolean isSelectable(Board board) {
        return possibleMoves(board).size() > 0;
    }

    abstract public String getSymbol();
}
