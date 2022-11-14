package exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PaginationExercise {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.ikea.com/au/en/");
		
		By searchKey = By.xpath("//input[@name='q']");
		By SearchBtn = By.cssSelector("#search-box__searchbutton");
		By searchedItems = By.xpath("//div[@class='product-fragment__info' ]//span[text()='BILLY']");
		
		
		driver.findElement(searchKey).sendKeys("Billy");
		driver.findElement(SearchBtn).click();
		Thread.sleep(5000);
		
		WebElement showMoreBtn = driver.findElement(By.xpath("//span[text()='Show more']"));
		
		int i =0;
		while(true) {
			if(driver.findElements(searchedItems).size()==1){
				showMoreBtn.click();
			}
		}
		
		
	}
	

}
