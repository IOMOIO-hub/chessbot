package oop.chess;

import java.util.ArrayList;

public class Game {
    
    private Board board = new Board();
    private String status = "figureSelection";

    public Game() {

    }

    public Board getBoard() {
        return this.board;
    }
    
    public String getStatus() {
        return this.status;
    }

    private Figure selectedFigure;

    public ArrayList<Position> select(Position position) {
        Figure figure = board.at(position);
        ArrayList<Position> possibleMoves = figure.possibleMoves(board);
        
        if (figure == null || possibleMoves.size() == 0)
            return new ArrayList<Position>();

        this.selectedFigure = figure;
        this.status = "movementSelection";

        return possibleMoves;
    }
    public String select(String str) {
        ArrayList<Position> possibleMoves = select(new Position(str));
        if (possibleMoves.size() == 0) {
            return "Вы не можете ходить этой фигурой";
        }
        String message = "Возможные ходы: ";
        for (Position move: possibleMoves)
            message += move.toString();
            
        return message;
    }

    public boolean move(Position destination) {
        ArrayList<Position> possibleMoves = selectedFigure.possibleMoves(board);

        for (Position move: possibleMoves) {
            if (move.equals(destination)) {
                board.set(selectedFigure.getPosition(), null);
                board.set(destination, selectedFigure);
                selectedFigure.setPosition(destination);

                status = "figureSelection";
                return true;
            }
        }
        return false;
    }
    public boolean move(String str) {
        return move(new Position(str));
    }
}
