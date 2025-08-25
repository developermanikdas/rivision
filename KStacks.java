class KStacks {
    int[] arr;     // actual array
    int[] top;     // top of each stack
    int[] next;    // next free or next element
    int freeTop;   // beginning of free list
    int k, n;

    // Constructor
    public KStacks(int k, int n) {
        this.k = k;
        this.n = n;
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        // initialize all stacks as empty
        for (int i = 0; i < k; i++)
            top[i] = -1;

        // initialize free list
        freeTop = 0;
        for (int i = 0; i < n - 1; i++)
            next[i] = i + 1;
        next[n - 1] = -1;
    }

    // Push operation
    public void push(int sn, int value) {
        if (freeTop == -1) {
            System.out.println("Stack Overflow");
            return;
        }

        int i = freeTop;        // take free index
        freeTop = next[i];      // update freeTop

        arr[i] = value;         // store value
        next[i] = top[sn];      // link old top
        top[sn] = i;            // new top
    }

    // Pop operation
    public int pop(int sn) {
        if (top[sn] == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int i = top[sn];        // index of top item
        top[sn] = next[i];      // update top to next
        next[i] = freeTop;      // put this index in free list
        freeTop = i;

        return arr[i];
    }

    // Check if a stack is empty
    public boolean isEmpty(int sn) {
        return top[sn] == -1;
    }
}
