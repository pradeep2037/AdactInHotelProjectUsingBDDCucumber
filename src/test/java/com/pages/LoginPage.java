package com.pages;

import org.openqa.selenium.By;

import com.base.BaseTest;

public class LoginPage extends BasePage{

	public LoginPage() {
		super(driver = BaseTest.getDriver());
		
		addKeyValuePairs("username", By.xpath("//input[@id='username']"));
		addKeyValuePairs("password", By.xpath("//input[@id='password']"));
		addKeyValuePairs("loginButton", By.xpath("//input[@id='login']"));
		
	}
}
