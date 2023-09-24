package oop.chessbot;

public class Session {
    public String status;
    public Game game;

    public Session() {
        this.status = "default";
    }

    public void newGame() {
        this.game = new Game();
        this.status = "inGame";
    }
}
