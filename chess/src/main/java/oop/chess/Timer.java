package oop.chess;

public class Timer {
    private int value;
    private long start;

    public Timer() {
        this.value = 0;
    }

    public void start() {
        this.start = System.currentTimeMillis();
    }
    public void stop() {
        this.value += (System.currentTimeMillis() - this.start) / 1000;
    }

    public long getValue() {
        return this.value;
    }

    public String toString() {
        int minutes = value / 60;
        int seconds = value % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
}
