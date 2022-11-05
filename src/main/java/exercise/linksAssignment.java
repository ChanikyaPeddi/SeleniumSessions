package exercise;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class linksAssignment {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opencart.antropy.co.uk/index.php?route=account/login");
		//driver.get("https://www.google.co.in/");
		Thread.sleep(2000);
		//Google footer
		//By footerXpath = By.xpath("//div[@class='KxwPGc AghGtd']/a");
		//opencart links
		By links= By.xpath("//div[@class='list-group']/a");
		
		getFooterLinks(links, "href");
	}

	public static void getFooterLinks(By locator,  String attrName) {
		List<WebElement> footerLinks = driver.findElements(locator);
		List<String> footerAttrVal = new ArrayList<String>();
		int linksSize = footerLinks.size();
		System.out.println(linksSize);
		for (WebElement e : footerLinks) {
			String linkText = e.getText();
			System.out.println(linkText);
			String attr= e.getAttribute(attrName);
			System.out.println(attr);
			footerAttrVal.add(attr);

		}
	}

}
