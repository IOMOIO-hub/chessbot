package oop.chess;

import java.util.ArrayList;

class Pawn extends Figure {

        public Pawn(String color, Coord placement) {
            super(color, placement);
        }
        
        private boolean notMoved = true;
        
        public ArrayList<Coord> possibleTurns(Figure[][] board) {
            ArrayList<Coord> result = new ArrayList<Coord>();
            Coord placement = this.getPlacement();
            int x = placement.getX(), y = placement.getY();

            //white figures are placed at the the bottom and black at the top
            if (this.getColor() == "White"){
                if ((y <= 7) && (board[x][y + 1] == null)){
                    
                    result.add(new Coord(x, y + 1));

                    if (notMoved && (board[x][y + 2] == null)){
                        result.add(new Coord(x, y + 2));
                    }
                }
            }
            else if ((y >= 2) && (board[x][y - 1] == null)) {
                result.add(new Coord(x, y - 1));

                if (notMoved && (board[x][y - 2] == null)){
                    result.add(new Coord(x, y - 2));
                }
            }

            return result;
        }
        public char getType(){
           return '♙';
        }
    }