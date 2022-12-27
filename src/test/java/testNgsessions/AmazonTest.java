package testNgsessions;


import org.testng.annotations.Test;

import org.testng.AssertJUnit;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {
	
	static WebDriver driver;
	
	
	@BeforeTest
	public void setUp() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.com");
	}
	
	@Test(priority = 1)
	public void pageTitleTest() {
		
		String title =driver.getTitle();
		System.out.println(title);
		AssertJUnit.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}
	@Test(priority = 3)
	public void pageUrlTest() {
		
		String url =driver.getCurrentUrl();
		System.out.println(url);
		AssertJUnit.assertTrue(url.contains("amazon"));
	}
	@Test(priority = 2)
	public void isSearchExist() {
		boolean flag =driver.findElement(By.id("twotabsearchtextbox")).isDisplayed();
		AssertJUnit.assertTrue(flag);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
