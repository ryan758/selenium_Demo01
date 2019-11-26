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

public class Login {

    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//全局等待,10秒超时后也执行
    }



    @Test
    public void loginSuccessTest() throws InterruptedException {//163邮箱登录成功
        webDriver.get("https://mail.163.com");
        webDriver.findElement(By.id("switchAccountLogin")).click();
        //iframe[starts-with(@id, 'x-URS-iframe')]"
        WebElement iframe = webDriver.findElement(By.xpath("//*[starts-with(@id, 'x-URS-iframe')]"));
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.name("email")).sendKeys("15993793697");
        webDriver.findElement(By.name("password")).sendKeys("123456");
        webDriver.findElement(By.id("dologin")).click();

        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        String text = webDriver.findElement(By.linkText("退出")).getText();
        Assert.assertEquals(text,"退出");
        webDriver.findElement(By.linkText("退出")).click();

    }

    @Test
    public void loginErrorTest(){//登录失败测试
        webDriver.get("https://mail.163.com");
        webDriver.findElement(By.id("switchAccountLogin")).click();
        /*WebElement iframe = webDriver.findElement(By.xpath("//*[starts-with(@id, 'x-URS-iframe')]"));
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.name("email")).sendKeys("15993793697");
        webDriver.findElement(By.name("password")).sendKeys("123456");
        webDriver.findElement(By.id("dologin")).click();*/
        login(webDriver,"15993793697","1234567");
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nerror\"]/div[2]")));
        //nerror    //*[@id="nerror"]
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"nerror\"]/div[2]"));//动态id定位修改xpath
        String text = element.getText();
        Assert.assertEquals(text,"帐号或密码错误");

    }

    public static void login(WebDriver webDriver,String email,String pwd){

        WebElement iframe = webDriver.findElement(By.xpath("//*[starts-with(@id, 'x-URS-iframe')]"));
        webDriver.switchTo().frame(iframe);
        webDriver.findElement(By.name("email")).sendKeys(email);
        webDriver.findElement(By.name("password")).sendKeys(pwd);
        webDriver.findElement(By.id("dologin")).click();
    }

    @AfterMethod
    public void closeDriver()throws InterruptedException { //关闭浏览器
        Thread.sleep(3000);
        webDriver.quit();
    }
}
