package com.it.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PhantomJSTest {

    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {

        System.setProperty("phantomjs.binary.path", "E:\\selenium\\selenium_Demo01\\drivers\\phantomjs.exe");
          webDriver = new PhantomJSDriver();

        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//全局等待,10秒内没找到等待，超时后也执行
    }



    @Test
    public void phantomjsTest() throws InterruptedException {//不打开浏览器执行测试脚本，效率更高
        webDriver.get("http://www.baidu.com");
        webDriver.findElement(By.id("kw")).sendKeys("phantomJS");
        Thread.sleep(3000);
        String title = webDriver.getTitle();
        System.out.println(title);
    }


    @AfterMethod
    public void closeDriver() throws InterruptedException { //关闭浏览器
        Thread.sleep(3000);
        webDriver.quit();
    }
}
