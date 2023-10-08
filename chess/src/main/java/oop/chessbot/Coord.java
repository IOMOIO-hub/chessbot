package oop.chessbot;

public class Coord {
    private int x;
    private int y;
    
    Coord(){
        
    }

    Coord(int x, int y){
        this.x = x;
        this.y = y;
    }

    Coord(String str){
        this.x = str.charAt(0) - 'a';
        this.y = str.charAt(1) - '0' - 1;
    }
    
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public String toString() {
        return (char)(x + 'a') + "" + (char)(y + '0' + 1) + " ";
    }
}
