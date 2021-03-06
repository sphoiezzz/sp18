import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.

     */
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
    public void testisPalindromeCC() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome(" ", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertTrue(palindrome.isPalindrome("&nm%", cc));
        assertTrue(palindrome.isPalindrome("abgab", cc));
        assertTrue(palindrome.isPalindrome("abab", cc));
        assertFalse(palindrome.isPalindrome("sink", cc));
        assertFalse(palindrome.isPalindrome("&14k", cc));
        assertFalse(palindrome.isPalindrome("aa", cc));

    }

    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("A"));
        assertTrue(palindrome.isPalindrome("AAaAA"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("Aa"));
    }





    /**
     * Uncomment this class once you've created your Palindrome class. */
}
