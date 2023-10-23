package oop.chessbot;

import java.util.Scanner;

public class ConsoleBot implements Bot{

    public void listen() {
        
        Executor executor = Executor.getInstance();
        executor.execute("/start", 0L);

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                String message = input.nextLine();
                executor.execute(message, 0L);
            }
        }
    }
    public void send(Long id, Message message) {
        System.out.println(message.text);
    }
}
