package oop.chessbot;

import java.util.Scanner;

public class ConsoleBot implements Bot{

    private Long id = 0L;

    public ConsoleBot() {
    }

    public void listen() {
        Executor executor = Executor.getInstance();

        executor.execute("/start", this.id);

        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                String message = input.nextLine();
                executor.execute(message, this.id);
            }
        }
    }
    public void send(Long id, String message) {
        System.out.println(message);
    }
}
