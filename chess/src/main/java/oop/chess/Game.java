package oop.chess;

import java.util.ArrayList;
import java.util.Random;

import oop.chessbot.Message;

public class Game {
    
    private Board board = new Board();
    private Player currentPlayer, firstPlayer, secondPlayer;
    private String mode, status;

    public Game() {
        this.mode = "randomComputer";
        reset();
    }
    public Game(String mode) {
        this.mode = mode;
        reset();
    }
    private void reset() {
        this.firstPlayer = new Player("White");
        this.secondPlayer = new Player("Black");
        this.currentPlayer = this.firstPlayer;
        this.status = "figureSelection";
        currentPlayer.getTimer().start();
    }

    public Board getBoard() {
        return this.board;
    }
    public String getStatus() {
        return this.status;
    }
    public String getTimers() {
        return "Игрок: " + firstPlayer.getTimer().toString() + "  Компьютер: " + secondPlayer.getTimer().toString();
    }

    private void changePlayer() {
        currentPlayer.getTimer().stop();
        currentPlayer = currentPlayer.equals(firstPlayer) ? secondPlayer : firstPlayer;
        currentPlayer.getTimer().start();
    }

    private Figure selectedFigure;

    public ArrayList<Position> select(Position position) {
        Figure figure = board.at(position);

        if (figure == null || figure.getColor() != currentPlayer.getColor())
            return null;

        ArrayList<Position> possibleMoves = figure.possibleMoves(board);

        if (possibleMoves.size() == 0)
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
                if (this.mode == "randomComputer" && currentPlayer.getColor() == "Black") {
                    makeRandomMove();
                }

                return true;
            }
        }
        return false;
    }
    public boolean move(String str) {
        return move(new Position(str));
    }

    private void makeRandomMove() {

        ArrayList<Figure> possibleFigures = new ArrayList<Figure>();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Figure currentFigure = board.at(x, y);
                if (currentFigure != null && currentFigure.getColor() == currentPlayer.getColor() && currentFigure.isSelectable(board)) {
                    possibleFigures.add(currentFigure);
                }
            }
        }

        Random random = new Random();
        int index = random.nextInt(possibleFigures.size());
        Figure randomFigure = possibleFigures.get(index);
        
        ArrayList<Position> possibleMoves = select(randomFigure.getPosition());
        index = random.nextInt(possibleMoves.size());

        move(possibleMoves.get(index));
    }
}
