package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.test.BrowserUtil;
import selenium.test.ElementUtil;

public class IkeaAppTest {

	public static void main(String[] args) throws InterruptedException {

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver =	brUtil.init_driver("chrome");
		
		brUtil.launchUrl("https://www.ikea.com/sa/en/profile/signup/");
		brUtil.windowSettings();
		System.out.println(brUtil.getPageTitle());
		System.out.println(brUtil.getPageUrl());
		
		
		By firstName = By.id("regular-signup-form-firstName");
		By lastName=By.id("regular-signup-form-lastName");
		By mobileNo=By.id("regular-signup-form-mobile");
		By email = By.id("regular-signup-form-username");
		By password = By.id("regular-signup-form-password");
		
		ElementUtil eleUtil =  new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Chanikya");
		eleUtil.doSendKeys(lastName, "Lastname");
		eleUtil.doSendKeys(mobileNo, "99999999999");
		eleUtil.doSendKeys(email, "chaniya@ikea.com");
		eleUtil.doSendKeys(password, "Chanikya");
		
		Thread.sleep(3000);
		brUtil.quitBrowser();
		
		

	}

}
