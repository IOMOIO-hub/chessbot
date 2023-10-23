package oop.chessbot;

import java.util.ArrayList;

public class Message {

    private String text;
    private ArrayList<String> keyboard;

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

    public String getText() {
        return this.text;
    }
    public ArrayList<String> getKeyboard() {
        return this.keyboard;
    }

    public void setText(String text) {
        this.text = text;
    }
    public void setKeyboard(ArrayList<String> keyboard) {
        this.keyboard = keyboard;
    }
}
