package com.it.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTest {

    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void selectTest() throws InterruptedException {
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement webElement = webDriver.findElement(By.id("moreSelect"));
        Select select = new Select(webElement);
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByValue("iphone");
        Thread.sleep(3000);
        select.selectByVisibleText("xiaomi");
        Thread.sleep(3000);

    }






    @AfterMethod
    public void closeDriver(){ //关闭浏览器
        webDriver.quit();
    }
}
