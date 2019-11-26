package com.it.day01;

import org.testng.annotations.*;


public class TestNG01 {


    @BeforeMethod
    public void testBeforeMethod(){//每个@Test运行前运行 ，可以运行多次
        System.out.println("你好@BeforeMethod!");
    }

    @Test
    public void testCase02(){
        System.out.println("你好@testCase02!");
    }

    @Test
    public void testCase01(){//01 02 执行顺序是根据方法名的ascii码决定的
        System.out.println("你好@testCase01!");
    }

    @BeforeTest
    public void testCase03(){ //只运行一次
        System.out.println("你好@BeforeTest");

    }

    @AfterMethod
    public void testAfterMethod(){//每个@Test运行后运行，可以运行多次
        System.out.println("你好@AfterMethod!");
    }
    @AfterTest
    public void testCase04(){//只运行一次
        System.out.println("你好@AfterTest");

    }




}
