package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.BaseTest;

public class BookHotelPage extends BasePage {

	public BookHotelPage() {
		super(driver = BaseTest.getDriver());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("🧱 Inside BookHotelPage Constructor");

		addKeyValuePairs("firstName", By.xpath("//input[contains(@id,'first_name')]"));
		System.out.println("🔑 Added locator for: firstName");

		addKeyValuePairs("lastName", By.xpath("//input[contains(@id,'last_name')]"));
		addKeyValuePairs("address", By.xpath("//textarea[contains(@id,'address')]"));
		addKeyValuePairs("cardNum", By.xpath("//input[contains(@id,'cc_num')]"));
		addKeyValuePairs("cardType", By.xpath("//select[contains(@id,'cc_type')]"));
		addKeyValuePairs("month", By.xpath("//select[contains(@id,'cc_exp_month')]"));
		addKeyValuePairs("year", By.xpath("//select[contains(@id,'cc_exp_year')]"));
		addKeyValuePairs("cvv", By.xpath("//input[contains(@id,'cc_cvv')]"));
		addKeyValuePairs("bookNowButton", By.xpath("//input[contains(@id,'book_now')]"));
		addKeyValuePairs("totalPrice", By.xpath("//input[contains(@id,'total_price_dis')]"));
		addKeyValuePairs("billedPrice", By.xpath("//input[contains(@id,'final_price_dis')]"));

		
		

	}
}
