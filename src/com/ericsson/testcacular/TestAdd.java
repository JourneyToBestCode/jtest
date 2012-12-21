package com.ericsson.testcacular;

import com.ericsson.cacular.Add;
import com.ericsson.jtest.Assert;
public class TestAdd {

    public void testAddInt() {
        Add cal = new Add();
        int result = cal.add(1, 2);
        Assert.assertEquals(3, result);
    }

    public void testAddDouble() {
        Add cal = new Add();
        double result = cal.add(1.0, 2.0);
        Assert.assertEquals(3.0, result);
    }
}
