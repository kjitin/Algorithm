package com.jitin.junit;

/**
 * Created by Jitin on 25/03/2017.
 */
public class Adder {


    public Object add(Number a,Number b){

        return a.doubleValue()+b.doubleValue();
    }

    public Object add(String a, String b){
        return  a+b;
    }

}
