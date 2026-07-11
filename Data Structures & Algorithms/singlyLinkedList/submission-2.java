class LinkedList {
    // Define the Node class to structure the memory
    private class Node {
        int val;
        Node next;
        
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int get(int index) {
        Node curr = head;
        int i = 0;
        
        while (curr != null && i < index) {
            curr = curr.next;
            i++;
        }
        
        // If we reached the end before hitting the index
        if (curr == null) {
            return -1;
        }
        return curr.val;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        
        // If list was empty, head and tail are the same node
        if (tail == null) {
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        if (head == null) {
            insertHead(val);
            return;
        }
        
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
    }

    public boolean remove(int index) {
        if (head == null) return false;
        
        // Handle removing the head specifically
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null; // List became empty
            }
            return true;
        }
        
        Node curr = head;
        int i = 0;
        
        // Stop one node BEFORE the one we want to remove
        while (curr != null && i < index - 1) {
            curr = curr.next;
            i++;
        }
        
        // If index is out of bounds
        if (curr == null || curr.next == null) {
            return false;
        }
        
        // Bypass the target node
        curr.next = curr.next.next;
        
        // If we removed the last node, update the tail
        if (curr.next == null) {
            tail = curr;
        }
        
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node curr = head;
        
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }
        
        return values;
    }
}