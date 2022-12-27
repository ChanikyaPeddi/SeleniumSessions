package selenium.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooter {
	static WebDriver driver;
	private static String text;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		
		List<WebElement> headerList = driver.findElements(By.xpath("//div[@id='nav-xshop']//a"));
		
		System.out.println(headerList.size());
		/*
		 * for(int i= 0; i<=headerList.size();i++) { String text =
		 * headerList.get(i).getText(); System.out.println(text);
		 */
		
		for (WebElement e : headerList) {
			text = e.getText();
			if(text.equals("Computers")) {
				
				System.out.println(text);
				break;
			}
		}

	}		//getFooter("Make Money with Us");



	public static List<WebElement> getFooter(String footerName) {
		List<WebElement> footerList = driver
				.findElements(By.xpath("//div[text()='" + footerName + "']/parent::div//ul//a"));

		for (WebElement e : footerList) {
			String text = e.getText();
			System.out.println(text);
		}
		return footerList;

	}
}
