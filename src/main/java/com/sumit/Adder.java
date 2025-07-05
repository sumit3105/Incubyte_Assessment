package com.sumit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Adder {

    // Helper method to extract delimiter from numbers string literal
    private String extractDelimiter(String numbers)
    {
        if(!numbers.startsWith("//"))
            return "[,\n]";

        int index = numbers.indexOf("\n");
        String delimiter = numbers.substring(2, index);

        if(delimiter.contains("[") && delimiter.contains("]"))
        {
            Matcher matcher = Pattern.compile("\\[(.*?)]").matcher(delimiter);
            List<String> delimiters = new ArrayList<>();

            while(matcher.find())
            {
                delimiters.add(Pattern.quote(matcher.group(1)));
            }

            return String.join("|", delimiters);
        }
        else
            return Pattern.quote(delimiter);
    }

    // Helper method to extract numbers as string from input string
    private String extractNumbers(String numbers)
    {
        return numbers.startsWith("//") ? numbers.substring(numbers.indexOf("\n") + 1) : numbers;
    }

    // Helper method to validate input numbers
    private void validateTokens(String[] numbers)
    {
        List<Integer> negatives = new ArrayList<>();
        List<String> invalids = new ArrayList<>();

        for (String token : numbers)
        {
            try
            {
                int val = Integer.parseInt(token);
                if (val < 0)
                    negatives.add(val);
            }
            catch (NumberFormatException e)
            {
                invalids.add(token);
            }
        }

        if (!negatives.isEmpty())
        {
            throw new IllegalArgumentException("negative numbers not allowed " + negatives.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }

        if (!invalids.isEmpty())
        {
            throw new IllegalArgumentException("Invalid number found: " + String.join(" ", invalids));
        }
    }

    public int add(String numbers)
    {
        if(numbers.isEmpty())
            return 0;

        String delimiter = this.extractDelimiter(numbers);
        numbers = this.extractNumbers(numbers);

        String[] nums = numbers.split(delimiter);

        this.validateTokens(nums);

        int sum = 0;
        for(String num : nums)
        {
            int val = Integer.parseInt(num);
            if(val <= 1000)
                sum += val;
        }

        return sum;
    }
}
