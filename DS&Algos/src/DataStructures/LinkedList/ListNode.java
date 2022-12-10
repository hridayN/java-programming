package DataStructures.LinkedList;

public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode(T _data) {
        this.data = _data;
        this.next = null;
    }
}
