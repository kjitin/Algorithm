package com.jitin.junit;

import com.jitin.junit.refactor.Customer;
import com.jitin.junit.refactor.Movie;
import com.jitin.junit.refactor.Rental;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {



    @Test
    public void testCustomerWorks(){

        Customer customer = new Customer("Jitin");
        Movie movieToRent = new Movie("MIB",0);
        Rental rental = new Rental(movieToRent, 2);

        customer.addRental(rental);
        System.out.println(customer.statement());
        assertTrue(customer.statement().contains("2.0"));

    }

    @Test
    public void testCustomerWorksForNewRelease(){

        Customer customer = new Customer("Jitin");
        Movie movieToRent = new Movie("MIB",1);
        Rental rental = new Rental(movieToRent, 2);

        customer.addRental(rental);
        System.out.println(customer.statement());
        assertTrue(customer.statement().contains("6.0"));

    }

}