package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import com.utility.Utility;

public class ProductDetails_page extends Utility {
	
	@FindBy(xpath="//*[@class='mb-header__main__section__right']")
	WebElement division;
	
	@FindBy(xpath="//span[text()='Download Brochure']")
	//@FindBy(xpath="//*[@id=\"propertyDetail\"]/div[4]/div[2]/div/div/div[2]/section[2]/span")
	WebElement Contact; //download brochure
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement name;
	
	@FindBy(xpath="//input[@id = 'userEmail']")
	WebElement email;
	
	@FindBy(xpath="//input[@name= 'userMobile']")
	WebElement mobile;
	
	@FindBy(xpath="//button[@class='contact-form__btn']")
	WebElement submit;//this is the button at download brochure page 
	
	@FindBy(xpath="//div[text()='Please enter valid Email Id.']")
    private WebElement invalidMessageCheck;
	
	@FindBy(xpath="//div[text()='Other Properties in this Project and Nearby']")
    private WebElement Othertext;
	

	public ProductDetails_page() throws IOException
	{
		PageFactory.initElements(driver, this);
	
	} 
	public String validateProductDetailsPageTitle()
	{
		return driver.getTitle(); 
	} 
	
	public void validateUI() {
		division.isDisplayed();
	}
	
	//Download brochure button	
	public void validatecontactbutton() {
		Contact.click();
	}
	
	public void submit() {
		submit.click();
	}
	
	public String textCapture()
    {
         return invalidMessageCheck.getText();
    }
	
	public void entername(String str) {
		name.sendKeys(str);
	}
	public void enteremail(String mail) {
		email.sendKeys(mail);
	}
	public void entermobile(String mob) {
		mobile.sendKeys(mob);
	}
	public String validateOthertext()
    {
         return Othertext.getText();
    }
	public void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,1200)");
    }
	
	public void captureScreenshot() throws Exception {

		Date currentDate = new Date();

		String screenshotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File binaryFile = ts.getScreenshotAs(OutputType.FILE);

		//Make sure screenshots folder is already created at the project level

		File imageFile = new File(screenshotsPath + screenshotFileName + ".png");

		FileUtils.copyFile(binaryFile, imageFile);

		}
	
}
