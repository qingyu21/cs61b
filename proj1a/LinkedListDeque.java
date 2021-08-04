/**
 * LinkedListDeque class
 * 
 * @author yin
 * @param <T>
 */
public class LinkedListDeque<T> {

    public class Node {
        private Node prev;
        private T item;
        private Node next;

        Node(Node prevNode, T itemValue, Node nextNode) {
            prev = prevNode;
            item = itemValue;
            next = nextNode;
        }
    }

    private int size;
    private Node sentinel;

    /**
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * 
     * @param item
     */
    public void addFirst(T item) {
        Node newNode = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * 
     * @param item
     */
    public void addLast(T item) {
        Node last = sentinel.prev;
        Node newNode = new Node(last, item, sentinel);
        last.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     * 
     * @return
     */
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    /**
     * Returns the number of items in the deque.
     * 
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space.
     */
    public void printDeque() {
        Node ptr = sentinel.next;
        while (ptr != sentinel) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }

    /**
     * Removes and returns the item at the front of the deque. If no such item
     * exists, returns null.
     * 
     * @return
     */
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        Node front = sentinel.next;
        sentinel.next = front.next;
        front.next.prev = sentinel;

        size--;

        return front.item;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item
     * exists, returns null.
     * 
     * @return
     */
    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        Node last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;

        size--;

        return last.item;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque!
     * 
     * @param index
     * @return
     */
    public T get(int index) {
        Node front = sentinel.next;

        while (front != sentinel) {
            if (index == 0) {
                return front.item;
            }
            index--;
            front = front.next;
        }
        return null;
    }

    /**
     * Same as get, but uses recursion.
     * 
     * @param index
     * @return
     */
    public T getRecursive(int index) {
        return getHelper(sentinel.next, index);
    }

    private T getHelper(Node ptr, int index) {
        if (ptr == sentinel) {
            return null;
        }
        if (index == 0) {
            return ptr.item;
        }
        return getHelper(ptr.next, index - 1);
    }

}
