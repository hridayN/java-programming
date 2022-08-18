package Multithreading;

public class Multithread {
    public static void main(String[] args) {
        int i = 5;
        for (int j = 0; j < i; j++) {
            MultithreadDemo thread = new MultithreadDemo();
            // start() will invoke run() method of the MultithreadDemo class
            thread.start();
        }
    }
}
