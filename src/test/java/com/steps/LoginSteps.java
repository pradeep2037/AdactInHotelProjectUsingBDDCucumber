package com.steps;

import com.base.BaseTest;
import com.pages.BasePage;
import com.pages.BookHotelPage;
import com.pages.BookingConfirmationPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;
import com.steps.ExtentHooks;
import com.utils.UtilKit;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseTest {

	public static BasePage page;
	
	@Given("user should launch the application")
	public void user_should_launch_the_application() {
		try {
			launchApplication();
			ExtentHooks.scenarioTest.get().pass("✅ Launched the application");
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("❌ Failed to launch the application: " + e.getMessage());
			System.err.println("❌ Failed to launch the application: " + e.getMessage());
			throw e;
		}
	}

	@Given("user should be on {string}")
	public void user_should_be_on(String pageName) {
	    try {
	        switch (pageName) {
	        case "LoginPage":
	            page = new LoginPage();
	            break;
	        case "SearchHotelPage":
	            page = new SearchHotelPage();
	            break;
	        case "SelectHotelPage":
	            page = new SelectHotelPage();
	            break;
	        case "BookHotelPage":
	            page = new BookHotelPage();
	            break;
	        case "BookingConfirmationPage":
	            page = new BookingConfirmationPage();
	            break;
	        default:
	            throw new IllegalArgumentException("❌ Unknown page: " + pageName);
	        }
	        System.out.println("✅ Initialized page object: " + pageName);
	        ExtentHooks.scenarioTest.get().pass("📌 Navigated to page: " + pageName);
	    } catch (Exception e) {
	        ExtentHooks.scenarioTest.get()
	            .fail("❌ Failed to initialize page object for: " + pageName + " - " + e.getMessage());
	        System.err.println("❌ Failed to initialize page object for: " + pageName + " - " + e.getMessage());
	        throw e;
	    }
	}


	@When("user enters the username in the username filed {string} {string}")
	public void user_enters_the_username_in_the_username_filed(String logicalName, String text) {
		try {
			page.enterText(logicalName, text);
			ExtentHooks.scenarioTest.get()
					.pass("📌 [ACTION] Entered username: '" + text + "' in field: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("❌ Failed to enter username: " + e.getMessage());
			throw e;
		}
	}

	@When("user enters the password in the password field {string} {string}")
	public void user_enters_the_password_in_the_password_field(String logicalName, String text) {
		try {
			page.enterText(logicalName, text);
			ExtentHooks.scenarioTest.get().pass("📌 [ACTION] Entered password in field: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("❌ Failed to enter password: " + e.getMessage());
			throw e;
		}
	}

	@When("user should click on button {string}")
	public void user_should_click_on(String logicalName) throws Exception {
		util = new UtilKit();
		try {
			page.click(logicalName);
			Thread.sleep(5000);
			ExtentHooks.scenarioTest.get().pass("📌 [ACTION] Clicked on login button: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("❌ Failed to click login button: " + e.getMessage());
			throw e;
		}
	}

	@Then("user should navigate to the search hotel page successfully {string}")
	public void user_should_navigate_to_the_search_hotel_page_successfully(String title) {
		try {
			page.validateTitle(title);
			ExtentHooks.scenarioTest.get().pass("✅ Validated the page title: " + title);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("❌ Page title validation failed: " + e.getMessage());
			throw e;
		}
	}
}
