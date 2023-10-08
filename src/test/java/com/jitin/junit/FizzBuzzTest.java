package com.jitin.junit;

import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {



    @Test
    public void testFizzBuzzForOne() {

        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        Assert.assertEquals("1",fizzBuzzService.convert(1));
    }

    @Test
    public void testFizzBuzzForTwo() {

        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        Assert.assertEquals("2",fizzBuzzService.convert(2));
    }

    @Test
    public void testFizzBuzzForThree() {

        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        Assert.assertEquals("Fizz",fizzBuzzService.convert(3));
    }

    @Test
    public void testFizzBuzzForFive() {

        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        Assert.assertEquals("Buzz",fizzBuzzService.convert(5));
    }

    @Test
    public void testFizzBuzzForFifteen() {

        FizzBuzzService fizzBuzzService = new FizzBuzzService();

        Assert.assertEquals("FizzBuzz",fizzBuzzService.convert(15));
    }
}
