package oop.chess;

import java.util.ArrayList;

abstract class Figure {

    private String color;
    private Coord placement;

    public Figure(String color, Coord placement) {
        this.color = color;
        this.placement = placement;
    }

    public Coord getPlacement(){
        return this.placement;
    }

    public String getColor(){
        return this.color;
    }

    abstract public char getType();
    abstract public ArrayList<Coord> possibleTurns(Figure[][] board);
}
