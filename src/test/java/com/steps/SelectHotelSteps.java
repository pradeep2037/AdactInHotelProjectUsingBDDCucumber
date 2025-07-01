package com.steps;

import com.pages.BasePage;

import io.cucumber.java.en.Then;

public class SelectHotelSteps {

	BasePage page = LoginSteps.page;

	@Then("Location displayed in Select Hotel should be the same as location selected in search hotel form {string}")
	public void location_displayed_in_select_hotel_should_be_the_same_as_location_selected_in_search_hotel_form(
			String logicalName) {
		try {
			page.loactionMatching(logicalName);
			ExtentHooks.scenarioTest.get().pass("Location matched successfully for logical name: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to validate location match for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Location matching failed for: " + logicalName + " - " + e.getMessage());
			throw e;
		}
	}

	@Then("CheckIn displayed in Select Hotel should be the same as location selected in search hotel form {string}")
	public void check_in_displayed_in_select_hotel_should_be_the_same_as_location_selected_in_search_hotel_form(
			String logicalName) {
		try {
			page.checkIn(logicalName);
			ExtentHooks.scenarioTest.get().pass("Check-in date matched successfully for: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to validate check-in date for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Check-in validation failed for: " + logicalName + " - " + e.getMessage());
			throw e;
		}
	}

	@Then("CheckOut displayed in Select Hotel should be the same as location selected in search hotel form {string}")
	public void check_out_displayed_in_select_hotel_should_be_the_same_as_location_selected_in_search_hotel_form_check_in(
			String logicalName) {
		try {
			page.checkOut(logicalName);
			ExtentHooks.scenarioTest.get().pass("Check-out date matched successfully for: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to validate check-out date for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Check-out validation failed for: " + logicalName + " - " + e.getMessage());
			throw e;
		}
	}

	@Then("selected rooms in search hotel page should be same as the rooms displayed in select hotel page {string}")
	public void selected_rooms_in_search_hotel_page_should_be_same_as_the_rooms_displayed_in_select_hotel_page(
			String logicalName) {
		try {
			page.numOfRooms(logicalName);
			ExtentHooks.scenarioTest.get().pass("Number of rooms matched successfully for: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to validate number of rooms for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Number of rooms validation failed for: " + logicalName + " - " + e.getMessage());
			throw e;
		}
	}

	@Then("selected RoomType in search hotel page should be same as the RoomType displayed in select hotel page {string}")
	public void selected_room_type_in_search_hotel_page_should_be_same_as_the_room_type_displayed_in_select_hotel_page(
			String logicalName) {
		try {
			page.roomType(logicalName);
			ExtentHooks.scenarioTest.get().pass("Room type matched successfully for: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to validate room type for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Room type validation failed for: " + logicalName + " - " + e.getMessage());
			throw e;
		}
	}

	@Then("Total price must equals to no. of days * room per night * room price per night {string}")
	public void total_price_must_equals_to_no_of_days_room_per_night_room_price_per_night(String logicalName) {
		try {
			page.totalPriceBasedOnAccomdation(logicalName);
			ExtentHooks.scenarioTest.get().pass("Total price matched successfully for: " + logicalName);
		} catch (Exception e) {
			ExtentHooks.scenarioTest.get()
					.fail("❌ Failed to validate total price for: " + logicalName + " - " + e.getMessage());
			System.err.println("❌ Total price validation failed for: " + logicalName + " - " + e.getMessage());
			throw e;
		}
	}


}
