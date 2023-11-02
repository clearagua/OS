public class PriorityQueue {
    private Process[] heap;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new Process[capacity];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void insert(Process process) {
        if (size == capacity) {
            System.out.println("Full");
            return;
        }

        int i = size;
        size++;
        heap[i] = process;

        while (i != 0 && heap[parent(i)].getPriority() > heap[i].getPriority()) {
            swap(i, parent(i));
        }
    }

    public Process remove() {
        if (this.size == 1) {
            this.size--;
            return this.heap[0];
        }

        Process root = this.heap[0];
        this.heap[0] = this.heap[this.size-1];
        this.size--;
        heapify(0);

        return root;
    }

    private void heapify(int i) {
        int left = leftChild(i);
        int right =  rightChild(i);
        int smallest = i;

        if (left < size && heap[left].getPriority() < heap[smallest].getPriority()) {
            smallest = left;
        }
        if (right < size && heap[right].getPriority() < heap[smallest].getPriority()) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private int parent(int i) {
        return (i - 1)/2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        Process temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
