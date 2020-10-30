import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba", "ama", "mirim", "salas" })
    public void testIsPalindrome(String string) {
        assertTrue(Palindrome.isPalindrome(string));
    }

    @ParameterizedTest
    @ValueSource(ints = { 3, 6, 15, 18, 21})
    void divisibleByThree(int number) {
        assertEquals(0, number % 3);
    }



}