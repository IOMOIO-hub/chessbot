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
        String bishopColor = this.getColor();

        for (int tempX = x + 1, tempY = y + 1; tempX < 8 && tempY < 8; tempX++, tempY++) {
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != bishopColor)
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        for (int tempX = x + 1, tempY = y - 1; tempX < 8 && tempY > -1; tempX++, tempY--) {
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != bishopColor)
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        for (int tempX = x - 1, tempY = y - 1; tempX > -1 && tempY > -1; tempX--, tempY--) {
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != bishopColor)
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        for (int tempX = x - 1, tempY = y + 1; tempX > -1 && tempY < 8; tempX--, tempY++){
            if (board.at(tempX, tempY) == null) {
                result.add(new Position(tempX, tempY));
            }
            else{
                if (board.at(tempX, tempY).getColor() != bishopColor)
                    result.add(new Position(tempX, tempY));
                break;
            }
        }

        return result;
    }

    public String getSymbol() {
        switch (this.getColor()) {
            case "White":
                return "♗";
            case "Black":
                return "♝";
            default:
                return "�";
        }
    }
}