package com.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseTest;
import com.utils.UtilKit;

public class BasePage extends BaseTest {

	public static WebDriver driver = null;
	UtilKit util = new UtilKit();

	public static String selectedHotellocation = null;
	public static String checkInDate = null;
	public static String checkOutDate = null;
	public static String numRooms = null;
	public static String typeRoom = null;

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
	}

	// adding objects(means test data) into the hashmap
	HashMap<String, By> keyValuePairs = new HashMap<String, By>();

	public void addKeyValuePairs(String logicalName, By by) {
		keyValuePairs.put(logicalName, by);
	}

	// Title Validation
	public void validateTitle(String title) {
		assertTrue(driver.getTitle().equals(title));
	}

	// entering text in the text field
	public void enterText(String logicalName, String text) {
		// driver.findElement(By.xpath(""));
		getElement(logicalName).sendKeys(text);
	}

	// clearing date before entering date
	public void dateClearBeforeEnter(String logicalName) {
		getElement(logicalName).clear();
	}

	// drop down
	public void dropDown(String logicalName, String text) {
		WebElement webElement = getElement(logicalName);
		Select select = new Select(webElement);
		select.selectByValue(text);
	}

	// system error messages
	public void systemShowingErrorMessages(String logicalName, String text) {
		String getElementText = getElement(logicalName).getText();
		assertTrue(getElementText.equals(text));
	}

	// clicking button
	public void click(String logicalName) {
		getElement(logicalName).click();
	}

	@SuppressWarnings("deprecation")
	public void loactionMatching(String logicaName) {

		List<WebElement> rows = driver.findElements(keyValuePairs.get(logicaName));

		WebElement row = rows.get(rows.size() - 1);
		List<WebElement> datas = row.findElements(By.tagName("td"));
		WebElement element = datas.get(2);
		List<WebElement> values = element.findElements(By.xpath("//input[contains(@id,'location')]"));

		WebElement location = values.get(values.size() - 2);
		assertTrue(BasePage.selectedHotellocation.equals(location.getAttribute("value")));
		System.out.println("Location : " + location.getAttribute("value"));
	}

	// checkIn date
	@SuppressWarnings("deprecation")
	public void checkIn(String logicalName) {
		WebElement table = getElement(logicalName);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		WebElement row = rows.get(rows.size() - 1);
		List<WebElement> tdData = row.findElements(By.tagName("td"));
		List<WebElement> values = tdData.get(4).findElements(By.xpath("//input[@type='text']"));

		String checkIn = values.get(3).getAttribute("value");
		assertTrue(checkInDate.equals(checkIn));
	}

	// checkOut date
	@SuppressWarnings("deprecation")
	public void checkOut(String logicalName) {
		WebElement table = getElement(logicalName);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		WebElement row = rows.get(rows.size() - 1);
		List<WebElement> tdData = row.findElements(By.tagName("td"));
		List<WebElement> values = tdData.get(5).findElements(By.xpath("//input[@type='text']"));

		String checkOut = values.get(4).getAttribute("value");
		assertTrue(checkOutDate.equals(checkOut));
	}

	// no of rooms selected
	@SuppressWarnings("deprecation")
	public void numOfRooms(String logicalName) {
		WebElement table = getElement(logicalName);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		WebElement row = rows.get(rows.size() - 1);
		List<WebElement> tdData = row.findElements(By.tagName("td"));
		List<WebElement> values = tdData.get(3).findElements(By.xpath("//input[contains(@name,'rooms')]"));
		WebElement rooms = values.get(values.size() - 2);

		String room = rooms.getAttribute("value");
		assertTrue(numRooms.equals(room.split(" ")[0]));
	}

	// roomType
	public void roomType(String logicalName) {
		WebElement table = getElement(logicalName);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		WebElement row = rows.get(rows.size() - 1);
		List<WebElement> tdData = row.findElements(By.tagName("td"));
		List<WebElement> values = tdData.get(7).findElements(By.xpath("//input[contains(@name,'room_type')]"));
		WebElement rooms = values.get(values.size() - 2);

		@Nullable
		String fetchedRoom = rooms.getAttribute("value");
		System.out.println("fetchedrrom : " + fetchedRoom);
		assertTrue(typeRoom.equals(fetchedRoom));
	}

	@SuppressWarnings("deprecation")
	public void totalPriceBasedOnAccomdation(String logicalName) {

		WebElement table = getElement(logicalName);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		WebElement row = rows.get(rows.size() - 1);
		List<WebElement> tdData = row.findElements(By.tagName("td"));

		// fetched no of days
		List<WebElement> noOfDays = tdData.get(6).findElements(By.xpath("//input[contains(@id,'no_days_')]"));
		WebElement fetchedDays = noOfDays.get(noOfDays.size() - 1);
		long days = Long.parseLong(fetchedDays.getAttribute("value").split(" ")[0]);

		// price per night
		List<WebElement> pricePerNight = tdData.get(8).findElements(By.xpath("//input[contains(@id,'price_night')]"));
		WebElement fetchedPerNightPrice = pricePerNight.get(pricePerNight.size() - 2);
		long perNightPrice = Long.parseLong(fetchedPerNightPrice.getAttribute("value").split(" ")[2]);

		// total price from the table
		List<WebElement> totalPrice = tdData.get(8).findElements(By.xpath("//input[contains(@id,'total_price_')]"));
		WebElement fetchedTotalPrice = totalPrice.get(totalPrice.size() - 1);
		long finalPrice = Long.parseLong(fetchedTotalPrice.getAttribute("value").split(" ")[2]);

		long priceTotal = Long.parseLong(BasePage.numRooms) * days * perNightPrice;

		Assert.assertEquals(finalPrice, priceTotal);
	}

	@SuppressWarnings("deprecation")
	public void finalPriceWithGst(String totalPrice, String billedPrice) {
		try {
			WebElement element = getElement(totalPrice);
			String finalPriceText = element.getAttribute("value").split(" ")[2]; // e.g. "$1234"
			long basePrice = Long.parseLong(finalPriceText);

			// Add 10% GST
			long expectedPriceWithGST = (long) (basePrice + (basePrice * 0.10));

			WebElement billPriceElement = getElement(billedPrice);
			String billedText = billPriceElement.getAttribute("value").split(" ")[2];
			long actualBilledPrice = Long.parseLong(billedText);

			Assert.assertEquals(expectedPriceWithGST, actualBilledPrice, 0.01); // delta for float comparison
			System.out.println("✅ Final billed price matches expected GST-included price.");
		} catch (Exception e) {
			System.err.println("❌ Error in finalPriceWithGst method: " + e.getMessage());
			throw e;
		}
	}

	// user selecting hotel
	public void selectingParticularHotel(String logicalName) {

		WebElement table = getElement(logicalName);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		WebElement row = rows.get(rows.size() - 1);
		List<WebElement> tdData = row.findElements(By.tagName("td"));
		List<WebElement> values = tdData.get(0).findElements(By.xpath("//input[contains(@id,'radiobutton')]"));
		WebElement value = values.get(values.size() - 2);
		value.click();
	}

	// getting element
	public WebElement getElement(String logicalName) {
		By by = keyValuePairs.get(logicalName);
		if (by == null) {
			System.err.println("❌ Locator not found for key: " + logicalName);
			System.err.println("✅ Available keys: " + keyValuePairs.keySet());
			throw new RuntimeException("Locator must be set");
		}
		WebElement webElement = driver.findElement(by);
		util.waitForElement(webElement);
		return webElement;
	}

}
