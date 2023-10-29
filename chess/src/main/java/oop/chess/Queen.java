package oop.chess;

import java.util.ArrayList;

class Queen extends Figure {

    public Queen(String color, Position position) {
        super(color, position);
    }

    public ArrayList<Position> possibleMoves(Board board) {
        ArrayList<Position> result = new ArrayList<Position>();
        Position position = this.getPosition();
        int x = position.getX(), y = position.getY();
        String queenColor = this.getColor();

        for (int tempX = x + 1; tempX < 8; tempX++){
            if (board.at(tempX, y) == null) {
                result.add(new Position(tempX, y));
            }
            else{
                if (board.at(tempX, y).getColor() != queenColor)
                    result.add(new Position(tempX, y));
                break;
            }
        }

        for (int tempY = y - 1; tempY > -1; tempY--) {
            if (board.at(x, tempY) == null) {
                result.add(new Position(x, tempY));
            }
            else{
                if (board.at(x, tempY).getColor() != queenColor)
                    result.add(new Position(x, tempY));
                break;
            }
        }

        for (int tempX = x - 1; tempX > -1; tempX--) {
            if (board.at(tempX, y) == null) {
                result.add(new Position(tempX, y));
            }
            else{
                if (board.at(tempX, y).getColor() != queenColor)
                    result.add(new Position(tempX, y));
                break;
            }
        }

        for (int tempY = y + 1; tempY < 8; tempY++) {
            if (board.at(x, tempY) == null) {
                result.add(new Position(x, tempY));
            }
            else{
                if (board.at(x, tempY).getColor() != queenColor)
                    result.add(new Position(x, tempY));
                break;
            }
        }

        for (int tempX = x + 1, tempY = y + 1; tempX < 8 && tempY < 8; tempX++, tempY++) {
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != queenColor)
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        for (int tempX = x + 1, tempY = y - 1; tempX < 8 && tempY > -1; tempX++, tempY--) {
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != queenColor)
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        for (int tempX = x - 1, tempY = y - 1; tempX > -1 && tempY > -1; tempX--, tempY--) {
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != queenColor)
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        for (int tempX = x - 1, tempY = y + 1; tempX > -1 && tempY < 8; tempX--, tempY++) {
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != queenColor)
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        return result;
    }

    public char getSymbol() {
        if (this.getColor() == "White")
            return '♕';
        else
            return '♛';
    }
}