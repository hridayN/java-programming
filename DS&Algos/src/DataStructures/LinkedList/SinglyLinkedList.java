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

    public static void DisplayLinkedList(ListNode list) {
        ListNode current = list;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" --> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static int GetLength(ListNode list) {
        int length = 0;
        ListNode current = list;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static ListNode InsertAtBeginning(ListNode list, int num) {
        ListNode node = new ListNode(num);
        node.next = list;
        list = node;
        return list;
    }

    public static ListNode InsertAtEnd(ListNode list, int num) {
        ListNode lastNode = new ListNode(num);
        ListNode current = list;
        while (current != null) {
            if (current.next == null) {
                current.next = lastNode;
                lastNode.next = null;
            }
            current = current.next;
        }
        return list;
    }

    public static ListNode GetNthNodeByPosition(ListNode list, int position) {
        if (position < 1) {
            System.out.println(String.format("%d position doesn't exists in List", position));
            return null;
        } else {
            ListNode current = list, result = null;
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

    public static ListNode InsertAtNthIndex(ListNode list, int position, int num) {
        ListNode node = new ListNode(num);
        ListNode priorToPositionNode = GetNthNodeByPosition(list, position - 1);
        ListNode nodeAtPosition = GetNthNodeByPosition(list, position);
        priorToPositionNode.next = node;
        node.next = nodeAtPosition;
        return node;
    }

    public static ListNode DeleteNode(ListNode list, int position) {
        if (position < 1) {
            System.out.println(String.format("%d position doesn't exist in List", position));
        } else {
            int length = GetLength(list);
            // Fetch node at given position
            ListNode nodeAtPosition = GetNthNodeByPosition(list, position);

            ListNode priorNodeAtPosition = null;

            if (position == 1) {
                // If we're deleting 1st node, we'll set head to (position+1)
                ListNode nextNode = GetNthNodeByPosition(list, position + 1);
                list = nextNode;
            } else {
                // Fetch node at position-1 and set it's next to position+1
                priorNodeAtPosition = GetNthNodeByPosition(list, position - 1);
                priorNodeAtPosition.next = (position == length) ? null : GetNthNodeByPosition(list, position + 1);
            }

            System.out.println(String.format("Node with data: %d successfully deleted from position %d", nodeAtPosition.data, position));
            // Make current node, point to null
            nodeAtPosition.next = null;
        }
        return list;
    }

    public static ListNode ReverseLinkedList(ListNode list) {
        // The node which we are working on
        ListNode currentNode = list;

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
        list = previousNode;
        return list;
    }

    public static ListNode GetMiddleNode(ListNode list) {
        int length = GetLength(list), position = 0;
        position = (length / 2) + 1;
        return GetNthNodeByPosition(list, position);
    }

    /*// Here, we'll take 2 pointers starting from head
    * Move 1st pointer position times
    * Now move 1st and 2nd pointer both, till 1st encounters null. The position of 2nd pointer at the time the 1st encounters
    * null will be the Nth node from end 1*/
    public static ListNode GetNthNodeFromEnd(ListNode list, int position) {
        ListNode mainNode = list;
        ListNode tempNode = list;
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
    public static ListNode RemoveDuplicateNodesFromListWithoutPerformingDelete(ListNode list) {
        ListNode current = list;
        while(current != null && current.next != null) {
            // If current's data is equal to it's next node's data, make current point to it's next node's next
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return list;
    }

    public static ListNode SwapPositionsDataInLinkedList(ListNode list, int position1, int position2) {
        ListNode position1Node = GetNthNodeByPosition(list, position1);
        int tempNodeData = position1Node.data;
        ListNode position2Node = GetNthNodeByPosition(list, position2);
        position1Node.data = position2Node.data;
        position2Node.data = tempNodeData;
        return list;
    }

    public static ListNode BubbleSortLinkedList(ListNode list) {
        int length = GetLength(list), countOuter = 1, passThrough = 0;
        while (countOuter < length) {
            System.out.println(String.format("***** Passthrough %d *****", ++passThrough));
            int swaps = 0;
            int countInner = 1;
            while (countInner <= (length-passThrough)) {
                ListNode currentNode = GetNthNodeByPosition(list, countInner);
                System.out.println(String.format("Comparing (%d, %d)", currentNode.data, currentNode.next.data));
                if (currentNode.data > currentNode.next.data) {
                    int temp = currentNode.data;
                    currentNode.data = currentNode.next.data;
                    currentNode.next.data = temp;
                    swaps++;
                }
                countInner++;
            }
            if (swaps == 0) {
                return list;
            }
            countOuter++;
        }
        return list;
    }

    public static ListNode InsertNodeInSortedList(ListNode list, ListNode newNode) {
        ListNode current = list, temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return list;
    }

    public static ListNode DeleteNodeByValue(ListNode list, int value) {
        ListNode current = list, temp = null;
        while (current != null && current.data != value) {
            temp = current;
            current = current.next;
        }
        if (current == null) {
            return list;
        } else {
            temp.next = current.next;
        }
        return list;
    }

    /*We need to identify loop in the list
    * Principle: We'll maintain two pointers, moving one faster than another.
    * If, at any point both becomes equal, it indicates presence of loop.*/
    public static boolean DetectLoopInLinkedList(ListNode list) {
        ListNode fastPtr = list, slowPtr = list;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr) return true;
        }
        return false;
    }

    public static int GetLoopStartNodeInLinkedList(ListNode list) {
        ListNode fastPtr = list, slowPtr = list;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr) return GetLoopStartNodeInLinkedListHelper(list, slowPtr).data;
        }
        return -1;
    }

    public static ListNode GetLoopStartNodeInLinkedListHelper(ListNode list, ListNode slowPtr) {
        ListNode tempNode = list;
        while (tempNode != slowPtr) {
            tempNode = tempNode.next;
            slowPtr = slowPtr.next;
        }
        return tempNode;
    }

    public static ListNode RemoveLoopFrpmLinkedList(ListNode list) {
        ListNode fastPtr = list, slowPtr = list;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr) {
                RemoveLoopFromLinkedListHelper(list, slowPtr);
                return list;
            }
        }
        return list;
    }

    /*Idea is to remove the loop
    * Here, we'll take 2 pointers, one will start from the head, another will be our slowPtr(which confirmed our loop
    * Now, we'll keep traversing them one by one unitl their next point to same node.
    * At this point the node at slowPtr will be the end and we'll make it point to null */
    public static ListNode RemoveLoopFromLinkedListHelper(ListNode list, ListNode slowPtr) {
        ListNode temp = list;
        while (slowPtr.next != temp.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
        return list;
    }

    public static ListNode CreateLoopInLinkedList() {
        ListNode first = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);
        ListNode fifth = new ListNode(50);
        ListNode sixth = new ListNode(60);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;

        return first;
    }

    public static ListNode MergeTwoSortedLists(ListNode list1, ListNode list2) {
        // dummy list will contain our final sorted and merged list
        ListNode dummy = new ListNode(0);

        /*tail list will help up to keep track of the current node and contain merged nodes from both lists
        As we're updating tail, dummy will automatically be updated*/
        ListNode tail = dummy;

        /*We'll keep performing check that whichever node's data is lesser,
        we'll keep adding it into the tail list, until either of the list's end is encountered*/
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 == null) {
            tail.next = list2;
        } else {
            tail.next = list1;
        }

        return dummy.next;
    }

    public static ListNode CreateLinkedList() {
        ListNode first = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);
        ListNode fifth = new ListNode(50);
        ListNode sixth = new ListNode(60);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = null;

        return first;
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        System.out.println(String.format("Length: %d", GetLength(null)));
        singlyLinkedList.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode last = new ListNode(40);
        singlyLinkedList.head.next = second;
        second.next = third;
        third.next = last;
        last.next = null;
        System.out.println(String.format("Length: %d", GetLength(singlyLinkedList.head)));
        DisplayLinkedList(singlyLinkedList.head);

        /*// Loop Detection in list
        ListNode loopedList = CreateLoopInLinkedList();
        System.out.println(String.format("Does loop exists: %b", DetectLoopInLinkedList(loopedList)));
        System.out.println(String.format("Loop exists at Node with data: %d", GetLoopStartNodeInLinkedList(loopedList)));*/

        /*// Insert at beginning
        ListNode list = CreateLinkedList();
        ListNode updatedList = InsertAtBeginning(list, 50);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength(updatedList)));
        DisplayLinkedList(updatedList);*/

        // Insert at end
        ListNode list = CreateLinkedList();
        ListNode updatedList = InsertAtEnd(list, 60);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength(updatedList)));
        DisplayLinkedList(updatedList);

        ListNode n = GetNthNodeByPosition(list, 3);
        System.out.println(n.data);

        // Insert at given position
        updatedList = InsertAtNthIndex(list, 2, 5);
        System.out.println(String.format("Length: %d", GetLength(updatedList)));
        DisplayLinkedList(updatedList);

        // Delete node from a position other than first and last
        updatedList = DeleteNode(list, 1);
        System.out.println(String.format("Length: %d", GetLength(updatedList)));
        DisplayLinkedList(updatedList);

        // Delete node from 1st position
        updatedList = DeleteNode(list, 1);
        System.out.println(String.format("Length: %d", GetLength(updatedList)));
        DisplayLinkedList(updatedList);

        System.out.println(String.format("MiddleNode data: %d", GetMiddleNode(list).data));

        // Delete node from last position
        updatedList = DeleteNode(list, GetLength(list));
        System.out.println(String.format("Length: %d", GetLength(updatedList)));
        DisplayLinkedList(updatedList);

        // Delete node from invalid position
        updatedList = DeleteNode(list, 0);

        // Reverse LinkedList
        updatedList = ReverseLinkedList(list);
        DisplayLinkedList(updatedList);

        System.out.println(String.format("MiddleNode data: %d", GetMiddleNode(list).data));

        // Get Nth node from end
        int position = 3;
        ListNode nthNodeFromEnd = GetNthNodeFromEnd(list, position);
        System.out.println(String.format("%dth node from end is: [%d|%d]", position, nthNodeFromEnd.data, nthNodeFromEnd.next.data));

        DisplayLinkedList(list);
        SwapPositionsDataInLinkedList(list, 2, 3);
        DisplayLinkedList(list);
        updatedList = BubbleSortLinkedList(list);
        DisplayLinkedList(updatedList);
        updatedList = InsertNodeInSortedList(list, new ListNode(15));
        DisplayLinkedList(updatedList);
        updatedList = DeleteNodeByValue(list, 10);
        DisplayLinkedList(updatedList);
    }
}
