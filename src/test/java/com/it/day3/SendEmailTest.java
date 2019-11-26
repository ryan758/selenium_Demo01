package com.it.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SendEmailTest {
    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();

    }


    @Test
    public void sendEmailTest() throws InterruptedException {//163邮箱登录成功
        webDriver.get("https://mail.163.com");
        webDriver.findElement(By.id("switchAccountLogin")).click();
        //iframe[starts-with(@id, 'x-URS-iframe')]"
        WebElement iframe = webDriver.findElement(By.xpath("//*[starts-with(@id, 'x-URS-iframe')]"));
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.name("email")).sendKeys("15993793697");
        webDriver.findElement(By.name("password")).sendKeys("345678");
        webDriver.findElement(By.id("dologin")).click();

        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        //发送邮件
        ////*[@id="dvNavTop"]/ul/li[2]/span[2]
        webDriver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();

        webDriver.findElement(By.className("nui-editableAddr-ipt")).sendKeys("15993793697@163.com");
       //*[@aria-label="邮件主题输入框，请输入邮件主题"]/input
        webDriver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("测试");
        webDriver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("D:\\logo.png");

        WebElement frame = webDriver.findElement(By.className("APP-editor-iframe"));
        webDriver.switchTo().frame(frame);
        ///html/body
        webDriver.findElement(By.xpath("/html/body")).sendKeys("你好,我是ryan");

        webDriver.switchTo().defaultContent();
        webDriver.findElement(By.xpath("//*[text()=\"发送\"]")).click();
        WebDriverWait wait1 = new WebDriverWait(webDriver, 10);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"发送成功\"]")));
        boolean displayed = webDriver.findElement(By.xpath("//*[text()=\"发送成功\"]")).isDisplayed();
        Assert.assertTrue(displayed);

    }


    @AfterMethod
    public void closeDriver()throws InterruptedException { //关闭浏览器
        Thread.sleep(3000);
        webDriver.quit();
    }

}
