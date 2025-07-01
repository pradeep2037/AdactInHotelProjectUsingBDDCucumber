package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {
		"com.steps" }, monochrome = true, stepNotifications = true, tags = "@test10")
public class Runner {

}

