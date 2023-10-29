package oop.chess;

import java.util.ArrayList;

class Knight extends Figure {

        public Knight(String color, Position position) {
            super(color, position);
        }
        
        public ArrayList<Position> possibleMoves(Board board) {
            ArrayList<Position> result = new ArrayList<Position>();
            Position position = this.getPosition();
            int x = position.getX(), y = position.getY();
            int[][] knightsTurns = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
            
            for (int i = 0; i < 8; i++){
                int newX = x + knightsTurns[i][0], newY = y + knightsTurns[i][1];
                if ((newX >= 0) && (newX <= 7) && (newY >= 0) && (newY <= 7) && ((board.at(newX, newY) == null) || (board.at(newX, newY).getColor() != this.getColor()))) {
                    result.add(new Position(newX, newY));
                }
                
            }
            
            return result;
        }

        public char getSymbol() {
            if (this.getColor() == "White")
                return '♘';
            else
                return '♞';
        }

    }
