package com.script;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class Main {
	static ExtentTest test;
	static ExtentReports report;
	@BeforeClass
	public static void startTest()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"/test-output/Report1.html",true);
		test = report.startTest("ExtentDemo");
	}
	@Test
	public void extentReportsDemo()
	{
		System.setProperty("webdriver.chrome.driver","D:/Selenium/New/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.softwaretestingmaterial.com/generate-extent-reports/");
		if(driver.getTitle().equals("Google"))
		{
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		}
		else
		{
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}
	@AfterClass
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}
}