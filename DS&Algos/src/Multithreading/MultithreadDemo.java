package Multithreading;

public class MultithreadDemo extends Thread {
    public void run() {
        try {
            System.out.println("Thread Id: " + Thread.currentThread().getId() + ", Name: " + Thread.currentThread().getName() + " is running");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
