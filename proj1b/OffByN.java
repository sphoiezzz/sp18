public class OffByN implements CharacterComparator {
    /** num is used to do the comparison.*/
    private int num;

    /** A single argument constructor which takes an integer. */
    public OffByN(int N){
        num = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        return diff == num;
    }
}
