package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDown {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Select class must be used when there is a select tag in HTMl code.
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/contact-sales/");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		By country = By.id("Form_getForm_Country");
		By employees = By.id("Form_getForm_NoOfEmployees");

		// 1st method:
		//Select select = new Select(driver.findElement(country));
		//select.selectByIndex(5);
		//select.selectByVisibleText("India");
		//select.selectByValue("American Samoa");
		//Thread.sleep(3000);

		//Select select1 = new Select(driver.findElement(employees));
		//select1.selectByIndex(6);

		// 2nd method - create a generic function so there will be no boiler plate codee
		selectDropDownByVisibleText(country, "India");
		selectDropDownByIndex(employees, 5);
		
	}

	public static WebElement getElemeent(By locator) {
		return  driver.findElement(locator);
	}
	public static void selectDropDownByIndex(By locator, int index) {
		Select select=new Select(getElemeent(locator));
		select.selectByIndex(index);
	}
	public static void selectDropDownByVisibleText(By locator, String text) {
		Select select =new Select(getElemeent(locator));
		select.selectByVisibleText(text);
	}
}
