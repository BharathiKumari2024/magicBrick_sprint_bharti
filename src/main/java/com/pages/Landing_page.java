package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Utility;

public class Landing_page extends Utility{
	
	@FindBy(xpath="//*[@id='keyword']")
	WebElement Add_More; 
	
	//@FindBy(xpath="//*[@id='serachSuggest']/div[2]/span")
	@FindBy(xpath="//span[text()='kolkata']")
	WebElement Location; 

	@FindBy(xpath="//*[@class='mb-search__btn']")
	WebElement SearchButton; 
	
	
	public Landing_page() throws IOException
	{
		PageFactory.initElements(driver, this);
	
	} 
	
	public String validateLandinPageTitle()
	{
		return driver.getTitle(); 
	} 
	public void validateAddMore(String loc) throws IOException {
		 Add_More.sendKeys(loc);
		
		
	}
	public void validateLocation() throws IOException {
		Location.click();
		
	}
	public ProductList_page validateSearchButton() throws IOException {
		SearchButton.click();
		return new ProductList_page();
	}
	

}
