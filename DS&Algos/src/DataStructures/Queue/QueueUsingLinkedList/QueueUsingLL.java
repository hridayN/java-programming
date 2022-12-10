package DataStructures.Queue.QueueUsingLinkedList;

import DataStructures.LinkedList.ListNode;

/* LIFO: Last In First Out,
 * New element is added at Rear
 * An element is removed from Front*/
public class QueueUsingLL<T> {
    private ListNode<T> front;
    private ListNode<T> rear;
    private int size;

    // Constructor
    public QueueUsingLL() {
        // Need not declare constructor like this, as non-primitives have null by default
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Method to return the size of the Queue
    public int Size() {
        return this.size;
    }

    // Method to check if queue is empty or not
    public boolean IsEmpty() {
        return (this.size == 0);
    }


    public void Enqueue(T data) {
        // Create a node with given data
        ListNode<T> node = new ListNode<>(data);

        // If queue is Empty, make front point to node itself
        if (size == 0) {
            this.front = node;
            this.rear = node;
        } else {
            // If queue isn't empty, add node at the rear
            rear.next = node;
            rear = node;
            node.next = null;
        }

        this.size++;
    }

    public ListNode<T> Dequeue() {
        if (this.size == 0) {
            // handle with exception
            return null;
        }
        ListNode<T> current = front;
        front = front.next;

        this.size--;
        return current;
    }

    public T front() {
        return front.data;
    }

    public T rear() {
        return rear.data;
    }

    public void PrintQueue() {
        ListNode<T> currentNode = this.front;
        System.out.print("[ ");
        while(currentNode != null) {
            String last = (currentNode.next == null) ? "]" : "->";
            System.out.print(String.format(" %d %s ", currentNode.data, last));
            currentNode = currentNode.next;
        }
    }
}
