package oop.chessbot;

import java.util.Scanner;

public class ConsoleChat implements Chat {

    private String username;
    private Session session;

    public ConsoleChat(String username) {
        this.username = username;
        this.session = new Session();
    }

    public Session getSession() {
        return this.session;
    }

    public void listen() {
        Bot bot = Bot.getInstance();

        bot.execute("/greet", username);

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                String message = input.nextLine();
                bot.execute(message, username);
            }
        }
    }
    public void say(String message) {
        System.out.println(message);
    }
}
