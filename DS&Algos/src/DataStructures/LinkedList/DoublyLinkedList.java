package DataStructures.LinkedList;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    public boolean IsEmpty() {
        return this.length == 0;
    }
    public static class ListNode {
        private int data;
        private ListNode previous;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        /*ListNode head = new ListNode(10), second = new ListNode(20), third = new ListNode(30), fourth = new ListNode(40);
        head.previous = null;
        head.next = second;
        second.previous = head;
        second.next = third;
        third.previous = second;
        third.next = fourth;
        fourth.previous = third;
        fourth.next = null;
        DisplayDoublyLinkedList(head);
        System.out.println(String.format("Current lengeth: %d", GetLength(head)));*/

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        DisplayDoublyLinkedList(doublyLinkedList.InsertNodeAtBeginning(10));
        DisplayDoublyLinkedList(doublyLinkedList.InsertNodeAtBeginning(20));
        DisplayDoublyLinkedList(doublyLinkedList.InsertNodeAtEnd(30));
        doublyLinkedList.DeleteFirstNode();
        /*doublyLinkedList.DeleteFirstNode();
        doublyLinkedList.DeleteFirstNode();
        doublyLinkedList.DeleteFirstNode();*/
        DisplayDoublyLinkedList(doublyLinkedList.head);
        doublyLinkedList.DeleteLastNode();
        DisplayDoublyLinkedList(doublyLinkedList.head);
    }

    public ListNode InsertNodeAtBeginning(int value) {
        ListNode temp = head, newNode = new ListNode(value);
        if (IsEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
        System.out.println(String.format("%d inserted", value));
        return head;
    }

    public ListNode InsertNodeAtEnd(int value) {
        ListNode temp = tail, newNode = new ListNode(value);
        if (IsEmpty()) {
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        length++;
        System.out.println(String.format("%d inserted", value));
        return head;
    }

    public void DeleteFirstNode() {
        if (IsEmpty()) {
            System.out.println("List is already empty");
        } else {
            int deletedValue = head.data;
            head = head.next;
            if (head != null)  head.previous = null;
            length--;
            System.out.println(String.format("%d deleted", deletedValue));
        }
    }

    public void DeleteLastNode() {
        if (IsEmpty()) {
            System.out.println("List is already empty");
        } else {
            int deletedValue = tail.data;
            tail = tail.previous;
            tail.next = null;
            length--;
            System.out.println(String.format("%d deleted", deletedValue));
        }
    }

    public static void DisplayDoublyLinkedList(ListNode node) {
        while (node != null) {
            System.out.print(String.format("%d", node.data));
            if (node.next != null) System.out.print(" --> ");
            node = node.next;
        }
        System.out.println();
    }

    public static int GetLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
