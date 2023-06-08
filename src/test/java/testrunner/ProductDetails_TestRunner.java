package testrunner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/Features/productdetails1.feature"},
		glue = {"productdetails_stepdefinitions", "apphooks"},
				 plugin= {"pretty" ,
						 "html:target/creport/cucumber",
						 "json:target/creport/cucumber.json",
				 		 "junit:target/creport/cucumber.xml"}
		
		)
public class ProductDetails_TestRunner extends AbstractTestNGCucumberTests{

}