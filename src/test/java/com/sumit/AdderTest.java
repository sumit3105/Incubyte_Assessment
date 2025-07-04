package com.sumit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    // Test case - 5 : Support for custom delimiter
    @Test
    void supportForCustomDelimiter()
    {
        Adder obj = new Adder();
        assertEquals(3, obj.add("//;\n1;2"));
        assertEquals(18, obj.add("//*\n3*4*5*6"));
    }

    // Test case - 6 : Throw exception if negative numbers are passed
    @Test
    void exceptionOnNegativeNumbers()
    {
        Adder obj = new Adder();
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> obj.add("-1,2,-3"));
        assertEquals("negative numbers not allowed -1 -3", exception1.getMessage());

        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> obj.add("//*\n-3*4*5*-6"));
        assertEquals("negative numbers not allowed -3 -6", exception2.getMessage());
    }

    // Test case - 7 : Numbers strictly greater than 1000 must be ignored
    @Test
    void ignoreNumberMoreThan1000()
    {
        Adder obj = new Adder();
        assertEquals(3, obj.add("1,2,1001"));
        assertEquals(7, obj.add("//#\n3#4#1002"));
    }

    // Test case - 8 : Test for Multicharacter of Single delimiter
    @Test
    void supportForSingleMultiCharDelimiter()
    {
        Adder obj = new Adder();
        assertEquals(6, obj.add("//[***]\n1***2***3"));
        assertEquals(12, obj.add("//[---]\n3---4---5"));
    }

    // Test case - 9 : Test for Multiple delimiter of single character
    @Test
    void supportForMultipleDelimiterOfSizeOne()
    {
        Adder obj = new Adder();
        assertEquals(6, obj.add("//[*][%]\n1*2%3"));
        assertEquals(25, obj.add("//[#][$][%][&]\n3$4#5&6%7"));
    }


    // Test case - 10 : Test for Multiple delimiter
    @Test
    void supportForMultipleDelimiter()
    {
        Adder obj = new Adder();
        assertEquals(6, obj.add("//[**][%#]\n1%#2**3"));
        assertEquals(25, obj.add("//[#-#][$!!$][^+^][*/*]\n3*/*4$!!$5#-#6^+^7"));
    }

    // Test case - 11 : Test for invalid numbers
    @Test
    void throwExceptionOnInvalidNumbers()
    {
        Adder obj = new Adder();
        Exception ex = assertThrows(IllegalArgumentException.class, () -> obj.add("1,a,b,3"));
        assertEquals("Invalid number found: a b", ex.getMessage());
    }
}
