package oop.chess;

public class Player {

    private String color;
    private Timer timer;
    
    Player(String color) {
        this.color = color;
        timer = new Timer();
    }

    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Timer getTimer() {
        return this.timer;
    }
    public long getTime() {
        return this.timer.getValue();
    }
}
