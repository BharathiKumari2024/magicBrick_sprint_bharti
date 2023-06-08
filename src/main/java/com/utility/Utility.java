package com.utility;

import java.util.Properties;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.apache.commons.io.FileUtils;

public class Utility extends Config{
	static ConfigReader configReader = new ConfigReader();
	static Properties prop = configReader.init_prop();
	
	public static WebDriver launchingBrowser() {
		
		String browser = prop.getProperty("Browser");
		
		switch (browser) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			break;
	
			
		case "HTMLUNIT":
			driver = new HtmlUnitDriver();
			break;
			
		default:
			System.out.println("Browser is not supported");
		}
		return driver;
		

	}

	public static void browserMaximize() {
		driver.manage().window().maximize();
	}


	public static void pageLoad() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
		
	}

	public static void launchingApp() {
		driver.get(prop.getProperty("url"));
	}

	public static void closingBrowser() {
		driver.quit();
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
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
	
	//getReportInstance() method

    public static ExtentReports report = ExtentReporterManager.getReportInstance();

    public static ExtentTest logger;

 

    public static String getDate() {

        Date date = new Date();

        return date.toString().replaceAll(":", "-").replaceAll(" ", "_");

        }

    

    public void captureScreenshotOnFailure() throws IOException {

 

        //Make sure screenshots folder is already created at the project level

        TakesScreenshot ts = (TakesScreenshot) driver;

        File binaryFile = ts.getScreenshotAs(OutputType.FILE);

        String customizedFilePath = screenshotsPath + getDate() + ".png";

        File imageFile = new File(customizedFilePath);

        FileUtils.copyFile(binaryFile, imageFile);

        //Extent Report Method

        logger.addScreenCaptureFromPath(customizedFilePath);

    } //Comment captureScreenshot() method
    
    public static void WindowHandle() {
    	String mainWindowHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentpage = (String) it.next();
        String childpage = (String) it.next();
        driver.switchTo().window(childpage); 
    }

}
