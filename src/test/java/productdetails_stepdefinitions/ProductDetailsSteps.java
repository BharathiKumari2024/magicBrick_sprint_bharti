package productdetails_stepdefinitions;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import com.pages.Landing_page;
import com.pages.ProductDetails_page;
import com.pages.ProductList_page;
//import com.sun.org.apache.bcel.internal.classfile.Utility;
import com.utility.Utility;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductDetailsSteps extends Utility {
	public Landing_page ldp;
	public ProductList_page plp;
	public ProductDetails_page pdp;

	public void objectMethod() throws IOException {

		ldp = new Landing_page();
		plp = new ProductList_page();
		pdp = new ProductDetails_page();

	}
	
	//Scenario 1
	//Validating the Landing page title
	@Given("chrome is opened and magicbricks app is opened")
	public void chrome_is_opened_and_magicbricks_app_is_opened() throws IOException, InterruptedException {
		objectMethod();
		logger = report.createTest("test01");
		logger.log(Status.INFO, "Validating landing page title");
		String actualTitle = ldp.validateLandinPageTitle();
		String expectedtitle = "Real Estate | Property in India | Buy/Sale/Rent Properties | MagicBricks";
		try {
			assertEquals(actualTitle, expectedtitle);
			logger.log(Status.PASS, "Step1 is passed");
			System.out.println(actualTitle);
			assert true;
		} catch (AssertionError e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Step1 is failed");
			captureScreenshotOnFailure();
			assert false;
		}
	}
	
	//Enter the location
	@When("User enters {string} in AddMore field")
	public void user_enters_in_addmore_field(String location) throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		ldp.validateAddMore(location);
		Thread.sleep(3000);
		logger.log(Status.INFO, "Step2 is executed");
	}

	@And("User clicks on Location")
	public void user_clicks_on_location() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		ldp.validateSearchButton();
		Thread.sleep(3000);
		logger.log(Status.INFO, "Step3 is executed");

	}

	@Then("User navigates to ProductList page")
	public void user_navigates_to_product_list_page() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		
		boolean logoCheck=plp.checkmagicbricksLogo();
        assertTrue(logoCheck);
        System.out.println(logoCheck);
        Thread.sleep(3000);
        logger.log(Status.INFO, "Step4 is executed");
        Thread.sleep(3000);
	}

	@When("User clicks on any product")
	public void user_clicks_on_any_product() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		plp.validateTitleLink();
		Thread.sleep(3000);
		logger.log(Status.INFO, "Step5 is executed");
	}

	@Then("User navigates to ProductDetails page")
	public void user_navigates_to_product_details_page() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		Utility.WindowHandle();
		pdp.scroll();
		Thread.sleep(3000);
		logger = report.createTest("test02");
		logger.log(Status.INFO, "Validating landing page title");
		String actualText = pdp.validateOthertext();
		String expectedText = "Other Properties in this Project and Nearby";
		try {
			assertEquals(actualText, expectedText);
			logger.log(Status.PASS, "Step6 is passed");
			System.out.println(actualText);
			assert true;
		} catch (AssertionError e) {
			e.printStackTrace();
			logger.log(Status.FAIL, "Step6 is failed");
			captureScreenshotOnFailure();
			assert false;
		}
	}
	//Scenario 2

	@Then("ProductDetails fields are visible to user")
	public void product_details_fields_are_visible_to_user() throws Exception {
		objectMethod();
		Utility.implicitWait();
		pdp.captureScreenshot();
		Thread.sleep(3000);
   	    logger.log(Status.INFO, "Step7 is executed");
	}
	
	//Scenario 3
	@Then("User is able to click on Download brochure button")
	public void user_is_able_to_click_on_download_brochure_button() throws IOException, InterruptedException {
		objectMethod();
		Utility.implicitWait();
		//Utility.WindowHandle();
		pdp.validatecontactbutton();
		Thread.sleep(3000);
		logger.log(Status.INFO, "Step8 is executed");
	}

}
