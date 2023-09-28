package oop.chessbot;

import java.util.HashMap;
import java.util.Map;

public class Bot {

    private static Bot INSTANCE;
    private Bot() {}

    public static Bot getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Bot();
        }
        return INSTANCE;
    }

    private Map<String, Chat> chats = new HashMap<String, Chat>();

    public Chat createChat(String username) {
        Chat newChat = new ConsoleChat(username);
        chats.put(username, newChat);
        return newChat;
    }

    public void execute(String command, String username) {

        Chat chat = chats.get(username);
        if (chat == null) return;

        Session session = chat.getSession();

        if (session.getStatus() == "inGame" && command.charAt(0) != '/') {
            // String message = session.getGame().move(command);
            String message = "Вы сделали ход";
            chat.say(message);
            return;
        }

        switch (command) {
            case "/greet": {
                chat.say("Привет, " + username + "! Добро пожаловать в шахматы!");
                break;
            }
            case "/help": {
                chat.say("/play - начать новую игру \n/help - список команд");
                break;
            }
            case "/play": {
                session.newGame();

                chat.say("Игра началась");
                break;
            }
            default: {
                chat.say("Неизвестная команда");
                break;
            }
        }
    }
}
