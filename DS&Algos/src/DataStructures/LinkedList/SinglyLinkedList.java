package DataStructures.LinkedList;

public class SinglyLinkedList {
    private ListNode head;
    public static class ListNode {
        public int data;
        public ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void DisplayLinkedList() {
        ListNode current = head;
        while(current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println();
    }

    public int GetLength() {
        int length = 0;
        ListNode current = head;
        while(current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void InsertAtBeginning(int num) {
        ListNode node = new ListNode(num);
        node.next = head;
        head = node;
    }

    public void InsertAtEnd(int num) {
        ListNode lastNode = new ListNode(num);
        ListNode current = head;
        while(current != null) {
            if (current.next == null) {
                current.next = lastNode;
                lastNode.next = null;
            }
            current = current.next;
        }
    }

    public ListNode GetNthNodeByPosition(int position) {
        ListNode current = head, result = null;
        int index = 0;
        while(current != null) {
            index++;
            if (index == position) {
                result = current;
                return result;
            }
            current = current.next;
        }
        return result;
    }

    public void InsertAtNthIndex(int position, int num) {
        ListNode node = new ListNode(num);
        ListNode priorToPositionNode = GetNthNodeByPosition(position-1);
        ListNode nodeAtPosition = GetNthNodeByPosition(position);
        priorToPositionNode.next = node;
        node.next = nodeAtPosition;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode last = new ListNode(40);
        singlyLinkedList.head.next = second;
        second.next = third;
        third.next = last;
        last.next = null;
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.DisplayLinkedList();
        // Insert at beginning
        singlyLinkedList.InsertAtBeginning(50);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.DisplayLinkedList();

        // Insert at end
        singlyLinkedList.InsertAtEnd(60);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.DisplayLinkedList();

        /*ListNode n = singlyLinkedList.GetNthNodeByPosition(3);
        System.out.println(n.data);*/

        // Insert at given position
        singlyLinkedList.InsertAtNthIndex(2, 5);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.DisplayLinkedList();
    }
}
