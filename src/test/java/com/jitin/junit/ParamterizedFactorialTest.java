package com.jitin.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Jitin on 25/03/2017.
 */

@RunWith(Parameterized.class)
public class ParamterizedFactorialTest {


    @Parameterized.Parameter(value = 0)
    public int number;
    @Parameterized.Parameter(value = 1)
    public int expectedResult;



    @Parameterized.Parameters(name = "{index}: factorial({0}={1})")
    public static Collection<Object[]> factorialData(){
        return Arrays.asList(new Object[][]{
                {0,1},{1,1},{2,2},{3,6},{4,24}
        });
    }


    @Test
    public void testFactorial(){

        Factorial factorial = new Factorial();
        assertEquals(factorial.factorial(number),expectedResult);
    }

}