package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TrainingBase;
import pom.HomePage;

public class TrainingTestCases {
	
	TrainingTestCases tc;
	TrainingBase base;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() // This is used to launch browser
	{
		tc = new TrainingTestCases();
		base = new TrainingBase();
		driver = base.initialize();
	}
	
	@Test
	public void amazonSearchAndValidateProduct() // This is a test case
	{
		SoftAssert sAssert = new SoftAssert();
			
		HomePage home = new HomePage(driver);
		home.searchAmazonFor(driver,"mouse");
		boolean productExists = home.productExists(driver);
		sAssert.assertEquals(productExists, true);
		
		System.out.println("productExists = "+productExists);
		
		sAssert.assertAll(); // Assertion check is taken care
		System.out.println("Added a new line");
	}	

	
	@AfterMethod
	public void tearDown() // This is used to shut down browser
	{
		driver.quit();
	}

}
