package oop.chessbot;

import java.util.ArrayList;

public class Game {
    
    private Figure[][] board = new Figure[8][8];
    private String status = "figureSelection";

    public Game() {
        loadBoard();
    }

    private void loadBoard() {
        for (int x = 0, y = 1; x < 8; x++)
            board[x][y] = new Pawn("White", new Coord(x, y));

        board[0][0] = new Rook("White", new Coord(0, 0));
        board[1][0] = new Knight("White", new Coord(1, 0));
        board[2][0] = new Bishop("White", new Coord(2, 0));
        board[3][0] = new Queen("White", new Coord(3, 0));
        board[4][0] = new King("White", new Coord(4, 0));
        board[5][0] = new Bishop("White", new Coord(5, 0));
        board[6][0] = new Knight("White", new Coord(6, 0));
        board[7][0] = new Rook("White", new Coord(7, 0));
    }
    
    public String getStatus() {
        return this.status;
    }
    private class Figure {

        private String color;
        private Coord placement;

        public Figure(String color, Coord placement) {
            this.color = color;
            this.placement = placement;
        }

        public Coord getPlacement(){
            return this.placement;
        }

        public String getColor(){
            return this.color;
        }

        public char getType(){
            return '_';
        }
        
        public ArrayList<Coord> possibleTurns() {
            return new ArrayList<Coord>();
        }
    }

    private class Pawn extends Figure {

        public Pawn(String color, Coord placement) {
            super(color, placement);
        }
        
        private boolean notMoved = true;
        
        public ArrayList<Coord> possibleTurns() {
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
    
    private class Knight extends Figure {

        public Knight(String color, Coord placement) {
            super(color, placement);
        }
        
        public ArrayList<Coord> possibleTurns() {
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
    
    private class Bishop extends Figure {

        public Bishop(String color, Coord placement) {
            super(color, placement);
        }

        public ArrayList<Coord> possibleTurns(){
            ArrayList<Coord> result = new ArrayList<Coord>();
            Coord placement = this.getPlacement();
            int x = placement.getX(), y = placement.getY();
            for (int tempX = x + 1, tempY = y + 1; tempX < 8 && tempY < 8; tempX++, tempY++){
                if (board[tempX][tempY] == null){
                    result.add(new Coord(tempX, tempY));
                }
                else{
                    break;
                }
            }

            for (int tempX = x + 1, tempY = y - 1; tempX < 8 && tempY > -1; tempX++, tempY--){
                if (board[tempX][tempY] == null){
                    result.add(new Coord(tempX, tempY));
                }
                else{
                    break;
                }
            }

            for (int tempX = x - 1, tempY = y - 1; tempX > -1 && tempY > -1; tempX--, tempY--){
                if (board[tempX][tempY] == null){
                    result.add(new Coord(tempX, tempY));
                }
                else{
                    break;
                }
            }

            for (int tempX = x - 1, tempY = y + 1; tempX > -1 && tempY < 8; tempX--, tempY++){
                if (board[tempX][tempY] == null){
                    result.add(new Coord(tempX, tempY));
                }
                else{
                    break;
                }
            }

            return result;
        }
        
        public char getType(){
            return '♗';
        }
    }
    
    private class Rook extends Figure {

        public Rook(String color, Coord placement) {
            super(color, placement);
        }

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
            return '♖';
        }
    }
    
    private class Queen extends Figure {

        public Queen(String color, Coord placement) {
            super(color, placement);
        }

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

            for (int tempX = x + 1, tempY = y + 1; tempX < 8 && tempY < 8; tempX++, tempY++){
                if (board[tempX][tempY] == null){
                    result.add(new Coord(tempX, tempY));
                }
                else{
                    break;
                }
            }

            for (int tempX = x + 1, tempY = y - 1; tempX < 8 && tempY > -1; tempX++, tempY--){
                if (board[tempX][tempY] == null){
                    result.add(new Coord(tempX, tempY));
                }
                else{
                    break;
                }
            }

            for (int tempX = x - 1, tempY = y - 1; tempX > -1 && tempY > -1; tempX--, tempY--){
                if (board[tempX][tempY] == null){
                    result.add(new Coord(tempX, tempY));
                }
                else{
                    break;
                }
            }

            for (int tempX = x - 1, tempY = y + 1; tempX > -1 && tempY < 8; tempX--, tempY++){
                if (board[tempX][tempY] == null){
                    result.add(new Coord(tempX, tempY));
                }
                else{
                    break;
                }
            }

            return result;
        }

        public char getType(){
            return '♕';
        }
    }
    
    private class King extends Figure {

        public King(String color, Coord placement) {
            super(color, placement);
        }
        
        public ArrayList<Coord> possibleTurns(){
            ArrayList<Coord> result = new ArrayList<Coord>();
            Coord placement = this.getPlacement();
            int x = placement.getX(), y = placement.getY();
            int[][] kingsTurns = {{1, -1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}};
            
            for (int i = 0; i < 8; i++){
                int newX = x + kingsTurns[i][0], newY = y + kingsTurns[i][1];
                if ((board[newX][newY] == null) && (newX >= 0) && (newX <= 7) && (newY >= 0) && (newY <= 7)){
                    result.add(new Coord(newX, newY));
                }
            }
            
            return result;
        }

        public char getType(){
            return '♔';
        }
    }

    private Figure selectedFigure;

    public ArrayList<Coord> select(Coord placement) {
        int x = placement.getX(), y = placement.getY();
        Figure figure = board[x][y];
        ArrayList<Coord> possibleTurns = figure.possibleTurns();
        
        if (figure == null || possibleTurns.size() == 0)
            return new ArrayList<Coord>();

        selectedFigure = figure;
        status = "movementSelection";
        return possibleTurns;
    }

    public boolean move(Coord direction) {
        ArrayList<Coord> possibleTurns = selectedFigure.possibleTurns();

        for (Coord turn: possibleTurns) {
            if (turn.equals(direction)) {
                int curX = selectedFigure.placement.getX(), curY = selectedFigure.placement.getY();
                int x = direction.getX(), y = direction.getY();

                board[curX][curY] = null;
                board[x][y] = selectedFigure;
                selectedFigure.placement.setX(x);
                selectedFigure.placement.setY(y);

                status = "figureSelection";

                return true;
            }
        }
        return false;
    }

    public String printBoard() {
        String result = "";
        for (int y = 7; y > -1; y--){
            result += ((Integer)(y + 1)).toString() + " ";
            for (int x = 0; x < 8; x++) {
                if (board[x][y] == null)
                    result += "⬚";
                else
                    result += board[x][y].getType();
            }
            result += "\n";
        }
        result += "   a  b  c  d  e  f  g  h";
        return result;
    }
}
