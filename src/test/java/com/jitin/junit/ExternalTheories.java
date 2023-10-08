package com.jitin.junit;

import org.junit.Assert;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * Created by Jitin on 25/03/2017.
 */

@RunWith(Theories.class)
public class ExternalTheories {



    @Theory
    public void addsNumbers(@ParametersSuppliedBy(NumberSupplier.class) Number num1,@ParametersSuppliedBy(NumberSupplier.class) Number num2){

      Adder adder = new Adder();

      double expectedSum = num1.doubleValue()+num2.doubleValue();

      double actualResult= (Double) adder.add(num1,num2);
        System.out.println("expctedSum "+ expectedSum +" and actualResult"+actualResult);

        Assert.assertEquals(actualResult,expectedSum,0.01);
    }
}
