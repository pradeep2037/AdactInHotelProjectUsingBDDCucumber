package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BaseTest;

public class SelectHotelPage extends BasePage{

	public SelectHotelPage() {
		super(driver = BaseTest.getDriver());
		
		
		addKeyValuePairs("location", By.xpath("//table[@cellpadding='5']/child::tbody"));
		addKeyValuePairs("checkInDate", By.xpath("//table[@cellspacing='1']/child::tbody"));
		addKeyValuePairs("checkOutDate", By.xpath("//table[@cellspacing='1']/child::tbody"));
		addKeyValuePairs("numOfRooms", By.xpath("//table[@cellspacing='1']/child::tbody"));
		addKeyValuePairs("roomType", By.xpath("//table[@cellspacing='1']/child::tbody"));
		addKeyValuePairs("numOfDays", By.xpath("//table[@cellspacing='1']/child::tbody"));
		addKeyValuePairs("pricePerNight", By.xpath("//table[@cellspacing='1']/child::tbody"));
		addKeyValuePairs("totalPrice", By.xpath("//table[@cellspacing='1']/child::tbody"));
		addKeyValuePairs("selectHotel", By.xpath("//table[@cellspacing='1']/child::tbody"));
		addKeyValuePairs("continueButton", By.xpath("//input[contains(@id,'continue')]"));

	}
}


