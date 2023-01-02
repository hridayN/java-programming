package DataStructures.LinkedList;

public class ListNode<T> {
    // Data for the Node
    public T data;

    // Pointer to next node
    public ListNode<T> next;

    /*Constructor*/
    public ListNode(T _data) {
        this.data = _data;
        this.next = null;
    }
}
