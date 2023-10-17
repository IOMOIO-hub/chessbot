package oop.chess;

import java.util.ArrayList;

class Knight extends Figure {

        public Knight(String color, Coord placement) {
            super(color, placement);
        }
        
        public ArrayList<Coord> possibleTurns(Figure[][] board) {
            ArrayList<Coord> result = new ArrayList<Coord>();
            Coord placement = this.getPlacement();
            int x = placement.getX(), y = placement.getY();
            int[][] knightsTurns = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
            
            for (int i = 0; i < 8; i++){
                int newX = x + knightsTurns[i][0], newY = y + knightsTurns[i][1];
                if ((newX >= 0) && (newX <= 7) && (newY >= 0) && (newY <= 7) && (board[newX][newY] == null)){
                    result.add(new Coord(newX, newY));
                }
            }
            
            return result;
        }

        public char getType(){
            return '♘';
        }

    }
