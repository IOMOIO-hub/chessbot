package oop.chess;

public class Player {
    
    private String color;
    private int time;
    
    Player(String color){
        this.color = color;
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
}
