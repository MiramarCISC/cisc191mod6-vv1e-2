package edu.sdccd.cisc191;

import java.util.LinkedList;

public class GenericMatchQueue<T> {

    private final LinkedList<T> items = new LinkedList<>();

    public void enqueue(T item) {
        // TODO: add the item to the back of the queue
    }

    public T dequeue() {
        // TODO: remove and return the front item
        // throw IllegalStateException if the queue is empty
        return null;
    }

    public T peek() {
        // TODO: return the front item without removing it
        // throw IllegalStateException if the queue is empty
        return null;
    }

    public boolean isEmpty() {
        // TODO: return true when the queue has no items
        return false;
    }

    public int size() {
        return items.size();
    }
}
