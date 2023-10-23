package oop.chess;

import java.util.ArrayList;

class Pawn extends Figure {

        public Pawn(String color, Position position) {
            super(color, position);
        }
        
        public ArrayList<Position> possibleMoves(Board board) {
            ArrayList<Position> result = new ArrayList<Position>();
            Position position = this.getPosition();
            int x = position.getX(), y = position.getY();

            //white figures are placed at the the bottom and black at the top
            if (this.getColor() == "White"){
                if ((y <= 7) && (board.at(x, y + 1) == null)) {
                    
                    result.add(new Position(x, y + 1));

                    if (y == 1 && (board.at(x, y + 2) == null)) {
                        result.add(new Position(x, y + 2));
                    }
                }
            }
            else if ((y >= 2) && (board.at(x, y - 1) == null)) {
                result.add(new Position(x, y - 1));

                if (y == 6 && (board.at(x, y - 2) == null)) {
                    result.add(new Position(x, y - 2));
                }
            }

            return result;
        }
        public char getType() {
           return '♙';
        }
    }