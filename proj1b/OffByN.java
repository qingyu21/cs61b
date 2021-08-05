public class OffByN implements CharacterComparator {
    private int size;

    public OffByN(int N) {
        size = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == size;
    }
}
