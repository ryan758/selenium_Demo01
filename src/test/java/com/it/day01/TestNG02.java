package com.it.day01;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG02 {

    @Test
    public void testAssertEquals(){
        String a = "0";
        Assert.assertEquals("0",a,"不相等");
    }
    @Test
    public void testAssertNotEquals(){
        String a = "0";
        Assert.assertNotEquals("0",a,"相等");
    }
    @Test
    public void testAssertNull(){
        String a = null;
        Assert.assertNull(a,"不为空");
    }

    @Test
    public void testAssertNotNull(){
        String a = "";
        Assert.assertNotNull(a,"为空");
    }
}
