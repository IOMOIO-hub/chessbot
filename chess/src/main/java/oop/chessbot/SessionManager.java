package oop.chessbot;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {

    static final TelegramBot telegramBot = new TelegramBot();
    // static final ConsoleBot consoleBot = new ConsoleBot();

    private static Map<Long, Session> sessions = new HashMap<Long, Session>();

    private static Session createSession(Long id) {
        Session newSession = new Session(id, SessionManager.telegramBot);
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
