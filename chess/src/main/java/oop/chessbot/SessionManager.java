package oop.chessbot;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {

    public static final TelegramBot telegramBot = new TelegramBot();
    public static final ConsoleBot consoleBot = new ConsoleBot();

    private Map<Long, Session> sessions = new HashMap<Long, Session>();

    public Session createSession(Long id, Bot bot) {
        Session newSession = new Session(id, bot);
        sessions.put(id, newSession);
        return newSession;
    }

    public Session getSession(Long id) {
        Session session = sessions.get(id);
        if (session == null) {
            session = createSession(id, telegramBot);
        }
        return session;
    }
}
