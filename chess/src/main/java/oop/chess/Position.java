package oop.chess;

public class Position {
    
    private int x;
    private int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Position(String str) {
        this.x = str.charAt(0) - 'a';
        this.y = str.charAt(1) - '0' - 1;
    }
    
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return (char)(x + 'a') + "" + (char)(y + '0' + 1) + "";
    }

    public boolean equals(Position other) {
        return this.x == other.x && this.y == other.y;
    }
}
