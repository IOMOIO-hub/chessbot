package oop.chess;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {
    @Test
    public void kingTurnsTest() {
        
        ArrayList<String> kingFirstTurns = new ArrayList<String>();
        kingFirstTurns.add("f1");
        kingFirstTurns.add("e2");

        ArrayList<String> kingSecondTurns = new ArrayList<String>();
        kingSecondTurns.add("e1");
        kingSecondTurns.add("e2");
        
        Game game = new Game("randomComputer");
        
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

    @Test
    public void selectOpponentsFigureTest() {
        
        Game game = new Game("againstYourself");
        assertEquals("Вы не можете ходить этой фигурой", game.select("a7").getText());
    }

    @Test
    public void killOpponentsFigureTest() {
        
        Game game = new Game("againstYourself");

        game.select("e2");
        game.move("e4");
        game.select("d7");
        game.move("d5");
        
        game.select("e4");
        assertTrue(game.move("d5"));
    }
}
