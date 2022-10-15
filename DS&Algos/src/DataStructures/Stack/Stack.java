package DataStructures.Stack;

import java.util.EmptyStackException;

public class Stack {
    private ListNode top;
    private int length;

    public Stack() {
        this.top = null;
        this.length = 0;
    }

    public class ListNode<T> {
        private T data;
        private ListNode next;
        public ListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean IsEmpty() {
        return length == 0;
    }

    public static void main(String[] args) {
        Stack stackObj = new Stack();
        stackObj.displayStack();
        stackObj = stackObj.createStack();
        stackObj.displayStack();
        stackObj.push(50);
        stackObj.displayStack();
        stackObj.pop();
        stackObj.displayStack();
    }

    public Stack createStack() {
        Stack stack = new Stack();

        ListNode top, first = new ListNode(10);
        top = first;

        ListNode second = new ListNode(20);
        second.next = first;
        top = second;

        ListNode third = new ListNode(30);
        third.next = second;
        top = third;

        ListNode fourth = new ListNode(40);
        fourth.next = third;
        top = fourth;

        stack.top = top;
        return stack;
    }

    public ListNode push(int data) {
        ListNode tempTop = top, newNode = new ListNode(data);
        newNode.next = tempTop;
        tempTop = newNode;
        top = tempTop;
        return top;
    }

    public ListNode pop() {
        if (IsEmpty()) {

        }
        ListNode temp = top;
        top = top.next;
        temp = null;
        return top;
    }

    public ListNode peek() {
        if (IsEmpty()) {
            throw new EmptyStackException();
        }
        return top;
    }

    public void displayStack() {
        ListNode current = top;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" --> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
