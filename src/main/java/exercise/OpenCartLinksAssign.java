package exercise;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCartLinksAssign {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opencart.antropy.co.uk/index.php?route=account/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		List<WebElement> rightPanelLinks= driver.findElements(By.xpath("//div[@class='list-group']/a"));
		
		//for each 
//		for (WebElement e : rightPanelLinks) {
//			System.out.println(e.getText());
//		}
		//streams
		//rightPanelLinks.stream().forEach(e->System.out.println(e.getText()));
		// for loop
		System.out.println(rightPanelLinks.size());
		for(int i=0; i<rightPanelLinks.size();i++) {
			System.out.println(rightPanelLinks.get(i).getText());
		}
		
		Alert alert = driver.switchTo().alert();
		
		alert.accept();
		alert.dismiss();
		alert.sendKeys(null);
		alert.getText();
		
		Select select = new Select(driver.findElement(By.xpath("")));
		select.selectByVisibleText("");
		
		Actions action = new Actions(driver);
		action.moveToElement(null);
		
		driver.findElement(By.xpath("")).getAttribute("value");		
		driver.quit();
	}

}
