package oop.chessbot;
import java.util.ArrayList;

public class Game {
    
    private String status = "figureSelection";
    
    private class Figure{

        private String color;
        private Coord placement = new Coord();

        public Coord getPlacement(){
            return this.placement;
        }

        public String getColor(){
            return this.color;
        }

        public char getType(){
            return '_';
        }
        
        public ArrayList<Coord> possibleTurns(){
            return new ArrayList<Coord>();
        }

        public void move(){

        }
    }

    Figure[][] board = new Figure[8][8];

    private class Pawn extends Figure{
        
        private boolean notMoved = true;
        
        public ArrayList<Coord> possibleTurns(){
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
            else{

                if ((y >= 2) && (board[x][y - 1] == null)){
                    result.add(new Coord(x, y - 1));

                    if (notMoved && (board[x][y - 2] == null)){
                        result.add(new Coord(x, y - 2));

                    }
                }
            }

            return result;
        }
        public char getType()
        {
           return 'p';
        }
    }
    
    private class Knight extends Figure{
        
    }
    
    private class Bishop extends Figure{

    }
    
    private class Rook extends Figure{

    }
    
    private class Queen extends Figure{

    }
    
    private class King extends Figure{

    }

    private Figure selectedFigure;

    public ArrayList<Coord> select(Coord placement){
        int x = placement.getX(), y = placement.getY();
        Figure figure = board[x][y];
        ArrayList<Coord> possibleTurns = figure.possibleTurns();
        if (figure == null)
            return null;
        selectedFigure = figure;
        if (possibleTurns.size() != 0)
            status = "movementSelection";
        return figure.possibleTurns();
        
    }
    public boolean move(Coord direction){
        ArrayList<Coord> possibleTurns = selectedFigure.possibleTurns();
        if (possibleTurns.contains(direction)){
            int curX = selectedFigure.placement.getX(), curY = selectedFigure.placement.getY();
            int x = direction.getX(), y = direction.getY();

            board[curX][curY] = null;
            board[x][y] = selectedFigure;
            selectedFigure.placement.setX(x);
            selectedFigure.placement.setY(y);

            return true;
        }
        return false;
    }

    public String printBoard(){
        String result = " ABCDEFGH \n";
        for (int i = 7; i > -1; i--){
            result += ((Integer)(i + 1)).toString();
            for (int j = 0; j < 8; j++){
                result += board[i][j].getType();
            }
            result += ((Integer)(i + 1)).toString();
            result += "\n";
        }
        result += " ABCDEFGH";
        return result;
    }
}
