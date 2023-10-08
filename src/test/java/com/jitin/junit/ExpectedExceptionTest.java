package com.jitin.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Jitin on 25/03/2017.
 */
public class ExpectedExceptionTest {



    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public  void noException(){}

    @Test
    public void throwsNullPointerException(){

        thrown.expect(NullPointerException.class);
        throw new NullPointerException();

    }

    @Test
    public void throwsIllegalArgumentException(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("legal state?");
        throw new IllegalArgumentException("legal state?");
    }

}
