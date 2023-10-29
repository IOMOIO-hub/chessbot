package oop.chess;

import java.util.ArrayList;

public class Player {
    private String color;
    private ArrayList<Figure> takenFigures;
    private int time;
    
    Player(String color){
        this.color = color;
        takenFigures = new ArrayList<Figure>();
        time = 0;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public int getTime(){
        return this.time;
    }

    public void setTime(int time){
        this.time = time;
    }

    public ArrayList<Figure> getTakenFigures(){
        return this.takenFigures;
    }

    public void takeFigure(Figure figure){
        this.takenFigures.add(figure);
    }
}
