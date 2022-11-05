package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.test.BrowserUtil;
import selenium.test.ElementUtil;

public class HrmContactSales {

	public static void main(String[] args) {
		
		BrowserUtil brUtil =new BrowserUtil();
		WebDriver driver=brUtil.init_driver("chrome");
		
		brUtil.launchUrl("https://www.orangehrm.com/contact-sales/");
		System.out.println(brUtil.getPageTitle());
		System.out.println(brUtil.getPageUrl());
		
		By name=By.id("Form_submitForm_FullName");
		By companyName=By.id("Form_submitForm_CompanyName");
		By jobTitle=By.id("Form_submitForm_JobTitle");
		By phoneNo=By.id("Form_submitForm_Contact");
		By email=By.id("Form_submitForm_Email");
		By message=By.id("Form_submitForm_Comment");
		
		
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(name, "Chanikya");
		eleUtil.doSendKeys(companyName, "Capgemini");
		eleUtil.doSendKeys(jobTitle, "Test Engineer");
		eleUtil.doSendKeys(phoneNo, "7032526441");
		eleUtil.doSendKeys(email, "chanikya@test.com");
		eleUtil.doSendKeys(message, "This is a sample test to know about locator strategy By using Element util class");
		
		brUtil.quitBrowser();
		

	}

}
