package StepRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/Features" },
		 

		glue = { "com.stepdefinitions" }, plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" },

		monochrome = true, dryRun = false, publish = true)

public class TestRunner 
{

}


	
