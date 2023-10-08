package com.jitin.junit;

public class FizzBuzzService {
    public String convert(int i) {

        if(i%15 ==0) {
            return "FizzBuzz";
        }
        if (i%3 ==0) {
            return "Fizz";
        }
        if(i%5 ==0) {
            return "Buzz";
        }

        return String.valueOf(i);
    }
}
