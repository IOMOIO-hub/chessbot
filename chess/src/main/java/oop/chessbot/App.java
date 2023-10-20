package oop.chessbot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App {
    public static void main(String[] args) throws TelegramApiException{

        SessionManager manager = new SessionManager();

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(SessionManager.telegramBot);

        // createSession(0L, App.consoleBot);
        // App.consoleBot.listen();
    }
}
