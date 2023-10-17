package oop.chess;

import java.util.ArrayList;

class King extends Figure {

    public King(String color, Coord placement) {
        super(color, placement);
    }
    
    public ArrayList<Coord> possibleTurns(Figure[][] board){
        ArrayList<Coord> result = new ArrayList<Coord>();
        Coord placement = this.getPlacement();
        int x = placement.getX(), y = placement.getY();
        int[][] kingsTurns = {{1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}};
        
        for (int i = 0; i < 8; i++){
            int newX = x + kingsTurns[i][0], newY = y + kingsTurns[i][1];
            if ((newX >= 0) && (newX <= 7) && (newY >= 0) && (newY <= 7) && (board[newX][newY] == null)){
                result.add(new Coord(newX, newY));
            }
        }
        
        return result;
    }

    public char getType(){
        return '♔';
    }
}
