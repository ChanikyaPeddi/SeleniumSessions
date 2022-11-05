package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import selenium.test.BrowserUtil;
import selenium.test.ElementUtil;

public class SelectorsHub {
	static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		BrowserUtil br = new BrowserUtil();
		br.launchUrl("https://selectorshub.com/xpath-practice-page/");
		br.windowSettings();
		
		//By locators
		By emaiId= By.cssSelector("#userId");
		
		ElementUtil util = new ElementUtil(driver);
		util.getElement(null)
	}

}
