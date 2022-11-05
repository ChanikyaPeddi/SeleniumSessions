package exercise;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.test.BrowserUtil;

public class TotalLinks {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		// maintaining By locator
		By links = By.tagName("a");
		By images = By.tagName("IMG");
		getAttributeList(images, "alt");
		getAttributeList(links, "class");
		System.out.println("Total links : " + noOfLinks(images));
		System.out.println("Total links : " + noOfLinks(links));

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	public static int noOfLinks(By locator) {
		return getElements(locator).size();
	}

	public static List<String> getAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<>();
		for (WebElement e : eleList) {
			String eleAttrVal = e.getAttribute(attrName);
			System.out.println(eleAttrVal);
			eleAttrList.add(eleAttrVal);

		}
		return eleAttrList;

	}
}
