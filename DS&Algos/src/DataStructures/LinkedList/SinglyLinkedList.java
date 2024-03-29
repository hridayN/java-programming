package DataStructures.LinkedList;

/*LinkedList is LIFO: Last In First Out
Element is added at last
 and removed from beginning*/
public class SinglyLinkedList<T> {
    private ListNode<T> head;

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        /*System.out.println(String.format("Length: %d", GetLength(null)));
        // INITIALIZATION
        singlyLinkedList.head = new ListNode(10);
        ListNode<Integer> second = new ListNode(20);
        ListNode<Integer> third = new ListNode(30);
        ListNode<Integer> last = new ListNode(40);
        singlyLinkedList.head.next = second;
        second.next = third;
        third.next = last;
        last.next = null;
        System.out.println(String.format("Length: %d", GetLength(singlyLinkedList.head)));
        DisplayLinkedList(singlyLinkedList.head);*/

        /* // Loop Detection in listHead
         ListNode<Integer>  loopedList = CreateLoopInLinkedList();
        System.out.println(String.format("Does loop exists: %b", DetectLoopInLinkedList(loopedList)));
        System.out.println(String.format("Loop exists at Node with data: %d", GetLoopStartNodeInLinkedList(loopedList)));*/

        ListNode<Integer> listHead = CreateLinkedList_EvenLength();
        ListNode<Integer> updatedList = null;

        /*// INSERTION
        // Insert at beginning
         ListNode<Integer>  listHead = CreateLinkedList();
         ListNode<Integer>  updatedList = InsertAtBeginning(listHead, 50);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength(updatedList)));
        DisplayLinkedList(updatedList);

        // Insert at end
        updatedList = InsertAtEnd(listHead, 60);
        System.out.println(String.format("Length: %d", singlyLinkedList.GetLength(updatedList)));
        DisplayLinkedList(updatedList);

         ListNode<Integer>  n = GetNthNodeByPosition(listHead, 3);
        System.out.println(n.data);

        // Insert at given position
        updatedList = InsertAtNthIndex(listHead, 2, 5);
        System.out.println(String.format("Length: %d", GetLength(updatedList)));
        DisplayLinkedList(updatedList);
        updatedList = InsertNodeInSortedList(listHead, new ListNode(15));
        DisplayLinkedList(updatedList);*/

        /* DELETION
        // Delete node from a position other than first and last
        updatedList = DeleteNode(listHead, 1);
        System.out.println(String.format("Length: %d", GetLength(updatedList)));
        DisplayLinkedList(updatedList);

        // Delete node from 1st position
        updatedList = DeleteNode(listHead, 1);
        System.out.println(String.format("Length: %d", GetLength(updatedList)));
        DisplayLinkedList(updatedList);

        System.out.println(String.format("MiddleNode data: %d", GetMiddleNode(listHead).data));

        // Delete node from last position
        updatedList = DeleteNode(listHead, GetLength(listHead));
        System.out.println(String.format("Length: %d", GetLength(updatedList)));
        DisplayLinkedList(updatedList);

        // Delete node from invalid position
        updatedList = DeleteNode(listHead, 0);
        updatedList = DeleteNodeByValue(listHead, 10);
        DisplayLinkedList(updatedList);*/

        /*// REVERSAL
        // Reverse LinkedList
        updatedList = ReverseLinkedList(listHead);
        DisplayLinkedList(updatedList);*/

        /* // RETREIVAL
        // System.out.println(String.format("MiddleNode data: %d", GetMiddleNode(listHead).data));

        // Get Nth node from end
        int position = 3;
         ListNode<Integer>  nthNodeFromEnd = GetNthNodeFromEnd(listHead, position);
        System.out.println(String.format("%dth node from end is: [%d|%d]", position, nthNodeFromEnd.data, nthNodeFromEnd.next.data));*/

        /* // SWAPPING
        DisplayLinkedList(listHead);
        SwapPositionsDataInLinkedList(listHead, 2, 3);
        DisplayLinkedList(listHead);*/

        /* // SORTING
        updatedList = BubbleSortLinkedList(listHead);
        DisplayLinkedList(updatedList);*/

        /* ListNode<Integer>  a = listHead;
         ListNode<Integer>  b = ReverseLinkedList(CreateLinkedList());
        // updatedList = AddTwoSinglyLinkedLists(a, b);
        DisplayLinkedList(b);*/

        /*LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        System.out.println(ll);
        ll.remove();
        System.out.println(ll);*/

        // DisplayLinkedList(MoveLastNNodesToFront(listHead, 3));
        // DisplayLinkedList(listHead);
        //DisplayLinkedList(InsertNodeRecursive(listHead, 3));
        // DisplayLinkedList(DeleteListNodeRecursively(listHead, 5, 0));
        listHead = CreateLinkedList_OddLength();
        System.out.println(String.format("Middle node: %d", GetMiddleNode(listHead).data));
    }

    public static void DisplayLinkedList(ListNode<Integer> list) {
        ListNode<Integer> current = list;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" --> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static int GetLength(ListNode<Integer> list) {
        int length = 0;
        ListNode<Integer> current = list;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public static ListNode<Integer> InsertAtBeginning(ListNode<Integer> list, int num) {
        ListNode<Integer> node = new ListNode(num);
        node.next = list;
        list = node;
        return list;
    }

    public static ListNode<Integer> InsertNodeRecursive(ListNode<Integer> listHead, int num) {
        if (listHead.next == null) {
            ListNode<Integer> newNode = new ListNode<>(num);
            listHead.next = newNode;
            return listHead;
        }

        listHead.next = InsertNodeRecursive(listHead.next, num);
        return listHead;
    }

    /*Approach: Here, we are traversing till last node to insert the new node*/
    public static ListNode<Integer> InsertAtEnd(ListNode<Integer> listHead, int num) {
        // Create a new node, which will be our new last
        ListNode<Integer> newLastNode = new ListNode(num);
        if (listHead == null) {
            listHead = newLastNode;
        } else {
            ListNode<Integer> currentNode = listHead;
            while (currentNode != null) {
                // Check if next node is null, indicating we need to insert(or add) new node after here
                if (currentNode.next == null) {
                    currentNode.next = newLastNode;
                    newLastNode.next = null;
                }
                currentNode = currentNode.next;
            }
        }

        return listHead;
    }

    public static ListNode<Integer> GetNthNodeByPosition(ListNode<Integer> list, int position) {
        if (position < 1 || position > GetLength(list)) {
            System.out.println(String.format("%d position doesn't exists in List", position));
            return null;
        } else {
            ListNode<Integer> current = list, result = null;
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

    public static ListNode<Integer> InsertAtNthIndex(ListNode<Integer> list, int position, int num) {
        ListNode<Integer> node = new ListNode(num);
        ListNode<Integer> priorToPositionNode = GetNthNodeByPosition(list, position - 1);
        ListNode<Integer> nodeAtPosition = GetNthNodeByPosition(list, position);
        priorToPositionNode.next = node;
        node.next = nodeAtPosition;
        return node;
    }

    public static ListNode<Integer> DeleteNode(ListNode<Integer> list, int position) {
        if (position < 1) {
            System.out.println(String.format("%d position doesn't exist in List", position));
        } else {
            int length = GetLength(list);
            // Fetch node at given position
            ListNode<Integer> nodeAtPosition = GetNthNodeByPosition(list, position);

            ListNode<Integer> priorNodeAtPosition = null;

            if (position == 1) {
                // If we're deleting 1st node, we'll set head to (position+1)
                ListNode<Integer> nextNode = GetNthNodeByPosition(list, position + 1);
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

    public static ListNode<Integer> ReverseLinkedList(ListNode<Integer> listHead) {
        // The node which we are working on
        ListNode<Integer> currentNode = listHead;

        // The node previous to which we are working on
        ListNode<Integer> previousNode = null;

        // The node next to which we are working on
        ListNode<Integer> nextNode = null;

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
        listHead = previousNode;
        return listHead;
    }

    public static ListNode<Integer> GetMiddleNodeByLength(ListNode<Integer> list) {
        int length = GetLength(list), position = 0;
        position = (length / 2) + 1;
        return GetNthNodeByPosition(list, position);
    }

    /*// Here, we'll take 2 pointers starting from head
     * Move 1st pointer position times
     * Now move 1st and 2nd pointer both, till 1st encounters null. The position of 2nd pointer at the time the 1st encounters
     * null will be the Nth node from end */
    public static ListNode<Integer> GetNthNodeFromEnd(ListNode<Integer> list, int position) {
        ListNode<Integer> mainNode = list;
        ListNode<Integer> tempNode = list;
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
    public static ListNode<Integer> RemoveDuplicateNodesFromListWithoutPerformingDelete(ListNode<Integer> list) {
        ListNode<Integer> current = list;
        while (current != null && current.next != null) {
            // If current's data is equal to it's next node's data, make current point to it's next node's next
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return list;
    }

    public static ListNode<Integer> SwapPositionsDataInLinkedList(ListNode<Integer> list, int position1, int position2) {
        ListNode<Integer> position1Node = GetNthNodeByPosition(list, position1);
        int tempNodeData = position1Node.data;
        ListNode<Integer> position2Node = GetNthNodeByPosition(list, position2);
        position1Node.data = position2Node.data;
        position2Node.data = tempNodeData;
        return list;
    }

    public static ListNode<Integer> BubbleSortLinkedList(ListNode<Integer> list) {
        int length = GetLength(list), countOuter = 1, passThrough = 0;
        while (countOuter < length) {
            System.out.println(String.format("***** Passthrough %d *****", ++passThrough));
            int swaps = 0;
            int countInner = 1;
            while (countInner <= (length - passThrough)) {
                ListNode<Integer> currentNode = GetNthNodeByPosition(list, countInner);
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

    public static ListNode<Integer> InsertNodeInSortedList(ListNode<Integer> list, ListNode<Integer> newNode) {
        ListNode<Integer> current = list, temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return list;
    }

    public static ListNode<Integer> DeleteNodeByValue(ListNode<Integer> list, int value) {
        ListNode<Integer> current = list, temp = null;
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
    public static boolean DetectLoopInLinkedList(ListNode<Integer> list) {
        ListNode<Integer> fastPtr = list, slowPtr = list;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) return true;
        }
        return false;
    }

    public static int GetLoopStartNodeInLinkedList(ListNode<Integer> list) {
        ListNode<Integer> fastPtr = list, slowPtr = list;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) return GetLoopStartNodeInLinkedListHelper(list, slowPtr).data;
        }
        return -1;
    }

    public static ListNode<Integer> GetLoopStartNodeInLinkedListHelper(ListNode<Integer> list, ListNode<Integer> slowPtr) {
        ListNode<Integer> tempNode = list;
        while (tempNode != slowPtr) {
            tempNode = tempNode.next;
            slowPtr = slowPtr.next;
        }
        return tempNode;
    }

    public static ListNode<Integer> RemoveLoopFromLinkedList(ListNode<Integer> list) {
        ListNode<Integer> fastPtr = list, slowPtr = list;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
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
    public static ListNode<Integer> RemoveLoopFromLinkedListHelper(ListNode<Integer> list, ListNode<Integer> slowPtr) {
        ListNode<Integer> temp = list;
        while (slowPtr.next != temp.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
        return list;
    }

    public static ListNode<Integer> CreateLoopInLinkedList() {
        ListNode<Integer> first = new ListNode(10);
        ListNode<Integer> second = new ListNode(20);
        ListNode<Integer> third = new ListNode(30);
        ListNode<Integer> fourth = new ListNode(40);
        ListNode<Integer> fifth = new ListNode(50);
        ListNode<Integer> sixth = new ListNode(60);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;

        return first;
    }

    public static ListNode<Integer> MergeTwoSortedLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        // dummy list will contain our final sorted and merged list
        ListNode<Integer> dummy = new ListNode(0);

        /*tail list will help up to keep track of the current node and contain merged nodes from both lists
        As we're updating tail, dummy will automatically be updated*/
        ListNode<Integer> tail = dummy;

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

    public static ListNode<Integer> CreateLinkedList_EvenLength() {
        ListNode<Integer> first = new ListNode(4);
        ListNode<Integer> second = new ListNode(5);
        ListNode<Integer> third = new ListNode(6);
        ListNode<Integer> fourth = new ListNode(7);
        ListNode<Integer> fifth = new ListNode(8);
        ListNode<Integer> sixth = new ListNode(9);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = null;

        return first;
    }

    public static ListNode<Integer> CreateLinkedList_OddLength() {
        ListNode<Integer> first = new ListNode(4);
        ListNode<Integer> second = new ListNode(5);
        ListNode<Integer> third = new ListNode(6);
        ListNode<Integer> fourth = new ListNode(7);
        ListNode<Integer> fifth = new ListNode(8);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        return first;
    }

    public static ListNode<Integer> AddTwoSinglyLinkedLists(ListNode<Integer> a, ListNode<Integer> b) {
        ListNode<Integer> dummy = new ListNode(0);
        ListNode<Integer> tail = dummy;
        a = ReverseLinkedList(a);
        b = ReverseLinkedList(b);
        int carry = 0;
        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            a = a.next;
            b = b.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

    // N: No. of last nodes to move to front
    public static ListNode<Integer> MoveLastNNodesToFront(ListNode<Integer> listNodeHead, int n) {
        ListNode<Integer> currentNode = listNodeHead, newListNodeHead = null, newListNodeTail = null;
        int nodesVisitedCount = 0;
        while (currentNode != null) {

            ListNode<Integer> currentNodeTemp = currentNode;
            // We are visitng (N-1)th node
            if (nodesVisitedCount == n - 1) {
                for (int i = 0; i < n && currentNode != null; i++) {
                    currentNode = currentNode.next;

                    // Add nodes from here till end to new list
                    newListNodeHead = InsertAtEnd(newListNodeHead, currentNode.data);

                    // Maintain the tail of the new list
                    newListNodeTail = (i == 0) ? newListNodeHead : newListNodeTail.next;
                }
                // Set original list's end point to null
                currentNodeTemp.next = null;

                // Make new list's tail point to original list's head, to link both
                newListNodeTail.next = listNodeHead;
                break;
            }
            nodesVisitedCount++;
            currentNode = currentNode.next;
        }

        // Return new list's head
        return newListNodeHead;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<T> current = head;
        while (current != null) {
            sb.append(current.data + " ");
            current = current.next;
        }
        return sb.toString();
    }

    public static ListNode<Integer> DeleteListNodeRecursively(ListNode<Integer> listNodeHead, int position, int counter) {
        if (listNodeHead == null) return listNodeHead;

        // If next node is the one to be deleted, make currentNode point to Next of nextNode, and point next to null
        if (position == counter + 1) {
            listNodeHead.next = (listNodeHead.next.next == null) ? null : listNodeHead.next.next;
            return listNodeHead;
        }
        listNodeHead.next = DeleteListNodeRecursively(listNodeHead.next, position, counter + 1);
        return listNodeHead;
    }

    public static ListNode<Integer> GetMiddleNode(ListNode<Integer> headNode) {
        ListNode<Integer> slow = headNode, fast = headNode;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
