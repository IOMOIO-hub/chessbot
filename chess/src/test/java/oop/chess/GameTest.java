package oop.chess;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void kingTurnsTest() {
        
        ArrayList<String> kingFirstTurns = new ArrayList<String>();
        kingFirstTurns.add("f1");
        kingFirstTurns.add("e2");

        ArrayList<String> kingSecondTurns = new ArrayList<String>();
        kingSecondTurns.add("e1");
        kingSecondTurns.add("e2");
        
        Game game = new Game();
        
        game.select("e2");
        game.move("e4");
        game.select("f1");
        game.move("d3");
        
        ArrayList<String> kingTurns = game.select("e1").getKeyboard();
        assertEquals(kingFirstTurns, kingTurns);
        
        game.move("f1");
        kingTurns = game.select("f1").getKeyboard();
        assertEquals(kingSecondTurns, kingTurns);
    }
}
