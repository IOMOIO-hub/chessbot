package oop.chessbot;

import java.util.HashMap;
import java.util.Map;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App {
    public static void main(String[] args) throws TelegramApiException{

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(App.telegramBot);

        createSession(0L, App.consoleBot);
        App.consoleBot.listen();
    }

    private static final TelegramBot telegramBot = new TelegramBot();
    private static final ConsoleBot consoleBot = new ConsoleBot();

    private static Map<Long, Session> sessions = new HashMap<Long, Session>();

    private static Session createSession(Long id) {
        Session newSession = new Session(id, App.telegramBot);
        sessions.put(id, newSession);
        return newSession;
    }
    public static Session createSession(Long id, Bot bot) {
        Session newSession = new Session(id, bot);
        sessions.put(id, newSession);
        return newSession;
    }

    public static Session getSession(Long id) {
        Session session = sessions.get(id);
        if (session == null) {
            session = createSession(id);
        }
        return session;
    }
}
