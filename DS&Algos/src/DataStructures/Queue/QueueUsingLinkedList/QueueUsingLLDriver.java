package DataStructures.Queue.QueueUsingLinkedList;

public class QueueUsingLLDriver {
    public static void main(String[] args) {
        QueueUsingLL<Integer> queue = new QueueUsingLL<>();
        System.out.println(String.format("Size: %d", queue.Size()));

        queue.Enqueue(10);
        System.out.println(String.format("Size: %d", queue.Size()));

        queue.Enqueue(20);
        System.out.println(String.format("Size: %d", queue.Size()));

        queue.Enqueue(30);
        System.out.println(String.format("Size: %d", queue.Size()));

        queue.Dequeue();
        System.out.println(String.format("Size: %d", queue.Size()));

        queue.Enqueue(40);
        queue.PrintQueue();
    }
}
