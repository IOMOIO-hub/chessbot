package oop.chess;

import java.util.ArrayList;

class Rook extends Figure {

    public Rook(String color, Coord placement) {
        super(color, placement);
    }

    public ArrayList<Coord> possibleTurns(Figure[][] board){
        ArrayList<Coord> result = new ArrayList<Coord>();
        Coord placement = this.getPlacement();
        int x = placement.getX(), y = placement.getY();
        for (int tempX = x + 1; tempX < 8; tempX++){
            if (board[tempX][y] == null){
                result.add(new Coord(tempX, y));
            }
            else{
                break;
            }
        }

        for (int tempY = y - 1; tempY > -1; tempY--){
            if (board[x][tempY] == null){
                result.add(new Coord(x, tempY));
            }
            else{
                break;
            }
        }

        for (int tempX = x - 1; tempX > -1; tempX--){
            if (board[tempX][y] == null){
                result.add(new Coord(tempX, y));
            }
            else{
                break;
            }
        }

        for (int tempY = y + 1; tempY < 8; tempY++){
            if (board[x][tempY] == null){
                result.add(new Coord(x, tempY));
            }
            else{
                break;
            }
        }

        return result;
    }
    public char getType(){
        return '♖';
    }
}
