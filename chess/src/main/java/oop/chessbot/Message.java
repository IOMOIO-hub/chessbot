package oop.chessbot;

import java.util.ArrayList;

public class Message {
    public String text;
    public ArrayList<String> keyboard;

    public Message(String text, ArrayList<String> keyboard) {
        this.text = text;
        this.keyboard = keyboard;
    }
    public Message(String text) {
        this.text = text;
        this.keyboard = null;
    }
    public Message(ArrayList<String> keyboard) {
        this.text = null;
        this.keyboard = keyboard;
    }
}
