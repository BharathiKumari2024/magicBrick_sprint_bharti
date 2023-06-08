package testrunner;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/Features/productdetails_excel.feature"},
		glue = {"productdetails_stepdefinitions_excel", "apphooks"},
				 plugin= {"pretty" ,
						 "html:target/creport/cucumber",
						 "json:target/creport/cucumber.json",
				 		 "junit:target/creport/cucumber.xml"}
		
		)

public class ProductDetails_TestRunner_excel extends AbstractTestNGCucumberTests {

}
