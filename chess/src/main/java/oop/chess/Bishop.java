package oop.chess;

import java.util.ArrayList;

class Bishop extends Figure {

    public Bishop(String color, Position position) {
        super(color, position);
    }

    public ArrayList<Position> possibleMoves(Board board) {
        ArrayList<Position> result = new ArrayList<Position>();
        Position position = this.getPosition();
        int x = position.getX(), y = position.getY();
        for (int tempX = x + 1, tempY = y + 1; tempX < 8 && tempY < 8; tempX++, tempY++) {
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != this.getColor())
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        for (int tempX = x + 1, tempY = y - 1; tempX < 8 && tempY > -1; tempX++, tempY--) {
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != this.getColor())
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        for (int tempX = x - 1, tempY = y - 1; tempX > -1 && tempY > -1; tempX--, tempY--) {
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != this.getColor())
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        for (int tempX = x - 1, tempY = y + 1; tempX > -1 && tempY < 8; tempX--, tempY++){
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != this.getColor())
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        return result;
    }
    
    public char getType() {
        if (this.getColor() == "White")
            return '♗';
        else
            return '♝';
    }
}