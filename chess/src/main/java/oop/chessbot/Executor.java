package oop.chessbot;

public class Executor {

    private static Executor INSTANCE;
    private Executor() {}

    public static Executor getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Executor();
        }
        return INSTANCE;
    }

    private SessionManager sessionManager = new SessionManager();
    
    public SessionManager getSessionManager() {
        return this.sessionManager;
    }

    public void execute(String command, Long id) {

        Session session = sessionManager.getSession(id);

        if (command.charAt(0) == '/') {
            switch (command) {
                case "/start": {
                    session.send("Привет, добро пожаловать в шахматы!");
                    session.send("Ваш номер сессии: " + id.toString());
                    break;
                }
                case "/help": {
                    session.send("/play - начать новую игру \n/help - список команд");
                    break;
                }
                case "/play": {
                    session.newGame();
                    session.sendBoard();
                    break;
                }
                default: {
                    session.send("Неизвестная команда");
                    break;
                }
            }
        }
        else {
            if (session.getStatus() == "menu") {
                session.send("Неизвестная команда");
                return;
            }

            switch (session.getGame().getStatus()) {
                case "figureSelection": {
                    Message message = session.getGame().select(command);
                    session.send(message);
                    break;
                }
                case "movementSelection": {
                    if (session.getGame().move(command)) {
                        session.sendBoard();
                        session.sendTimers();
                    }
                    else {
                        session.send("Ход невозможен");
                    }
                    break;
                }
            }
        }
    }
}
