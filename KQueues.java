class KQueues {
    int[] arr;     // array to store elements
    int[] front;   // front indexes of k queues
    int[] rear;    // rear indexes of k queues
    int[] next;    // next free spot / next element link
    int n, k;
    int free;      // beginning index of free list

    // Constructor
    public KQueues(int k, int n) {
        this.k = k;
        this.n = n;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];

        // Initialize all queues as empty
        for (int i = 0; i < k; i++) {
            front[i] = -1;
            rear[i] = -1;
        }

        // Initialize free list
        free = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    // Check if array is full
    boolean isFull() {
        return (free == -1);
    }

    // Check if a specific queue is empty
    boolean isEmpty(int qn) {
        return (front[qn] == -1);
    }

    // Enqueue an item into queue number qn (0-based index)
    void enqueue(int x, int qn) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }

        int i = free;           // Get first free index
        free = next[i];         // Update free

        if (isEmpty(qn)) {
            front[qn] = i;      // First element in queue
        } else {
            next[rear[qn]] = i; // Link new element after rear
        }

        rear[qn] = i;           // Update rear
        next[i] = -1;           // Mark end of queue
        arr[i] = x;
    }

    // Dequeue from queue number qn
    int dequeue(int qn) {
        if (isEmpty(qn)) {
            System.out.println("Queue Underflow");
            return Integer.MAX_VALUE;
        }

        int i = front[qn];      // Get front index
        front[qn] = next[i];    // Move front

        if (front[qn] == -1) {
            rear[qn] = -1;      // Queue became empty
        }

        // Add this index back to free list
        next[i] = free;
        free = i;

        return arr[i];
    }
}
