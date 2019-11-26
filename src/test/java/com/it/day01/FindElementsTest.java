package com.it.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementsTest {
    WebDriver webDriver;
    @BeforeMethod
    public void openChrome() {
        System.setProperty("webdriver.chrome.driver", "E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void byIdTest(){
        webDriver.get("http://www.baidu.com");
        WebElement kw = webDriver.findElement(By.id("kw"));
    }
    @Test
    public void byNameTest(){
        webDriver.get("http://www.baidu.com");
        WebElement wd = webDriver.findElement(By.name("wd"));

    }

    @Test
    public void byClassTest(){//元素定位方式
        webDriver.get("http://www.baidu.com");
        WebElement bg = webDriver.findElement(By.className("s_ipt"));

    }
    @Test
    public void byLinkTextTest(){
        webDriver.get("http://www.baidu.com");
        WebElement lk = webDriver.findElement(By.linkText("hao123"));

    }

    @Test
    public void byPartLinkTextTest(){
        webDriver.get("http://www.baidu.com");
        WebElement plk = webDriver.findElement(By.partialLinkText("hao"));

    }

    //tagname 几乎不用
    @Test
    public void byXPathTest(){
        webDriver.get("http://www.baidu.com");
        WebElement xkw = webDriver.findElement(By.xpath(".//*[@id='kw']"));

    }

    @Test
    public void byXPathTest02(){//返回元素列表
        webDriver.get("http://www.baidu.com");
        List<WebElement> elements = webDriver.findElements(By.xpath("//*[@id='u1']/a"));
        /*String text = elements.get(0).getText();
        System.out.println(text);*/
        for (WebElement element : elements) {
            System.out.println(element.getText());

        }


    }

    @Test
    public void cssSelectorTest(){
        webDriver.get("http://www.baidu.com");
        WebElement css = webDriver.findElement(By.cssSelector("#lg>map>area"));

    }

    @AfterMethod
    public void closeDriver(){//关闭浏览器
        webDriver.quit();
    }


}
