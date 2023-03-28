package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TrainingTest {
	
	private static String url = "https://www.amazon.in/";
	private static String amazonMiniTV = "//a[text()='Amazon miniTV']";
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = launchBrowser();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Waits for every element for 5 secs till it is found
		
		// Launching amazon
		driver.get(url);
		
		// Waiting for search input box on the app
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(amazonMiniTV)));
				
		// driver.findElement(By.xpath(amazonMiniTV)).click();
		WebElement amazonMiniTVElement = driver.findElement(By.xpath(amazonMiniTV));
		
		WebElement aboutUs = driver.findElement(By.xpath("//a[text()='About Us']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", aboutUs);
		
	}
	
	public static WebDriver launchBrowser()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}
}
