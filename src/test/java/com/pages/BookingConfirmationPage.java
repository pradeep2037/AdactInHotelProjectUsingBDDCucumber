package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BaseTest;

public class BookingConfirmationPage extends BasePage {

	public BookingConfirmationPage() {
		super(driver = BaseTest.getDriver());
		
		addKeyValuePairs("logout", By.xpath("//a[text()='Logout']"));
	}
}
