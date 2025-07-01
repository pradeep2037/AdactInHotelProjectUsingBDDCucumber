//package com.steps;
//
//import com.pages.BasePage;
//import com.pages.LoginPage;
//import com.pages.SearchHotelPage;
//
//import io.cucumber.java.en.Given;
//
//public class CommonSteps {
//
//	BasePage page;
//
//	@Given("user should be on {string}")
//	public void user_should_be_on(String pageName) {
//		switch (pageName) {
//			case "LoginPage":
//				page = new LoginPage();
//				break;
//			case "SearchHotelPage":
//				page = new SearchHotelPage();
//				break;
//		}
//	}
//}
