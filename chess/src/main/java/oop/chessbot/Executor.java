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

    public void execute(String command, Long id) {

        Session session = App.getSession(id);

        if (session.getStatus() == "game" && command.charAt(0) != '/') {
            switch (session.getGame().getStatus()) {
                case "figureSelection": {
                    String message = session.getGame().select(command);
                    session.send(message);
                    break;
                }
                case "movementSelection": {
                    if (session.getGame().move(command)) {
                        session.sendBoard();
                    }
                    else {
                        session.send("Ход невозможен");
                    }
                    break;
                }
            }

            return;
        }

        switch (command) {
            case "/start": {
                session.send("Привет, Добро пожаловать в шахматы!");
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
}
