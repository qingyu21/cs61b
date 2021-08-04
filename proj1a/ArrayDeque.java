/**
 * @author yin
 * @param <T>
 */
public class ArrayDeque<T> {
    private T[] items;
    private int size;

    private int first;

    private int capacity;

    /**
     * Creates an empty array deque.
     */
    public ArrayDeque() {
        capacity = 8;
        items = (T[]) new Object[capacity];
        size = 0;
        first = 0;
    }

    private void resize(int newCapacity) {
        T[] newItems = (T[]) new Object[newCapacity];
        // copy items
        if (newCapacity > capacity) {
            // increase capacity
            System.arraycopy(items, first, newItems, 0, capacity - first);
            System.arraycopy(items, 0, newItems, capacity - first, first);
        } else {
            // decrease capacity
            if (first + size - 1 >= capacity) {
                System.arraycopy(items, first, newItems, 0, capacity - first);
                System.arraycopy(items, 0, newItems, capacity - first, size - (capacity - first));
            } else {
                System.arraycopy(items, first, newItems, 0, size);
            }
        }
        first = 0;
        capacity = newCapacity;
        items = newItems;
    }

    /**
     * Adds an item of type T to the front of the deque.
     * 
     * @param item
     */
    public void addFirst(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        first = first - 1;
        if (first < 0) {
            first += capacity;
        }
        items[first] = item;
        size++;
    }

    /**
     * Adds an item of type T to the back of the deque.
     * 
     * @param item
     */
    public void addLast(T item) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        items[(first + size) % capacity] = item;
        size++;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     * 
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
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
        for (int i = 0; i < size; i++) {
            System.out.print(items[(first + i) % capacity] + " ");
        }
    }

    private static int lowerBound = 16;
    private static double minimumPercentage = 0.25;

    /**
     * Removes and returns the item at the front of the deque. If no such item
     * exists, returns null.
     * 
     * @return
     */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T itemValue = items[first];
        items[first] = null;
        first = (first + 1) % capacity;
        size--;
        if (size >= lowerBound && (double) size / capacity < minimumPercentage) {
            resize(capacity / 2);
        }
        return itemValue;
    }

    /**
     * Removes and returns the item at the back of the deque. If no such item
     * exists, returns null.
     * 
     * @return
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T itemValue = items[first + size];
        items[first + size] = null;
        size--;
        if (size > lowerBound && (double) size / capacity < minimumPercentage) {
            resize(capacity / 2);
        }
        return itemValue;
    }

    /**
     * Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque!
     * 
     * @param index
     * @return
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return items[(first + index) % capacity];
    }
}
