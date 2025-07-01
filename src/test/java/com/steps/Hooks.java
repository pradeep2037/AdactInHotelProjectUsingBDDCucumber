package com.steps;

import com.base.BaseTest;
import com.pages.BasePage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class Hooks extends BaseTest {
	
	BasePage page;
	
	
	@After
	public void tearDown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}

}
