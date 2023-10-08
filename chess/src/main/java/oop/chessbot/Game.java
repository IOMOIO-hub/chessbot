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
        public char getType(){
           return 'p';
        }
    }
    
    private class Knight extends Figure{
        
        public ArrayList<Coord> possibleTurns(){
            ArrayList<Coord> result = new ArrayList<Coord>();
            Coord placement = this.getPlacement();
            int x = placement.getX(), y = placement.getY();
            int[][] knightsTurns = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
            
            for (int i = 0; i < 8; i++){
                int newX = x + knightsTurns[i][0], newY = y + knightsTurns[i][1];
                if ((board[newX][newY] == null) && (newX >= 0) && (newX <= 7) && (newY >= 0) && (newY <= 7)){
                    result.add(new Coord(newX, newY));
                }
            }
            
            return result;
        }

        public char getType(){
                return 'k';
        }

    }
    
    private class Bishop extends Figure{
        public ArrayList<Coord> possibleTurns(){
            ArrayList<Coord> result = new ArrayList<Coord>();
            Coord placement = this.getPlacement();
            int x = placement.getX(), y = placement.getY();
            for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++){
                if (board[i][j] == null){
                    result.add(new Coord(i, j));
                }
                else{
                    break;
                }
            }

            for (int i = x + 1, j = y - 1; i < 8 && j > -1; i++, j--){
                if (board[i][j] == null){
                    result.add(new Coord(i, j));
                }
                else{
                    break;
                }
            }

            for (int i = x - 1, j = y - 1; i > -1 && j > -1; i--, j--){
                if (board[i][j] == null){
                    result.add(new Coord(i, j));
                }
                else{
                    break;
                }
            }

            for (int i = x - 1, j = y + 1; i > -1 && j < 8; i--, j++){
                if (board[i][j] == null){
                    result.add(new Coord(i, j));
                }
                else{
                    break;
                }
            }

            return result;
        }
        
        public char getType(){
            return 'b';
        }
    }
    
    private class Rook extends Figure{
        public ArrayList<Coord> possibleTurns(){
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
            return 'r';
        }
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
