package oop.chessbot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest {
    @Test
    public void helpCommandTest() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;

        System.setOut(new PrintStream(outContent));

        SessionManager manager = new SessionManager();
        SessionManager.createSession(0L, new ConsoleBot());

        Executor executor = Executor.getInstance();
        executor.execute("/help", 0L);

        System.setOut(originalOut);
        
        assertEquals("/play - начать новую игру \n/help - список команд\r\n", outContent.toString());
    }
}
