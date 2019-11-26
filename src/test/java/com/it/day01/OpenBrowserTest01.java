package com.it.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest01 {

    /*@Test
    public void openFireFox(){
       WebDriver webDriver = new FirefoxDriver();//启动火狐浏览器 前提默认安装路径

    }*/

    @Test
    public void openFireFox2(){
        System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");//49以上版本
        WebDriver webDriver = new FirefoxDriver();//启动火狐浏览器自定义安装
        webDriver.get("http://www.baidu.com");
        webDriver.quit();
    }

    @Test
    public void openChrome1(){

        System.setProperty("webdriver.chrome.driver","E:\\selenium\\selenium_Demo01\\drivers\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();//启动谷歌浏览器可以传递参数 ,没有参数就是空浏览器
        webDriver.get("http://www.baidu.com");
        webDriver.quit();
    }
    @Test
    public void openIE(){

        System.setProperty("webdriver.ie.driver","D:\\百度网盘\\工具\\IEDriverServer.exe");
        WebDriver webDriver = new InternetExplorerDriver();//启动ie
        webDriver.get("http://www.baidu.com");
        webDriver.quit();
    }


}
