package com.po.page;

import org.openqa.selenium.By;

public class LoginPage {//po 集中管理元素对象 方便维护,解耦 只需更改该成员变量即可
    //普通登录定位
    public static By accountLogin = By.id("switchAccountLogin");
    //email输入框定位方式
    public static By emailInput = By.name("email");
    //密码输入框定位方式
    public static By pwdInput = By.name("password");
    //登录按钮定位方式
    public static By loginButton = By.id("dologin");
    //去注册定位
    public static By registerLink = By.linkText("注册新帐号");

}
