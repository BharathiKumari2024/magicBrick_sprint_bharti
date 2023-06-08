package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class ProductList_page extends Utility{
	
	@FindBy(xpath="//*[@class='mb-srp__card--title']")
	WebElement title;
	
	@FindBy(xpath="//a[@data-testid='header-logo-link']")
	WebElement Logo;

	public ProductList_page() throws IOException
	{
		PageFactory.initElements(driver, this);
	
	} 
	public String validateProductlistpagetitle() {
	  return driver.getTitle(); 
	}
	public ProductDetails_page validateTitleLink() throws IOException {
		title.click();
		return new ProductDetails_page();
	}
	public boolean checkmagicbricksLogo() throws IOException
    {
         return Logo.isDisplayed();
    }

}
