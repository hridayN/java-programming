package DataStructures.Queue;

public class MaxPriorityQueue {
    private Integer[] heap;
    // Size indicates the number of elements in the Priority Queue
    private int size;

    public MaxPriorityQueue(int capacity) {
        this.heap = new Integer[capacity + 1];
        this.size = 0;
    }

    public boolean IsEmpty() {
        return this.size == 0;
    }

    public int Size() {
        return this.size;
    }

    public int Capacity() {
        return heap.length - size;
    }

    public void Resize(int length) {
        Integer[] newHeap = new Integer[length];
        for (int i = 1; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    public void Insert(int value) {
        if (size == heap.length-1) {
            Resize(2 * heap.length);
        }

        size++;
        heap[size] = value;
        Swim(size);
    }

    /*
    * This method performs bottom-up re-heapify
    * For node at kth level, verify whether it is lesser than its parent, else swap both
    * Usually required when Inserting a new node
    * */
    public void Swim(int k) {
        // If k th level is for child, parent will be at k/2 th level
        while (k > 1 && heap[k/2] < heap[k]) {
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k / 2;
        }
    }

    /*Deletes the max, i.e., root node*/
    public void DeleteMax() {
        if (heap.length > 0) {
            //displayArray(heap);
            int maxIndex = 1, minIndex = GetHeapMinIndex();
            int max = heap[maxIndex], min = heap[minIndex];
            //System.out.println(String.format("Max: %d, Min: %d", max, min));

            // swap max and min
            int temp = heap[maxIndex];
            heap[maxIndex] = heap[minIndex];
            heap[minIndex] = temp;

            // delete last element, as it's max now
            heap[minIndex] = null;
            size--;
            //displayArray(heap);
            // perform skim operation
            Skim(size);
        }

    }

    /*
     * This method performs top-down re-heapify
     * For node at kth level, verify whether it is lesser than its parent, else swap both
     * Usually required when Deleting the max(root) node
     */
    public void Skim(int size) {
        int k = 1;
        while (k < size && heap[2*k] != null) {
            // get child nodes for kth level
            int leftChild = heap[2*k], rightChild = heap[2*k+1];
            // swap parent with max of children, if parent < maxChild
            int maxChild = (leftChild > rightChild) ? leftChild : rightChild;
            int maxChildIndex = (leftChild > rightChild) ? 2*k : 2*k+1;
            if (heap[k] < maxChild) {
                int temp = heap[k];
                heap[k] = heap[maxChildIndex];
                heap[maxChildIndex] = temp;
            }
            k++;
        }
    }
    public int GetHeapMin() {
        int min = heap[1];
        for(int i = 2; i < heap.length; i++) {
            min = heap[i];
            if (heap[i+1] == null) break;
        }
        return min;
    }

    public int GetHeapMinIndex() {
        int minIndex = 1;
        for(int i = 2; i < heap.length; i++) {
            minIndex = i;
            if (heap[i+1] == null) break;
        }
        return minIndex;
    }

    public static void displayArray(Integer[] arr) {
        for (int i = 0; i <= arr.length; i++) {
            if (arr[i] != null) System.out.print(arr[i] + ", ");
            if (arr[i+1] == null) break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxPriorityQueue maxPq = new MaxPriorityQueue(5);
        System.out.println(String.format("IsEmpty: %b", maxPq.IsEmpty()));
        System.out.println(String.format("length: %d", maxPq.heap.length));
        System.out.println(String.format("Capacity: %d", maxPq.Capacity()));
        System.out.println(String.format("Size: %d", maxPq.Size()));
        maxPq.Insert(10);
        System.out.println(String.format("IsEmpty: %b", maxPq.IsEmpty()));
        System.out.println(String.format("Capacity: %d", maxPq.Capacity()));
        System.out.println(String.format("Size: %d", maxPq.Size()));
        maxPq.Insert(50);
        maxPq.Insert(15);
        maxPq.Insert(5);
        maxPq.Insert(40);
        maxPq.Insert(20);
        displayArray(maxPq.heap);
        maxPq.DeleteMax();
        displayArray(maxPq.heap);
        /*//System.out.println(String.format("IsEmpty: %b", maxPq.IsEmpty()));
        maxPq.Resize(2 * maxPq.heap.length);
        System.out.println(String.format("length: %d", maxPq.heap.length));*/
    }
}
