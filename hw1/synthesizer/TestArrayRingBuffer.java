package synthesizer;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertTrue(arb.isEmpty());
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }
        assertTrue(arb.isFull());
        //for (int i = 0; i < 10; i++) {
        //    assertEquals(arb.dequeue(),Integer.valueOf(i));
        //}
        for (int i = 0; i < 10; i++) {
            assertEquals(arb.peek(),Integer.valueOf(i));
            arb.dequeue();
        }
    }

    /**
     * Calls tests for ArrayRingBuffer.
     */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
