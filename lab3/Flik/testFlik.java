import static org.junit.Assert.*;
import org.junit.Test;


public class testFlik {
    @Test
    public void issamenumber() {
        int a = 3;
        int b = 4;
        int c = 4;
        boolean exp = Flik.isSameNumber(a, b);
        boolean exp1 = Flik.isSameNumber(b, c);

        assertTrue(exp1);
        assertFalse(exp);
    }
}

