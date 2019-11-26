package com.it.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RegisterTest {

    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//全局等待,10秒内没找到等待，超时后也执行
    }
    @Test
    public void Test1() throws InterruptedException {//163邮箱注册
        webDriver.get("https://mail.163.com");
        webDriver.findElement(By.linkText("注册新帐号")).click();
        String windowHandle = webDriver.getWindowHandle();
        Set<String> windowHandles = webDriver.getWindowHandles();
        for (String handle : windowHandles) {
            if(handle.equals(windowHandle)){
                continue;
            }
            webDriver.switchTo().window(handle);
        }
        webDriver.findElement(By.id("nameIpt")).sendKeys("qwq123456789w");
        webDriver.findElement(By.id("mainPwdIpt")).sendKeys("wwe123456");
        webDriver.findElement(By.id("mainCfmPwdIpt")).sendKeys("wwe123456");
        webDriver.findElement(By.id("vcodeIpt")).sendKeys("81681");
        webDriver.findElement(By.id("mainMobileIpt")).sendKeys("19883139022");
        webDriver.findElement(By.id("mainAcceptIpt")).click();
        webDriver.findElement(By.id("mainRegA")).click();
        //显示等待
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_vcode\"]/span")));

        String error = webDriver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span")).getText();
        Assert.assertEquals(error,"  验证码不正确，请重新填写");
    }


    @AfterMethod
    public void closeDriver()throws InterruptedException { //关闭浏览器
        Thread.sleep(3000);
        webDriver.quit();
    }
}
