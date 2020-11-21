package com.uspehgp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionServiceTest {

    DivisionService subj;

    @Before
    public void setUp(){
        subj = new DivisionService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void divide_divisionByZero(){
        subj.divide(2, 0);
    }

    @Test
    public void divide_ok(){
        double expected = 0.5;
        double actual = subj.divide(2, 4);
        assertEquals(expected, actual, 0);
    }
}
