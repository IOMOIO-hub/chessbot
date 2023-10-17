package oop.chessbot;

import oop.chess.Game;

public class Session {

    private Long id;
    private Bot bot;

    private String status = "default";
    private Game game;

    public Session(Long id, Bot bot) {
        this.id = id;
        this.bot = bot;
    }

    public Long getId() {
        return this.id;
    }

    public Game getGame() {
        return this.game;
    }

    public String getStatus() {
        return this.status;
    }

    public void send(String message) {
        this.bot.send(this.id, message);
    }
    public void sendBoard() {
        this.bot.send(this.id, this.game.boardToString());
    }

    public void newGame() {
        this.game = new Game();
        this.status = "game";
    }
}
