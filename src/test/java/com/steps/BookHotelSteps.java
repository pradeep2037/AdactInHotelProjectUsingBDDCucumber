package com.steps;

import com.pages.BasePage;
import com.pages.BookHotelPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookHotelSteps {

//	BasePage page = LoginSteps.page;

	@When("user should select the hotel {string}")
	public void user_should_select_the_hotel(String logicalName) {

		try {
			LoginSteps.page.selectingParticularHotel(logicalName);
			ExtentHooks.scenarioTest.get().pass("Successfully selected the hotel: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to select the hotel: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Hotel selection failed for: " + logicalName + " - " + e.getMessage());
			throw e;
		}
	}

	@Given("user should enter the first name {string} {string}")
	public void user_should_enter_the_first_name(String logicalName, String text) {
		try {
			LoginSteps.page.enterText(logicalName, text);
			ExtentHooks.scenarioTest.get().pass("Entered first name: " + text + " into: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to enter first name for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Error entering first name - " + e.getMessage());
			throw e;
		}
	}

	@Given("user should enter the last name {string} {string}")
	public void user_should_enter_the_last_name(String logicalName, String text) {
		try {
			LoginSteps.page.enterText(logicalName, text);
			ExtentHooks.scenarioTest.get().pass("Entered last name: " + text + " into: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to enter last name for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Error entering last name - " + e.getMessage());
			throw e;
		}
	}

	@Given("user should enter the billing address {string} {string}")
	public void user_should_enter_the_billing_address(String logicalName, String text) {
		try {
			LoginSteps.page.enterText(logicalName, text);
			ExtentHooks.scenarioTest.get().pass("Entered billing address: " + text + " into: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to enter billing address for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Error entering billing address - " + e.getMessage());
			throw e;
		}
	}

	@Given("user should enter the credit card num {string} {string}")
	public void user_should_enter_the_credit_card_num(String logicalName, String text) {
		try {
			LoginSteps.page.enterText(logicalName, text);
			ExtentHooks.scenarioTest.get().pass("Entered credit card number: " + text + " into: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to enter credit card number for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Error entering credit card number - " + e.getMessage());
			throw e;
		}
	}

	@Given("user should select credit card type {string} {string}")
	public void user_should_select_credit_card_type(String logicalName, String text) {
		try {
			LoginSteps.page.dropDown(logicalName, text);
			ExtentHooks.scenarioTest.get().pass("Selected credit card type: " + text + " from: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to select credit card type for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Error selecting credit card type - " + e.getMessage());
			throw e;
		}
	}

	@Given("user should select expiry date {string} {string} and {string} {string}")
	public void user_should_select_expiry_date_and(String logicalNameMonth, String monthText, String logicalNameYear,
			String yearText) {
		try {
			LoginSteps.page.dropDown(logicalNameMonth, monthText);
			LoginSteps.page.dropDown(logicalNameYear, yearText);
			ExtentHooks.scenarioTest.get().pass("Selected expiry month: " + monthText + ", year: " + yearText);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("❌ Failed to select expiry date - " + e.getMessage());
			System.err.println("❌ Error selecting expiry date - " + e.getMessage());
			throw e;
		}
	}

	@Given("user should enter cvv number {string} {string}")
	public void user_should_enter_cvv_number(String logicalName, String text) {
		try {
			LoginSteps.page.enterText(logicalName, text);
			ExtentHooks.scenarioTest.get().pass("Entered CVV number: " + text + " into: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to enter CVV number for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Error entering CVV number - " + e.getMessage());
			throw e;
		}
	}

	@Then("user should successfully logout from the application {string}")
	public void user_should_successfully_logout_from_the_application(String title) {
		try {
			LoginSteps.page.validateTitle(title);
			ExtentHooks.scenarioTest.get().pass("Successfully logged out and validated page title: " + title);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Logout or title validation failed for: " + title + " - " + e.getMessage());
			System.err.println("❌ Logout/title validation failed - " + e.getMessage());
			throw e;
		}
	}

	@Then("final price should include 10% GST so {string} must equals to {string}")
	public void final_price_should_include_gst(String totalPrice, String billedPrice) {
	    try {
	        LoginSteps.page.finalPriceWithGst(totalPrice, billedPrice);
	        ExtentHooks.scenarioTest.get().pass("Final price with GST validated successfully for keys: " + totalPrice + ", " + billedPrice);
	    } catch (Exception e) {
	        ExtentHooks.scenarioTest.get().fail("❌ Final price GST validation failed - " + e.getMessage());
	        System.err.println("❌ Error in GST validation step - " + e.getMessage());
	        throw e;
	    }
	}


}
