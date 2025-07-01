package com.steps;

import com.pages.BasePage;
import com.pages.SearchHotelPage;
import com.steps.ExtentHooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchHotelSteps {

	BasePage page = LoginSteps.page;

	@When("user selects hotel location as {string} {string}")
	public void user_selects_hotel_location_as(String logicalName, String text) {
		try {
			page.dropDown(logicalName, text);
			page.selectedHotellocation = text;
			ExtentHooks.scenarioTest.get().pass("Selecting hotel location: "+text);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("Failed to select hotel location: "+e.getMessage());
			System.err.println("❌ Failed to select hotel location: " + e.getMessage());
			throw e;
		}
	}

	@When("user selects hotel as {string} {string}")
	public void user_selects_hotel_as(String logicalName, String text) {
		try {
			page.dropDown(logicalName, text);
			ExtentHooks.scenarioTest.get().pass("Selected hotel: "+text);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("Failed to select hotel:" + e.getMessage());
			System.err.println("❌ Failed to select hotel: " + e.getMessage());
			throw e;
		}
	}

	@When("user selects hotel room type as {string} {string}")
	public void user_selects_hotel_room_type_as(String logicalName, String text) {
		try {
			page.dropDown(logicalName, text);
			page.typeRoom = text;
			System.out.println("selected roomtype : "+ text);
			ExtentHooks.scenarioTest.get().pass("Selected room type: "+text);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("Failed to select room type: " + e.getMessage());
			System.err.println("❌ Failed to select room type: " + e.getMessage());
			throw e;
		}
	}

	@When("user selects number of rooms {string} {string}")
	public void user_selects_number_of_rooms(String logicalName, String text) {
		try {
			page.dropDown(logicalName, text);
			page.numRooms = text;
			ExtentHooks.scenarioTest.get().pass("Selected number of rooms: "+text);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("Failed to select number of rooms: " + e.getMessage());
			System.err.println("❌ Failed to select number of rooms: " + e.getMessage());
			throw e;
		}
	}

	@When("user enters checkIn date as {string} {string}")
	public void user_enters_check_in_date_as(String logicalName, String text) {
		try {
			page.dateClearBeforeEnter(logicalName);
			page.enterText(logicalName, text);
			page.checkInDate = text;
			ExtentHooks.scenarioTest.get().pass("Entered check-in date: "+text);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("Failed to enter check-in date: " + e.getMessage());
			System.err.println("❌ Failed to enter check-in date: " + e.getMessage());
			throw e;
		}
	}

	@When("user enters checkOut date as {string} {string}")
	public void user_enters_check_out_date_as(String logicalName, String text) {
		try {
			page.dateClearBeforeEnter(logicalName);
			page.enterText(logicalName, text);
			page.checkOutDate = text;
			ExtentHooks.scenarioTest.get().pass("Entered check-out date: "+text);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("Failed to enter check-out date: " + e.getMessage());
			System.err.println("❌ Failed to enter check-out date: " + e.getMessage());
			throw e;
		}
	}

	@When("user selects number of adults per room {string} {string}")
	public void user_selects_number_of_adults_per_room(String logicalName, String text) {
		try {
			page.dropDown(logicalName, text);
			ExtentHooks.scenarioTest.get().pass("Selected number of adults per room: "+text);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("Failed to select adults per room: " + e.getMessage());
			System.err.println("❌ Failed to select adults per room: " + e.getMessage());
			throw e;
		}
	}

	@When("user clicks  on search button {string}")
	public void user_clicks_on_search_button(String text) {
		try {
			page.click(text);
			ExtentHooks.scenarioTest.get().pass("Clicked on search button: " + text);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("Failed to click search button: " + e.getMessage());
			System.err.println("❌ Failed to click search button: " + e.getMessage());
			throw e;
		}
	}

	@Then("system should show error like {string} {string}")
	public void system_should_show_error_like(String logicalName, String expectedText) {
		try {
			page.systemShowingErrorMessages(logicalName, expectedText);
			ExtentHooks.scenarioTest.get().pass("Verified error message: " + expectedText);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get().fail("Error message validation failed: " + e.getMessage());
			System.err.println("❌ ERROR during assertion: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}
}
