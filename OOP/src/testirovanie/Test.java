package testirovanie;

import org.junit.Assert;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class Test {
    @org.junit.Test
    public void testDifference(){
        Assert.assertEquals(6, Calculator.difference(8, 2));
    }

    @org.junit.Test
    public void testDivide(){
        Assert.assertEquals(3, Calculator.divide(6, 2));
    }

    @org.junit.Test
    public void testDivideException(){
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Calculator.divide(6, 0);
        });

        assertTrue(exception.getMessage().contains("divide by 0"));
    }




}
