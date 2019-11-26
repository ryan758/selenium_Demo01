package com.it.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowSelectTest {
    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void testWin() throws InterruptedException {
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        Thread.sleep(3000);
        webDriver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        String handle1 = webDriver.getWindowHandle();//获取当前窗口句柄
        Set<String> handles = webDriver.getWindowHandles();//浏览器下所有窗口句柄

        for (String handle : handles) {

            if(handle.equals(handle1)){
                continue;
            }else {
                 webDriver = webDriver.switchTo().window(handle);
            }
        }

        webDriver.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
    }




    @AfterMethod
    public void closeDriver(){ //关闭浏览器
        webDriver.quit();
    }
}
