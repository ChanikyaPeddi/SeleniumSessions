package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchAssign {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("One Piece");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'One Piece Film: Red')]")).click();
		

	}

}
