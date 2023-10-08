package com.jitin.junit.cleancode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SortTest {



    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private List<Integer> sort(List<Integer> intList) {

        for (int size = intList.size(); size>0; size --) {
            for (int index = 0; intList.size() > index + 1; index++) {
                if (outOfOrder(intList, index))
                    swap(intList, index);
            }
        }
            return intList;

    }

    private boolean outOfOrder(List<Integer> intList, int index) {
        return intList.get(index) > intList.get(index+ 1);
    }

    private void swap(List<Integer> intList, int index) {
        Integer temp = intList.get(index);
        intList.set(index, intList.get(index+1));
        intList.set(index+1, temp);
    }

    private List<Integer> intList(Integer... integers) {

        return Arrays.asList(integers);
    }

    @Test
    public void sortings() {

        assertSorted(intList(), intList());
        assertSorted(intList(1), intList(1));
        assertSorted(intList(2,1), intList(1,2));
        assertSorted(intList(1,3,2), intList(1,2,3));
        assertSorted(intList(3,2,1), intList(1,2,3));
    }




}
