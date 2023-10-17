package oop.chess;

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

    private Figure selectedFigure;

    public ArrayList<Coord> select(Coord placement) {
        int x = placement.getX(), y = placement.getY();
        Figure figure = board[x][y];
        ArrayList<Coord> possibleTurns = figure.possibleTurns(board);
        
        if (figure == null || possibleTurns.size() == 0)
            return new ArrayList<Coord>();

        selectedFigure = figure;
        status = "movementSelection";
        return possibleTurns;
    }
    public ArrayList<Coord> select(String str) {
        return select(new Coord(str));
    }

    public boolean move(Coord direction) {
        ArrayList<Coord> possibleTurns = selectedFigure.possibleTurns(board);
        Coord placement = selectedFigure.getPlacement();

        for (Coord turn: possibleTurns) {
            if (turn.equals(direction)) {
                int curX = placement.getX(), curY = placement.getY();
                int x = direction.getX(), y = direction.getY();

                board[curX][curY] = null;
                board[x][y] = selectedFigure;
                placement.setX(x);
                placement.setY(y);

                status = "figureSelection";

                return true;
            }
        }
        return false;
    }
    public boolean move(String str) {
        return move(new Coord(str));
    }

    public String boardToString() {
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
