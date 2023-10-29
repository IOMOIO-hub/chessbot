package oop.chess;

public class Board {

    private Figure[][] board;

    public Board() {
        reset();
    }

    public void reset() {
        board = new Figure[8][8];

        for (int x = 0, y = 1; x < 8; x++)
            board[x][y] = new Pawn("White", new Position(x, y));

        board[0][0] = new Rook("White", new Position(0, 0));
        board[1][0] = new Knight("White", new Position(1, 0));
        board[2][0] = new Bishop("White", new Position(2, 0));
        board[3][0] = new Queen("White", new Position(3, 0));
        board[4][0] = new King("White", new Position(4, 0));
        board[5][0] = new Bishop("White", new Position(5, 0));
        board[6][0] = new Knight("White", new Position(6, 0));
        board[7][0] = new Rook("White", new Position(7, 0));

        for (int x = 0, y = 6; x < 8; x++)
            board[x][y] = new Pawn("Black", new Position(x, y));
        
        board[0][7] = new Rook("Black", new Position(0, 0));
        board[1][7] = new Knight("Black", new Position(1, 7));
        board[2][7] = new Bishop("Black", new Position(2, 7));
        board[3][7] = new Queen("Black", new Position(3, 7));
        board[4][7] = new King("Black", new Position(4, 7));
        board[5][7] = new Bishop("Black", new Position(5, 7));
        board[6][7] = new Knight("Black", new Position(6, 7));
        board[7][7] = new Rook("Black", new Position(7, 7));
    }

    public Figure at(Position position) {
        int x = position.getX();
        int y = position.getY();

        return board[x][y];
    }
    public Figure at(int x, int y) {
        return board[x][y];
    }

    public void set(Position position, Figure figure) {
        int x = position.getX();
        int y = position.getY();

        board[x][y] = figure;
    }
    public void set(int x, int y, Figure figure) {
        board[x][y] = figure;
    }

    public String toString() {
        String result = "";
        for (int y = 7; y > -1; y--) {
            result += ((Integer)(y + 1)).toString() + "  ";
            for (int x = 0; x < 8; x++) {
                Figure currentFigure = board[x][y];
                if (currentFigure == null)
                    result += "⬚";
                else
                    result += currentFigure.getSymbol();
            }
            result += "\n";
        }
        result += "    a  b  c  d  e  f  g  h";
        return result;
    }
}
