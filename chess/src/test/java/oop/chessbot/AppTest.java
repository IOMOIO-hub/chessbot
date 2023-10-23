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

        Executor executor = Executor.getInstance();
        executor.getSessionManager().createSession(0L, new ConsoleBot());

        executor.execute("/help", 0L);
        assertEquals("/play - начать новую игру \n/help - список команд\r\n", outContent.toString());

        System.setOut(originalOut);
    }
}
