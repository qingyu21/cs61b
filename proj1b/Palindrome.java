public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word) {

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

    public boolean isPalindrome(String word, CharacterComparator cc) {

        Deque<Character> deque = wordToDeque(word);
        while (deque.size() > 1) {
            Character front = deque.removeFirst();
            Character last = deque.removeLast();
            if (!cc.equalChars(front, last)) {
                return false;
            }
        }
        return true;
    }
}
