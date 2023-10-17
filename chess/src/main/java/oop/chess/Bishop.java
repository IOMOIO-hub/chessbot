package oop.chess;

import java.util.ArrayList;

class Bishop extends Figure {

    public Bishop(String color, Coord placement) {
        super(color, placement);
    }

    public ArrayList<Coord> possibleTurns(Figure[][] board){
        ArrayList<Coord> result = new ArrayList<Coord>();
        Coord placement = this.getPlacement();
        int x = placement.getX(), y = placement.getY();
        for (int tempX = x + 1, tempY = y + 1; tempX < 8 && tempY < 8; tempX++, tempY++){
            if (board[tempX][tempY] == null){
                result.add(new Coord(tempX, tempY));
            }
            else{
                break;
            }
        }

        for (int tempX = x + 1, tempY = y - 1; tempX < 8 && tempY > -1; tempX++, tempY--){
            if (board[tempX][tempY] == null){
                result.add(new Coord(tempX, tempY));
            }
            else{
                break;
            }
        }

        for (int tempX = x - 1, tempY = y - 1; tempX > -1 && tempY > -1; tempX--, tempY--){
            if (board[tempX][tempY] == null){
                result.add(new Coord(tempX, tempY));
            }
            else{
                break;
            }
        }

        for (int tempX = x - 1, tempY = y + 1; tempX > -1 && tempY < 8; tempX--, tempY++){
            if (board[tempX][tempY] == null){
                result.add(new Coord(tempX, tempY));
            }
            else{
                break;
            }
        }

        return result;
    }
    
    public char getType(){
        return '♗';
    }
}