import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciTestSemConstrutor {

    @Parameterized.Parameters(name = "{index}: fib({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }, { 7, 13 }, { 8, 21 }
        });
    }

    @Parameter
    public int fInput;

    @Parameter(1)
    public int fExpected;


    @Test
    public void test() {
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}