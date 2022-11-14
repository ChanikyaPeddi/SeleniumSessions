package exercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");

		By customers = By.linkText("Amazon Science11");
		//retryElement(customers, 10, 500);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(customers)).click();
		
		Wait<WebDriver> wait1 =new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofSeconds(500))
				.withMessage("elemetn not present")
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
						;
				
	}
	

	public static WebElement retryElement(By locator, int timeOut, int pollingTime) {

		WebElement element = null;
		int attempts = 0;

		while (attempts < timeOut) {
			try {
				driver.findElement(locator);
				break;
			} catch (NoSuchElementException e) {
				System.out.println("There is no element at attempt: " + attempts + " for " + locator);
				try {
					Thread.sleep(pollingTime);
				} catch (InterruptedException e1) {
					e1.printStackTrace();

				}
			}
			attempts++;
		}
		if (element == null) {
			try {
				throw new Exception("Element not found");
			} catch (Exception e) {
				System.out.println("element is not found exception....tried for : " + timeOut + " secs"
						+ " with the interval of : " + pollingTime + " ms ");
			}
		}
		return element;

	}

}
