package com.jitin.junit;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Created by Jitin on 25/03/2017.
 */

@RunWith(Theories.class)
public class MyTheoryTest {

    @DataPoint
    public static String jitin ="Jitin";
    @DataPoint
    public static String samiksh ="Samiksh";

    @DataPoints
    public static char[] chars = new char[]{'A','B','C'};

    @Theory
    public void sanityCheck(String firstName,String lastName){
        System.out.println("test "+ firstName+" , "+lastName);
    }

    @Theory
    public void build(char a, char b){
        System.out.println(a+ " "+ b);
    }


}
