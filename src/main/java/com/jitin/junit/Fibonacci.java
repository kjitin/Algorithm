package com.jitin.junit;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static Map<Long, Long> memo = new HashMap<>();

    public static long fibonacci(long x) {
        if (x ==0 || x==1) {
            return x;
        }

        if (memo.containsKey(x)) {
            return memo.get(x);
        }

        long result =  fibonacci(x-1)+ fibonacci(x-2);
        memo.put(x, result);
        return  result;
    }


    public static void main(String[] args) {
        System.out.println(fibonacci(9));
    }
}
