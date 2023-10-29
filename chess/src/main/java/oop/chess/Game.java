package oop.chess;

import java.util.ArrayList;
import oop.chessbot.Message;

public class Game {
    
    private Board board = new Board();
    private String status;
    private Player currentPlayer;
    private Player firstPlayer = new Player("White");
    private Player secondPlayer = new Player("Black");

    public Game() {
        status = "figureSelection";
        currentPlayer = firstPlayer;
    }

    public Board getBoard() {
        return this.board;
    }

    public String getStatus() {
        return this.status;
    }

    private void changePlayer(){
        if (currentPlayer.equals(firstPlayer))
            currentPlayer = secondPlayer;
        else
            currentPlayer = firstPlayer;
    }

    private Figure selectedFigure;

    public ArrayList<Position> select(Position position) {
        Figure figure = board.at(position);

        ArrayList<Position> possibleMoves = figure.possibleMoves(board);
        
        if (figure == null || possibleMoves.size() == 0 || figure.getColor() != currentPlayer.getColor())
            return null;

        this.selectedFigure = figure;
        this.status = "movementSelection";

        return possibleMoves;
    }
    public Message select(String str) {
        ArrayList<Position> possibleMoves = select(new Position(str));
        if (possibleMoves == null) {
            return new Message("Вы не можете ходить этой фигурой");
        }
        ArrayList<String> keyboard = new ArrayList<String>();
        for (Position move: possibleMoves)
            keyboard.add(move.toString());

        return new Message("Выберите ход", keyboard);
    }

    public boolean move(Position destination) {
        ArrayList<Position> possibleMoves = selectedFigure.possibleMoves(board);

        for (Position move: possibleMoves) {
            if (move.equals(destination)) {
                board.set(selectedFigure.getPosition(), null);
                board.set(destination, selectedFigure);
                selectedFigure.setPosition(destination);
                
                status = "figureSelection";
                changePlayer();
                return true;
            }
        }
        return false;
    }
    public boolean move(String str) {
        return move(new Position(str));
    }
}
