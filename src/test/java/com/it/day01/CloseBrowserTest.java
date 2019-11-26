package com.it.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class CloseBrowserTest {

    @Test
    public void closeChrome1() throws InterruptedException {
        //设置chromeDriver路径
        System.setProperty("webdriver.chrome.driver","E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        //实例化chromeDriver
        WebDriver webDriver = new ChromeDriver();
        //等待5秒关闭浏览器当前窗口 但是chromedriver.exe进程还在 如果运行上万条用例，内存就会耗尽，可以使用quit
        Thread.sleep(5000);
        webDriver.close();
    }
    @Test
    public void closeChrome2() throws InterruptedException {//一般用quit()
        System.setProperty("webdriver.chrome.driver","E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        Thread.sleep(5000);
        webDriver.quit();// 关闭浏览器所有窗口 完全退出 chromedriver.exe进程
    }



}
