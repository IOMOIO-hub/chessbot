package oop.chessbot;

public class Session {
    private String status;
    private Game game;

    public Session() {
        this.status = "default";
    }

    public Game getGame() {
        return this.game;
    }

    public String getStatus() {
        return this.status;
    }

    public void newGame() {
        this.game = new Game();
        this.status = "inGame";
    }
}
