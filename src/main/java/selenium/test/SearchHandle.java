package selenium.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		//driver.get("https://www.google.co.in/");
		
		driver.findElement(By.id("search_query_top")).sendKeys("dresses");
		Thread.sleep(5000);
		//1st method - if we know the text of the search item we can simply create an xpath and click on it 
		driver.findElement(By.xpath("//li[contains(text(),'Summer Dresses > Printed Chiffon Dress')]")).click();
		
		//2nd method - if we dont the text and want to iterate through all texts then need to use for loop+ find elements 
		List<WebElement> suggList = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
		for(WebElement e : suggList) {
			String text = e.getText();
			if(text.contains("Evening Dresses > Printed Dress")) {
				e.click();
				break;
			}
		}

	}

}
