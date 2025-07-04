package com.sumit;

import java.util.regex.Pattern;

public class Adder {
    public int add(String numbers) {
        if(numbers.isEmpty())
            return 0;

        String delimiter = "[,\n]";

        if(numbers.startsWith("//"))
        {
            int index = numbers.indexOf("\n");
            String custom = numbers.substring(2, index);
            numbers = numbers.substring(index + 1);
            delimiter = Pattern.quote(custom);
        }

        String[] nums = numbers.split(delimiter);

        int sum = 0;
        for(String num : nums)
        {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
