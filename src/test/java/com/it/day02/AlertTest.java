package com.it.day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {
    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    @Test
    public void alertTest() throws InterruptedException {//alert处理
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\index.html");
        webDriver.findElement(By.xpath("//*[@id=\"alert\"]/input")).click();

            Thread.sleep(3000);
            //获取alert弹窗
            Alert alert = webDriver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);//获取弹窗文本

        //点击确定按钮
            alert.accept();

    }

    //confirm处理
    @Test
    public void confirmTest() throws InterruptedException {
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\index.html");
        webDriver.findElement(By.xpath("//*[@id=\"confirm\"]/input")).click();
        Thread.sleep(3000);
        //webDriver.switchTo().alert().accept();//确定
        Alert alert = webDriver.switchTo().alert();//取消
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();

    }
    //prompt处理
    @Test
    public void promptTest() throws InterruptedException {
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\index.html");
        webDriver.findElement(By.xpath("//*[@id=\"prompt\"]/input")).click();
        Thread.sleep(3000);
        Alert prompt = webDriver.switchTo().alert();
        prompt.sendKeys("你好..........");//输入不了chrome浏览器bug
        Thread.sleep(3000);
        prompt.accept();
        Thread.sleep(3000);
        prompt.accept();
    }
    @Test
    public void iframeTest(){//frame嵌套页面
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        webDriver.switchTo().frame("aa");//控制权移交子页面
        webDriver.findElement(By.id("user")).sendKeys("输入元素了");//操作子页面元素
        webDriver.switchTo().defaultContent();//控制权交回顶部页面 回到默认内容页

    }









    @AfterMethod
    public void closeDriver(){//关闭浏览器
        webDriver.quit();
    }
}
