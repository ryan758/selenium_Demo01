package com.it.day02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionTest {
    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    @Test
    public void clickTest(){//元素点击
        webDriver.get("http://www.baidu.com");
        WebElement hao123 = webDriver.findElement(By.xpath("//*[@id='u1']/a[2]"));
        hao123.click();
        String currentUrl = webDriver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"https://www.hao123.com/");

    }

    @Test
    public void inputTest() throws InterruptedException {//元素输入
        webDriver.get("http://www.baidu.com");
        WebElement kw = webDriver.findElement(By.id("kw"));
        kw.sendKeys("宝");
        Thread.sleep(2000);
        kw.clear();//清空文本输入
        Thread.sleep(3000);
        kw.sendKeys("宝马");//输入框输入文本内容
        WebElement su = webDriver.findElement(By.id("su"));
        su.click();
        Thread.sleep(3000);
        WebElement img = webDriver.findElement(By.xpath("//*[@id='1']/div/div[1]/a/img"));
        Assert.assertNotNull(img);



    }

    @Test
    public void getTagNameTest() throws InterruptedException {//标签名称
        webDriver.get("http://www.baidu.com");
        WebElement kw = webDriver.findElement(By.id("kw"));
        String tagName = kw.getTagName();
        System.out.println(tagName);
    }

    @Test
    public void getAttributeTest(){//获取元素属性值
        webDriver.get("http://www.baidu.com");
        WebElement su = webDriver.findElement(By.id("su"));
        String value = su.getAttribute("value");
        System.out.println(value);
        Assert.assertEquals(value,"百度一下");


    }

    @Test
    public void isDisplayedTest(){//判断元素是否展示
        webDriver.get("http://www.baidu.com");
        WebElement su = webDriver.findElement(By.id("su"));

        boolean bool = su.isDisplayed();
        System.out.println(bool);
        Assert.assertTrue(bool);


    }

    @Test
    public void shotTest(){//截图
        webDriver.get("http://www.baidu.com");
        File file = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\shot\\TakesScreenshot.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //判断单选框是否被选中isSelected()
    @Test
    public void isSelectedTest(){
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\index.html");
        boolean selected = webDriver.findElement(By.xpath(".//*[@id='radio']/input[1]")).isSelected();
        Assert.assertFalse(selected,"校验单选框未被选中");
    }
    //判断元素是否被激活isEnabled() 例如输入8位以上密码，提交按钮才能提交不灰显
    @Test
    public  void isEnabledTest(){
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\index.html");
        boolean bl = webDriver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(bl,"校验输入框为不可输入状态");

    }
    //D:\百度网盘\web自动\Web自动化selenium+java\index.html


    @AfterMethod
    public void closeDriver(){//关闭浏览器
        webDriver.quit();
    }

}
