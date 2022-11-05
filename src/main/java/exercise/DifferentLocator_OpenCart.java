package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.test.BrowserUtil;
import selenium.test.ElementUtil;

public class DifferentLocator_OpenCart {

	
	public static void main(String[] args) {
		
		BrowserUtil br = new BrowserUtil();
		WebDriver driver =br.init_driver("chrome");
		br.launchUrl("https://opencart.antropy.co.uk/index.php?route=account/register");
		br.windowSettings();
		System.out.println(br.getPageTitle());
		System.out.println(br.getPageUrl());
		
		//fill register form 
		By firstName = By.id("input-firstname");
		By lastName = By.xpath("//*[@id=\"input-lastname\"]");
		By email = By.cssSelector("#input-email");
		By teleNum=By.name("telephone");
		By pass = By.id("input-password");
		By cPass= By.xpath("//*[@id=\"input-confirm\"]");
		By sub = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input");
		By agreeBtn = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");
		By submitBtn = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(firstName, "Chanikya");
		eleUtil.doSendKeys(lastName, "Test");
		eleUtil.doSendKeys(email, "Chanikya@test.com");
		eleUtil.doSendKeys(teleNum, "999999999");
		eleUtil.doSendKeys(pass, "1234abcd");
		eleUtil.doSendKeys(cPass, "1234abcd");
		eleUtil.doClick(sub);
		eleUtil.doClick(agreeBtn);
		eleUtil.doClick(submitBtn);
		
		
		
		
		
		
		

	}

}
