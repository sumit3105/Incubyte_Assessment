package com.sumit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdderTest {

    @Test
    void returnZeroOnEmptyString() {
        Adder calc = new Adder();
        assertEquals(0, calc.add(""));
    }
}
