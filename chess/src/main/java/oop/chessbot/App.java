package oop.chessbot;

public class App {
    public static void main(String[] args) {
        Bot bot = Bot.getInstance();

        Chat chat = bot.createChat("@im_iomoio");
        chat.listen();
    }
}
