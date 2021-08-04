import static org.junit.Assert.*;

import org.junit.Test;

public class IntListTest {

    /**
     * Example test that verifies correctness of the IntList.of static method. The
     * main point of this is to convince you that assertEquals knows how to handle
     * IntLists just fine.
     */

    @Test
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.of(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
        IntList list = IntList.of(1, 2, 3);
        IntList.dSquareList(list);
        assertEquals(IntList.of(1, 4, 9), list);
    }

    /**
     * Do not use the new keyword in your tests. You can create lists using the
     * handy IntList.of method.
     * <p>
     * Make sure to include test cases involving lists of various sizes on both
     * sides of the operation. That includes the empty list, which can be
     * instantiated, for example, with IntList empty = IntList.of().
     * <p>
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public void testSquareListRecursive() {
        IntList list = IntList.of(1, 2, 3);
        IntList res = IntList.squareListRecursive(list);
        assertEquals(IntList.of(1, 2, 3), list);
        assertEquals(IntList.of(1, 4, 9), res);
    }

    @Test
    public void testDcatenate() {
        IntList list = IntList.of(1, 2, 3);
        IntList b = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.dcatenate(list, b));
        assertEquals(IntList.of(1, 2, 3, 4, 5, 6), list);
    }

    @Test
    public void testCatenate() {
        IntList a = IntList.of(1, 2, 3);
        IntList b = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.catenate(a, b));
        assertEquals(IntList.of(1, 2, 3), a);
    }

    @Test
    public void testReverse() {
        IntList list = IntList.of(1, 2, 3, 4, 5, 6);
        list = IntList.reverse(list);
        assertEquals(IntList.of(6, 5, 4, 3, 2, 1), list);
        assertNotEquals(IntList.of(1, 2, 3, 4, 5, 6), list);
        assertNull(IntList.reverse(null));
    }

}
