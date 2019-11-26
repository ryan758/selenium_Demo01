package com.it.day02;

import javafx.scene.input.KeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class ActionsTest {
    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//全局等待,10秒内没找到等待，超时后也执行
    }
    @Test
    public void RightClickTest(){//右键单击
        webDriver.get("http://www.baidu.com");
        WebElement button = webDriver.findElement(By.id("su"));
        //创建actions对象
        Actions actions = new Actions(webDriver);
        //右键点击对象
        actions.contextClick(button).perform();

    }
    @Test
    public void DoubleClickTest() throws InterruptedException {//双击
        webDriver.get("http://www.baidu.com");
        WebElement button = webDriver.findElement(By.id("su"));
        Thread.sleep(3000);
        //创建actions对象
        Actions actions = new Actions(webDriver);
        //右键点击对象
        actions.doubleClick(button).perform();

    }

    @Test
    public void MoveToTest() throws InterruptedException {//鼠标移到元素上
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement element = webDriver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).perform();
        Thread.sleep(3000);

    }

    //dragAndDrop.html
    @Test
    public void dragTest() throws InterruptedException {//拖动元素
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        WebElement drag = webDriver.findElement(By.id("drag"));
        Actions actions = new Actions(webDriver);
        Thread.sleep(3000);
        actions.dragAndDropBy(drag,500,500).perform();

    }
    ///html/body/h1
    @Test
    public void dragTest2() throws InterruptedException {//拖动元素到指定元素位置
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\dragAndDrop.html");
        WebElement drag = webDriver.findElement(By.id("drag"));
        WebElement element = webDriver.findElement(By.xpath("/html/body/h1"));
        Actions actions = new Actions(webDriver);
        Thread.sleep(3000);
        actions.clickAndHold(drag).moveToElement(element).release(drag).perform();


    }

    @Test
    public void MultiSelectTest() throws InterruptedException {//下拉框多选
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement multiple = webDriver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> elements = webDriver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Thread.sleep(3000);
        Actions actions = new Actions(webDriver);
        actions.keyDown(Keys.CONTROL).click(elements.get(1)).click(elements.get(2)).keyUp(Keys.CONTROL).perform();

    }
    @Test
    public void RobotTest() throws AWTException, InterruptedException {//键盘按键保存页面,字符转换成int即转换成ASCII码如a --97
        webDriver.get("http://www.baidu.com");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        //robot.keyPress(KeyEvent.VK_S);//参数是ascii码
        int s = (int)new Character('s');
        robot.keyPress(s);

        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);

        robot.keyRelease(KeyEvent.VK_CONTROL);//释放按键
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_ENTER);


    }

    @Test
    public void uploadTest() throws InterruptedException {//文件上传
        webDriver.get("D:\\百度网盘\\web自动\\Web自动化selenium+java\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement load = webDriver.findElement(By.id("load"));
        //D:\logo.png
        load.sendKeys("D:\\logo.png");//文件路径

        Thread.sleep(5000);

    }


    @AfterMethod
    public void closeDriver() throws InterruptedException { //关闭浏览器
        Thread.sleep(3000);
        webDriver.quit();
    }
}
