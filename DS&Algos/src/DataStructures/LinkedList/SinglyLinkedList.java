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
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println();
    }

    public int GetLength() {
        int length = 0;
        ListNode current = head;
        while (current != null) {
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
        while (current != null) {
            if (current.next == null) {
                current.next = lastNode;
                lastNode.next = null;
            }
            current = current.next;
        }
    }

    public ListNode GetNthNodeByPosition(int position) {
        if (position < 1) {
            System.out.println(String.format("%d position doesn't exists in List", position));
            return null;
        } else {
            ListNode current = head, result = null;
            int index = 0;
            while (current != null) {
                index++;
                if (index == position) {
                    result = current;
                    return result;
                }
                current = current.next;
            }
            return result;
        }
    }

    public void InsertAtNthIndex(int position, int num) {
        ListNode node = new ListNode(num);
        ListNode priorToPositionNode = GetNthNodeByPosition(position - 1);
        ListNode nodeAtPosition = GetNthNodeByPosition(position);
        priorToPositionNode.next = node;
        node.next = nodeAtPosition;
    }

    public void DeleteNode(int position) {
        if (position < 1) {
            System.out.println(String.format("%d position doesn't exist in List", position));
        } else {
            SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
            int length = singlyLinkedList.GetLength();
            // Fetch node at given position
            ListNode nodeAtPosition = GetNthNodeByPosition(position);

            ListNode priorNodeAtPosition = null;

            if (position == 1) {
                // If we're deleting 1st node, we'll set head to (position+1)
                ListNode nextNode = GetNthNodeByPosition(position + 1);
                head = nextNode;
            } else {
                // Fetch node at position-1 and set it's next to position+1
                priorNodeAtPosition = GetNthNodeByPosition(position - 1);
                priorNodeAtPosition.next = (position == length) ? null : GetNthNodeByPosition(position + 1);
            }

            System.out.println(String.format("Node with data: %d successfully deleted from position %d", nodeAtPosition.data, position));
            // Make current node, point to null
            nodeAtPosition.next = null;
        }
    }

    /*Idea is*/
    public void ReverseLinkedList() {
        // The node which we are working on
        ListNode currentNode = head;

        // The node previous to which we are working on
        ListNode previousNode = null;

        // The node next to which we are working on
        ListNode nextNode = null;

        while (currentNode != null) {
            // Make nextNode to be our currentNode
            nextNode = currentNode.next;

            // Make current's point to previous
            currentNode.next = previousNode;

            // Now current will be previous
            previousNode = currentNode;

            // Make current node as Next, to iterate to the last, will we encounter null i.e., last node
            currentNode = nextNode;
        }
        head = previousNode;
    }

    public ListNode GetMiddleNode(SinglyLinkedList singlyLinkedList) {
        int length = singlyLinkedList.GetLength(), position = 0;
        position = (length / 2) + 1;
        return GetNthNodeByPosition(position);
    }

    /*// Here, we'll take 2 pointers starting from head
    * Move 1st pointer position times
    * Now move 1st and 2nd pointer both, till 1st encounters null. The position of 2nd pointer at the time the 1st encounters
    * null will be the Nth node from end 1*/
    public ListNode GetNthNodeFromEnd(int position) {
        ListNode mainNode = head;
        ListNode tempNode = head;
        int count = 0;
        while (count < position) {
            tempNode = tempNode.next;
            count++;
        }
        while (tempNode != null) {
            tempNode = tempNode.next;
            mainNode = mainNode.next;
        }
        return mainNode;
    }

    /*Principle: To remove duplicate nodes from the Sorted Linked List without performing Delete operation.
    */
    public void RemoveDuplicateNodesFromListWithoutPerformingDelete() {
        ListNode current = head;
        while(current != null && current.next != null) {
            // If current's data is equal to it's next node's data, make current point to it's next node's next
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void SwapPositionsDataInLinkedList(int position1, int position2) {
        ListNode position1Node = GetNthNodeByPosition(position1);
        int tempNodeData = position1Node.data;
        ListNode position2Node = GetNthNodeByPosition(position2);
        position1Node.data = position2Node.data;
        position2Node.data = tempNodeData;
    }

    public void BubbleSortLinkedList(SinglyLinkedList singlyLinkedList) {
        int length = singlyLinkedList.GetLength(), countOuter = 1, passThrough = 0;
        while (countOuter < length) {
            System.out.println(String.format("***** Passthrough %d *****", ++passThrough));
            int swaps = 0;
            int countInner = 1;
            while (countInner <= (length-passThrough)) {
                ListNode current = singlyLinkedList.GetNthNodeByPosition(countInner);
                System.out.println(String.format("Comparing (%d, %d)", current.data, current.next.data));
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swaps++;
                }
                countInner++;
            }
            if (swaps == 0) {
                return;
            }
            countOuter++;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode last = new ListNode(5);
        singlyLinkedList.head.next = second;
        second.next = third;
        third.next = last;
        last.next = null;

        /*System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.DisplayLinkedList();
        // Insert at beginning
        singlyLinkedList.InsertAtBeginning(50);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.DisplayLinkedList();

        // Insert at end
        singlyLinkedList.InsertAtEnd(60);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.DisplayLinkedList();

        ListNode n = singlyLinkedList.GetNthNodeByPosition(3);
        System.out.println(n.data);

        // Insert at given position
        singlyLinkedList.InsertAtNthIndex(2, 5);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.DisplayLinkedList();

        // Delete node from a position other than first and last
        singlyLinkedList.DeleteNode(1);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.DisplayLinkedList();

        // Delete node from 1st position
        singlyLinkedList.DeleteNode(1);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.DisplayLinkedList();

        System.out.println(String.format("MiddleNode data: %d", singlyLinkedList.GetMiddleNode(singlyLinkedList).data));

        // Delete node from last position
        singlyLinkedList.DeleteNode(singlyLinkedList.GetLength());
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength()));
        singlyLinkedList.DisplayLinkedList();

        // Delete node from invalid position
        singlyLinkedList.DeleteNode(0);

        // Reverse LinkedList
        singlyLinkedList.ReverseLinkedList();
        singlyLinkedList.DisplayLinkedList();

        //System.out.println(String.format("MiddleNode data: %d", singlyLinkedList.GetMiddleNode(singlyLinkedList).data));

        // Get Nth node from end
        int position = 3;
        ListNode nthNodeFromEnd = singlyLinkedList.GetNthNodeFromEnd(position);
        System.out.println(String.format("%dth node from end is: [%d|%d]", position, nthNodeFromEnd.data, nthNodeFromEnd.next.data));*/

        singlyLinkedList.DisplayLinkedList();
        singlyLinkedList.SwapPositionsDataInLinkedList(2, 3);
        // singlyLinkedList.DisplayLinkedList();
        singlyLinkedList.BubbleSortLinkedList(singlyLinkedList);
        singlyLinkedList.DisplayLinkedList();
    }
}
