public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        if (word == null || word.length() == 0 || word.length() == 1) {
            return true;
        }

        Deque<Character> deque = wordToDeque(word);
        while (deque.size() > 1) {
            Character front = deque.removeFirst();
            Character last = deque.removeLast();
            if (!front.equals(last)) {
                return false;
            }
        }
        return true;
    }
}
