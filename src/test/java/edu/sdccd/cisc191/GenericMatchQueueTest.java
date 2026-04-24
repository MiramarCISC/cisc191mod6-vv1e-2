package edu.sdccd.cisc191;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GenericMatchQueueTest {

    @Test
    void queueStoresAndRemovesPlayersInFifoOrder() {
        GenericMatchQueue<PlayerAccount> queue = new GenericMatchQueue<>();
        PlayerAccount a = new PlayerAccount("Ana", 1200, "NA");
        PlayerAccount b = new PlayerAccount("Leo", 1300, "EU");

        queue.enqueue(a);
        queue.enqueue(b);

        assertEquals(2, queue.size());
        assertEquals(a, queue.peek());
        assertEquals(a, queue.dequeue());
        assertEquals(b, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void dequeueFromEmptyQueueThrows() {
        GenericMatchQueue<String> queue = new GenericMatchQueue<>();
        assertThrows(IllegalStateException.class, queue::dequeue);
    }

    @Test
    void peekOnEmptyQueueThrows() {
        GenericMatchQueue<Integer> queue = new GenericMatchQueue<>();
        assertThrows(IllegalStateException.class, queue::peek);
    }
}
