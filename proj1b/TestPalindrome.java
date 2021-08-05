import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(null));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("b"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));

        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("rancor"));
        assertFalse(palindrome.isPalindrome("aaaaab"));

    }

    @Test
    public void testIsPalindromeCC() {
        //TODO: modify the following asserts
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome(null, cc));
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("b", cc));
        assertTrue(palindrome.isPalindrome("racecar", cc));
        assertTrue(palindrome.isPalindrome("noon", cc));

        assertFalse(palindrome.isPalindrome("horse", cc));
        assertFalse(palindrome.isPalindrome("rancor", cc));
        assertFalse(palindrome.isPalindrome("aaaaab", cc));

        assertFalse(palindrome.isPalindrome("racecar", null));
    }
}
