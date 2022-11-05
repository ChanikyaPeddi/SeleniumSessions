package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorStrategy {

	static WebDriver driver;
	static String baseUrl = "https://www.orangehrm.com/orangehrm-30-day-trial/";

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(baseUrl);
		// 1st method : Direct : THis method directly hits the server. It is highly
		// recommended to not use this.
		// driver.findElement(By.id("Form_submitForm_subdomain")).sendKeys("Chanikya");

		// 2nd method - WebElement
		/*
		 * WebElement userName=driver.findElement(By.id("Form_submitForm_subdomain"));
		 * WebElement email=driver.findElement(By.id("Form_submitForm_Email"));
		 * WebElement telephone=driver.findElement(By.id("Form_submitForm_Contact"));
		 * 
		 * userName.sendKeys("Chanikya"); email.sendKeys("email123@test.com");
		 * telephone.sendKeys("999999999");
		 */
		// 3rd - By locator
		/*
		 * By username = By.id("Form_submitForm_subdomain"); By email =
		 * By.id("Form_submitForm_Email"); By telephone =
		 * By.id("Form_submitForm_Contact");
		 * 
		 * WebElement usernameBy=driver.findElement(username); WebElement emailBy =
		 * driver.findElement(email); WebElement teleBy =driver.findElement(telephone);
		 * 
		 * usernameBy.sendKeys("Chanikya"); emailBy.sendKeys("Test@test.com");
		 * teleBy.sendKeys("999999999");
		 */

		// 4th By locator with generic function
		/*
		 * By username = By.id("Form_submitForm_subdomain"); By email =
		 * By.id("Form_submitForm_Email"); By telephone =
		 * By.id("Form_submitForm_Contact");
		 * 
		 * getElement(username).sendKeys("chanikya");
		 * getElement(email).sendKeys("test@test.com");
		 * getElement(telephone).sendKeys("999999"); driver.quit();
		 */
		// 5th- By locator with generic function of webELement and action
//		By username = By.id("Form_submitForm_subdomain");
//		By email = By.id("Form_submitForm_Email");
//		By telephone = By.id("Form_submitForm_Contact");
//		sendKeys(username, "Chanikya");
//		sendKeys(email, "test@test.com");
//		sendKeys(telephone, "999999999");
//		System.out.println(username);

		// 6th method - By locator ElementUtil class that has generic methods
//		By username = By.id("Form_submitForm_subdomain");
//		By email = By.id("Form_submitForm_Email");
//		By telephone = By.id("Form_submitForm_Contact");
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		
//		eleUtil.sendKeys(username, "Chanikya");
//		eleUtil.sendKeys(email, "test@test.com");
//		eleUtil.sendKeys(telephone, "999999999");

		// 7th method - String locator ElementUtil class that has generic function
		String name_id = "Form_submitForm_subdomain";
		String email_id = "Form_submitForm_Email";
		String tele_id = "Form_submitForm_Contact";
		By email = By.id("Form_submitForm_Email");

//		sendKeys(getBy("id", name_id), "Chanikya");
//		sendKeys(getBy("ID", email_id), "Chanikya@test.com");
//		sendKeys(getBy("id", tele_id),"99999999");
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys("id", name_id, "Chanikya");
		eleUtil.doSendKeys(email, "chanikya@test.com");
		eleUtil.doSendKeys("id", tele_id, "9999999");

	}

}
