class DynamicArray {
    private int[] arr;
    private int length;
    private int capacity;

    // Initializes an empty array with the given capacity
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.length = 0;
        this.arr = new int[this.capacity];
    }

    // Returns the element at index i
    public int get(int i) {
        return this.arr[i];
    }

    // Sets the element at index i to n
    public void set(int i, int n) {
        this.arr[i] = n;
    }

    // Pushes element n to the end, resizing first if necessary
    public void pushback(int n) {
        if (this.length == this.capacity) {
            this.resize();
        }
        this.arr[this.length] = n;
        this.length++;
    }

    // Pops and returns the element at the end of the array
    public int popback() {
        this.length--;
        return this.arr[this.length];
    }

    // Doubles the capacity of the array
    public void resize() {
        this.capacity *= 2;
        int[] newArr = new int[this.capacity];
        
        // Copy existing elements to the new, larger array
        for (int i = 0; i < this.length; i++) {
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
    }

    // Returns the number of actual elements in the array
    public int getSize() {
        return this.length;
    }

    // Returns the total capacity of the array
    public int getCapacity() {
        return this.capacity;
    }
}