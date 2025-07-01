package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BaseTest;

public class SearchHotelPage extends BasePage{

	public SearchHotelPage() {
		super(driver = BaseTest.getDriver());
		
		addKeyValuePairs("location", By.xpath("//select[@id='location']"));
		addKeyValuePairs("hotel", By.xpath("//select[@id='hotels']"));
		addKeyValuePairs("roomtype", By.xpath("//select[@id='room_type']"));
		addKeyValuePairs("rooms", By.xpath("//select[@id='room_nos']"));
		addKeyValuePairs("checkIn", By.xpath("//input[@name='datepick_in']"));
		addKeyValuePairs("checkOut", By.xpath("//input[@name='datepick_out']"));
		addKeyValuePairs("adults", By.xpath("//select[@id='adult_room']"));
		addKeyValuePairs("searchButton", By.xpath("//input[@id='Submit']"));
		addKeyValuePairs("error", By.xpath("//span[@id='checkin_span']"));
	}
}



