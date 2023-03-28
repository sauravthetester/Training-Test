package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import locators.HomePageLocators;

public class HomePage {

	// Mention all elements / actions in webpage
	
	WebDriver driver;
	HomePage homePage;
	
	public HomePage()
	{
		
	}
	
	public HomePage(WebDriver driverLocal)
	{
		this.driver = driverLocal;
	}
	
	public WebElement getSearchBox(WebDriver driver)
	{
		WebElement amazonSearchBox = driver.findElement(By.xpath(HomePageLocators.searchBoxLocator));
		return amazonSearchBox;
	}
	
	public void searchAmazonFor(WebDriver driver,String searchText)
	{
		homePage = new HomePage();
		homePage.getSearchBox(driver).sendKeys(searchText);
		homePage.getSearchBox(driver).sendKeys(Keys.ENTER);
	}
	
	public boolean productExists(WebDriver driver)
	{
		try 
		{
			driver.findElement(By.xpath(HomePageLocators.productImage));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
}
