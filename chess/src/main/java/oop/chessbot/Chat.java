package oop.chessbot;

public interface Chat {
    
    public Session getSession();
    
    public void listen();
    public void say(String message);
}
