
package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Baseclass {
	
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	@BeforeTest
	public void reportSetup() {
		report=new ExtentReports("ExtentReport.html");
	}
	@BeforeMethod
    public void setup() {
	System.setProperty("webdriver.chrome.driver","chromedriver");
    driver=new ChromeDriver();
    driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);	
    }
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@AfterTest
public void ReportTearDown() {
		report.flush();
		report.close();
	}

}
