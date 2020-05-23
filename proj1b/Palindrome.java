public class Palindrome {
    /**
     * Return a Deque where the characters appear in the same
     * order as in the String
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++){
            wDeque.addLast(word.charAt(i));
        }
        return wDeque;
    }

    /** Returns true if the given word is a palindrome, and false otherwise. */
   /* method1.
    public boolean isPalindrome(String word) {
        Deque<Character> d = wordToDeque(word);
        while (d.size() > 1){
            if (d.removeFirst() != d.removeLast()) {
                return false;
            }
        }
        return true;
    }
    */

    /** Returns true if the given word is a palindrome, and false otherwise.
     * Using recursive method. */
    public boolean isPalindrome(String word) {
       Deque<Character> d = wordToDeque(word);
       return isPalindrome(d);
    }
    private boolean isPalindrome(Deque<Character> d) {
        while (d.size() > 1){
            return d.removeLast() == d.removeFirst() && isPalindrome(d);
        }
        return true;
    }

    /** Overloads isPalindrome. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        while (d.size() > 1) {
            Character first = d.removeFirst();
            Character last = d.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            }
        }
        return true;
    }


    /**
     * TO determine whether a word is a off-by-one palindrome
     * Recursive
     * /

    /*
     private boolean isPalindrome(Deque<Character> wordInDeque, CharacterComparator cc) {
        while (wordInDeque.size() > 1) {
            return cc.equalChars(wordInDeque.removeFirst(), wordInDeque.removeLast()) && isPalindrome(wordInDeque, cc);
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word), cc);
    }
     */


}
