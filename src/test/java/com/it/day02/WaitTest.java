package com.it.day02;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//全局等待,10秒内没找到等待，超时后也执行
    }


    @Test
    public void waitTest() throws InterruptedException {
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        webDriver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //Thread.sleep(3000);//线程等待不推荐
        //全局等待,10秒内找到继续执行，否则超时
        String text = webDriver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();

        Assert.assertEquals(text,"wait for display");

    }
    @Test
    public void waitTest2() throws InterruptedException {
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        webDriver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"display\"]/div")));

        String text = webDriver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(text,"wait for display");

    }



    @AfterMethod
    public void closeDriver() throws InterruptedException { //关闭浏览器
        Thread.sleep(3000);
        webDriver.quit();
    }
}
