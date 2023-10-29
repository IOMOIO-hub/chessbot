package oop.chess;

import java.util.ArrayList;

class Rook extends Figure {

    public Rook(String color, Position position) {
        super(color, position);
    }

    public ArrayList<Position> possibleMoves(Board board) {
        ArrayList<Position> result = new ArrayList<Position>();
        Position position = this.getPosition();
        int x = position.getX(), y = position.getY();
        for (int tempX = x + 1; tempX < 8; tempX++){
            if (board.at(tempX, y) == null){
                result.add(new Position(tempX, y));
            }
            else{
                if (board.at(tempX, y).getColor() != this.getColor())
                    result.add(new Position(tempX, y));
                break;
            }
        }

        for (int tempY = y - 1; tempY > -1; tempY--) {
            if (board.at(x, tempY) == null){
                result.add(new Position(x, tempY));
            }
            else{
                if (board.at(x, tempY).getColor() != this.getColor())
                    result.add(new Position(x, tempY));
                break;
            }
        }

        for (int tempX = x - 1; tempX > -1; tempX--) {
            if (board.at(tempX, y) == null){
                result.add(new Position(tempX, y));
            }
            else{
                if (board.at(tempX, y).getColor() != this.getColor())
                    result.add(new Position(tempX, y));
                break;
            }
        }

        for (int tempY = y + 1; tempY < 8; tempY++) {
            if (board.at(x, tempY) == null){
                result.add(new Position(x, tempY));
            }
            else{
                if (board.at(x, tempY).getColor() != this.getColor())
                    result.add(new Position(x, tempY));
                break;
            }
        }

        return result;
    }
    public char getType() {
        if (this.getColor() == "White")
            return '♖';
        else
            return '♜';
    }
}
