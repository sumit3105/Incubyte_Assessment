package com.sumit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdderTest {

    // Test Case - 1 : Check for empty string
    @Test
    void returnZeroOnEmptyString()
    {
        Adder obj = new Adder();
        assertEquals(0, obj.add(""));
    }

    // Test Case - 2 : Return number itself if Single number is provided
    @Test
    void returnNumberIfSingleNumber()
    {
        Adder obj = new Adder();
        assertEquals(14, obj.add("14"));
        assertEquals(31, obj.add("31"));
    }

    // Test Case - 3 : Check sum for comma separated values
    @Test
    void returnsSumIfTwoNumbersGiven()
    {
        Adder obj = new Adder();
        assertEquals(45, obj.add("14,31"));
    }

    // Test case - 4 : Support for New line as delimiter
    @Test
    void supportForNewLineAsDelimiter()
    {
        Adder obj = new Adder();
        assertEquals(6, obj.add("1\n2,3"));
        assertEquals(165, obj.add("31\n32,33\n34\n35"));
    }
}
