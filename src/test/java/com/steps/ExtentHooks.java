package com.steps;

import com.aventstack.extentreports.*;
import com.base.BaseTest;
import com.utils.ExtentManager;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExtentHooks extends BaseTest{

    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

    @BeforeAll
    public static void setupReport() {
        extent = ExtentManager.getInstance();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest test = extent.createTest(scenario.getName());
        scenarioTest.set(test);
        launchApplication();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Step Screenshot");

            scenarioTest.get().fail("Step Failed")
                        .addScreenCaptureFromBase64String(((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BASE64), "Failure Screenshot");
        } 
//        else {
//            scenarioTest.get().pass("Step Passed");
//        }
    }

    @After
    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterAll
    public static void tearDownReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
