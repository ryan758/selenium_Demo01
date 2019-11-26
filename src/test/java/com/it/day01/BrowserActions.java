package com.it.day01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.Location;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserActions {

    WebDriver webDriver;

    @BeforeMethod
    public void openChrome(){//打开浏览器
        System.setProperty("webdriver.chrome.driver","E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void BrowserActionsTest() throws InterruptedException {//打开页面
        /*System.setProperty("webdriver.chrome.driver","E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();*/
        webDriver.get("http://www.baidu.com");//打开百度首页
        webDriver.navigate().to("https://www.qq.com");
        Thread.sleep(5000);
        /*webDriver.quit();*/
    }

    @Test
    public void BrowserActionsTest02() throws InterruptedException {//浏览器前进后退
        /*System.setProperty("webdriver.chrome.driver","E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();*/
        webDriver.get("http://www.baidu.com");//打开百度首页
        Thread.sleep(2000);
        webDriver.navigate().to("http://tieba.baidu.com");
        Thread.sleep(2000);
        webDriver.navigate().back();
        Thread.sleep(2000);
        webDriver.navigate().forward();
        Thread.sleep(2000);
        /*webDriver.quit();*/
    }

    @Test
    public void BrowserActionsTest03() throws InterruptedException {//浏览器刷新，最大化，调整浏览器大小
        /*System.setProperty("webdriver.chrome.driver","E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();*/
        webDriver.get("http://www.baidu.com");//打开百度首页
        webDriver.manage().window().maximize();//浏览器最大化
        Thread.sleep(3000);
        webDriver.manage().window().setSize(new Dimension(300,300));//设置浏览器大小
        Thread.sleep(5000);
        webDriver.navigate().refresh();
        Thread.sleep(3000);
       /* webDriver.quit();*/

    }
    @Test
    public void BrowserActionsTest04() throws InterruptedException{//获取title和页面url
        /*System.setProperty("webdriver.chrome.driver","E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();*/
        webDriver.get("http://www.baidu.com");//打开百度首页
        Thread.sleep(3000);
        String title = webDriver.getTitle();
        System.out.println(title);
        String currentUrl = webDriver.getCurrentUrl();
        System.out.println(currentUrl);
        /*webDriver.quit();*/
    }


    @AfterMethod
    public void closeDriver(){//关闭浏览器
        webDriver.quit();
    }


}
