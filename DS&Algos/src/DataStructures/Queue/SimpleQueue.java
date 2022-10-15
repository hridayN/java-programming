package DataStructures.Queue;

/*
* Queue: FIFO
* Insertions are done at REAR end
* Deletions are done at FRONT end */
public class SimpleQueue {
    private ListNode front;
    private ListNode rear;
    private int length;

    public SimpleQueue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public static class ListNode {
        int data;
        ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SimpleQueue queue = new SimpleQueue();
        //System.out.println(String.format("Is Queue empty: %b", queue.isEmpty()));
        queue.front = queue.CreateSampleQueue();
        queue.DisplayQueue(queue.front);
        //System.out.println(String.format("Is Queue empty: %b", queue.isEmpty()));
        queue.Enqueue(50);
        queue.DisplayQueue(queue.front);
        queue.Dequeue();
        queue.DisplayQueue(queue.front);
    }

    public ListNode CreateSampleQueue() {
        // 1st node entered at REAR
        rear = new ListNode(10);
        front = rear;
        length++;

        // 2nd node entered
        ListNode secondNode = new ListNode(20);
        rear.next = secondNode;
        rear = secondNode;
        length++;

        // 3rd node entered
        ListNode thirdNode = new ListNode(30);
        rear.next = thirdNode;
        rear = thirdNode;
        length++;

        // 4th node entered
        ListNode fourthNode = new ListNode(40);
        rear.next = fourthNode;
        rear = fourthNode;
        length++;

        return front;
    }

    public void Dequeue() {
        if (length == 0) {
            System.out.println("Queue is empty already");
        } else {
            if (length > 1) {
                ListNode temp = front;
                front = front.next;
                temp = null;
                length--;
            } else if (length == 1) {
                front = rear = null;
                length = 0;
            }
        }
    }

    public void Enqueue(int value) {
        ListNode newNode = new ListNode(value);
        rear.next = newNode;
        rear = newNode;
    }

    public boolean isEmpty() {
        return length == 0;
    }
    public void DisplayQueue(ListNode front) {
        ListNode temp = front;
        while (temp != null) {
            System.out.print(String.format("%d", temp.data));
            if (temp.next != null) System.out.print(" --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int GetLength() {
        return length;
    }
}
