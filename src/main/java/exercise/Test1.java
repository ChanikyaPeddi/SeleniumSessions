package exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test1 {
	

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=product/product&product_id=45&search=macbook");
		
		List<WebElement> list= driver.findElements(By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li"));
		System.out.println(list.size());
		
		Actions actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(By.xpath(""))).click().perform();
		actions.moveToElement(null).contextClick().perform();
		
		
		

	}

}
