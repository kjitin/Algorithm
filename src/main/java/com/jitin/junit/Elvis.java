package com.jitin.junit;

import java.util.Calendar;

public class Elvis {

    // problem: order of static methods is relevant in the class
    // solution: change order of static methods according to dependencies

    private static final int CURRENT_YEAR = Calendar.getInstance().get(
            Calendar.YEAR);
    public static final Elvis INSTANCE = new Elvis();

    private static final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
    private static final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;

    private final int age;

    static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    }

    private Elvis() {
        age = CURRENT_YEAR - 1935;
    }

    public int beltSize() {
        return age;
    }

    public static void main(String[] args) {
        System.out.println("Elvis is " + INSTANCE.beltSize() + " years old.");
        System.out.println((2.00 - 1.10) + " €");
        Calendar cal = Calendar.getInstance();
        cal.set(1999, 12, 31); // Year, Month, Day
        System.out.println(cal.get(Calendar.YEAR));

        if (Thread.interrupted()) {
            System.out.println("Interrupted: " + Thread.interrupted());
        } else {
            System.out.println("Not interrupted: " + Thread.interrupted());
        }

        Thread.currentThread().interrupt();





        System.out.println(12345 + 5432l);
        System.out.println(01234 + 43210);

        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);

        System.out.println(decision());

        try {
            System.exit(42);
            System.out.println("Hello World");
        } finally {
            System.out.println("finally");
        }

        // what does it print?
        // a) 1935
        // BEFORE b) -1935
        // AFTER c) 79
        // d) 0
        // e) none of the above
    }
}
