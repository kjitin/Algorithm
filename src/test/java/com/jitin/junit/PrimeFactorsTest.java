package com.jitin.junit;



import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorsTest {


    private List<Integer> list(Integer... ints){
        return Arrays.asList(ints);
    }


    @Test
    public void factors(){

        assertThat(factorsOf(1),is(list()));
        assertThat(factorsOf(2),is(list(2)));
        assertThat(factorsOf(3),is(list(3)));
        assertThat(factorsOf(4),is(list(2,2)));
        assertThat(factorsOf(5),is(list(5)));
        assertThat(factorsOf(6),is(list(2,3)));
        assertThat(factorsOf(7),is(list(7)));
        assertThat(factorsOf(8),is(list(2,2,2)));
        assertThat(factorsOf(9),is(list(3,3)));
    }


    private List<Integer> factorsOf(int n){
      ArrayList list=  new ArrayList<Integer>();

      for (int divisor=2;n>1;divisor++) {

          for (;n % divisor == 0; n = n/divisor){
             list.add(divisor);

          }

      }


      return list;

    }


}
