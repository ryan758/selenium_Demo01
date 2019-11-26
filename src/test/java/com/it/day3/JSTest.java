package com.it.day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSTest {//运行js脚本

    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//全局等待,10秒内没找到等待，超时后也执行
    }


    @Test
    public void JSTest1() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        JavascriptExecutor js =(JavascriptExecutor)webDriver;
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"liwenjie\")");
        Thread.sleep(3000);


    }






    @AfterMethod
    public void closeDriver() throws InterruptedException { //关闭浏览器
        Thread.sleep(3000);
        webDriver.quit();
    }
}
