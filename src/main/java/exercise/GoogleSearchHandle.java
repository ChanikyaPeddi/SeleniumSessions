package exercise;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		Thread.sleep(3000);
		By doSugg = By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span");
		// doSuggestion(doSugg, "Selenium Testing");
		doSelectSuggestion(doSugg, "Selenium Testing", "selenium testing jobs");

	}

	public static List<String> doSuggestion(By locator, String searchKey) throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(searchKey);
		Thread.sleep(3000);
		List<WebElement> suggList = driver.findElements(locator);
		List<String> suggValList = new ArrayList<String>();
		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);

		}return suggValList;
	}

	public static void doSelectSuggestion(By locator, String searchKey, String suggVal) throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(searchKey);
		Thread.sleep(3000);
		List<WebElement> suggList = driver.findElements(locator);
		List<String> suggValList = new ArrayList<String>();
		for (WebElement e : suggList) {
			String text = e.getText();

			suggValList.add(text);
			if (text.contains(suggVal)) {
				e.click();
				break;
			}

		}

	}

}
