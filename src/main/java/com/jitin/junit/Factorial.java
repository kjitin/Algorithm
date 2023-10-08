package com.jitin.junit;

/**
 * Created by Jitin on 25/03/2017.
 */
public class Factorial {


    public long factorial(long number){
        if (number==0){
            return 1;
        }

        return number*factorial(number-1);
    }
}
