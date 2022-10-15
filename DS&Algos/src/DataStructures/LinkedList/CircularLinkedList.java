package DataStructures.LinkedList;

public class CircularLinkedList {
    private ListNode tail;
    private int length;

    public CircularLinkedList() {
        this.tail = null;
        this.length = 0;
    }

    public boolean IsEmpty() {
        return this.length == 0;
    }

    public static class ListNode {
        private int data;
        private ListNode tail;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
            this.tail = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        ListNode list = circularLinkedList.CreateCircularLinkedList();
        DisplayCircularLinkedList(list);
        list = circularLinkedList.InsertNodeAtBeginning(list, 60);
        DisplayCircularLinkedList(list);
        list = circularLinkedList.InsertNodeAtEnd(list, 70);
        DisplayCircularLinkedList(list);
        list = circularLinkedList.DeleteFirstNode(list);
        DisplayCircularLinkedList(list);
    }

    public static void DisplayCircularLinkedList(ListNode tail) {
        if (tail == null) return;

        ListNode first = tail.next;
        while (first != tail) {
            System.out.print(String.format("%d --> ", first.data));
            first = first.next;
        }
        System.out.print(String.format("%d ", first.data));
        System.out.println();
    }

    public ListNode CreateCircularLinkedList() {
        ListNode first = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);
        ListNode tail = new ListNode(50);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = tail;
        tail.next = first;

        return tail;
    }

    public int GetLength(ListNode tail) {
        int length = 0;
        if (tail == null) return 0;

        ListNode first = tail.next;
        while (first != tail) {
            length++;
            first = first.next;
        }
        length++;
        return length;
    }
    public ListNode InsertNodeAtBeginning(ListNode tail, int data) {
        ListNode newNode = new ListNode(data);
        // Check if list is empty
        if (GetLength(tail) == 0) {
            tail = newNode;
            tail.next = tail;
            return tail;
        }

        newNode.next = tail.next;
        tail.next = newNode;
        return tail;
    }

    public ListNode InsertNodeAtEnd(ListNode tail, int data) {
        ListNode newNode = new ListNode(data);
        // Check if list is empty
        if (GetLength(tail) == 0) {
            tail = newNode;
            tail.next = tail;
            return tail;
        }

        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
        return tail;
    }

    public ListNode DeleteFirstNode(ListNode tail) {
        ListNode first = tail.next;
        int length = GetLength(tail);
        if (length == 0 || length == 1) {
            tail = null;
            return null;
        }
        else {
            tail.next = tail.next.next;
            first.next = null;
        }
        return tail;
    }
}
