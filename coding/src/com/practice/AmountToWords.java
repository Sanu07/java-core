package com.practice;

public class AmountToWords {

    private static final String[] LESS_THAN_20 = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
        "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] THOUSANDS = {
        "", "Thousand", "Million", "Billion", "Trillion"
    };

    public String convertToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String result = "";
        int thousandIndex = 0;
        
        while (num > 0) {
            if (num % 1000 != 0) {
                String first = helper(num % 1000);
                String sec = THOUSANDS[thousandIndex];
                result = first + sec + " " + result;
            }
            num /= 1000;
            thousandIndex++;
        }

        return result.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        AmountToWords converter = new AmountToWords();
        
        int amount = 1234;
        // System.out.println(converter.convertToWords(amount)); // Output: One Thousand Two Hundred Thirty-Four
        
        amount = 56789;
        System.out.println(converter.convertToWords(amount)); // Output: Fifty-Six Thousand Seven Hundred Eighty-Nine
    }
}
