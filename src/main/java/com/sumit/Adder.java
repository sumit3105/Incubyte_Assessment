package com.sumit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Adder {
    public int add(String numbers) {
        if(numbers.isEmpty())
            return 0;

        String delimiter = "[,\n]";

        if(numbers.startsWith("//"))
        {
            int index = numbers.indexOf("\n");
            String customDelimiter = numbers.substring(2, index);
            numbers = numbers.substring(index + 1);

            if(customDelimiter.contains("[") && customDelimiter.contains("]"))
            {
                Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(customDelimiter);
                List<String> delimiters = new ArrayList<>();

                while(matcher.find())
                {
                    delimiters.add(Pattern.quote(matcher.group(1)));
                }

                delimiter = String.join("|", delimiters);
            }
            else
            {
                delimiter = Pattern.quote(customDelimiter);
            }
        }

        String[] nums = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();

        int sum = 0;
        for(String num : nums)
        {
            if(num.isEmpty())
                continue;
            int val = Integer.parseInt(num);
            if(val < 0)
                negatives.add(val);
            else if(val <= 1000)
                sum += val;
        }

        if(!negatives.isEmpty())
        {
            throw new IllegalArgumentException("negative numbers not allowed " + negatives.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }

        return sum;
    }
}
