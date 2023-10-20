package oop.chess;

import java.util.ArrayList;

class King extends Figure {

    public King(String color, Position position) {
        super(color, position);
    }
    
    public ArrayList<Position> possibleMoves(Board board){
        ArrayList<Position> result = new ArrayList<Position>();
        Position position = this.getPosition();
        int x = position.getX(), y = position.getY();
        int[][] kingsTurns = {{1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}};
        
        for (int i = 0; i < 8; i++){
            int newX = x + kingsTurns[i][0], newY = y + kingsTurns[i][1];
            if ((newX >= 0) && (newX <= 7) && (newY >= 0) && (newY <= 7) && (board.at(newX, newY) == null)){
                result.add(new Position(newX, newY));
            }
        }
        
        return result;
    }

    public char getType(){
        return '♔';
    }
}
