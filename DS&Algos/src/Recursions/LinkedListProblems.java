package Recursions;

import DataStructures.LinkedList.ListNode;
import DataStructures.LinkedList.SinglyLinkedList;

public class LinkedListProblems<T> {
    public static void main(String[] args) {
        ListNode<Integer> listHeadNode = SinglyLinkedList.CreateLinkedList();
        PrintLinkedList(listHeadNode);
    }

    public static void PrintLinkedList(ListNode<Integer> listHeadNode) {
        if (listHeadNode == null) return;

        System.out.print(String.format("%d, ", listHeadNode.data));
        PrintLinkedList(listHeadNode.next);
    }
}
