package exercise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameExcersice {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		
		// Frames concept :
		
		driver.findElement(By.xpath("//img[@title='vehicle-registration-forms-and-templates']")).click();
		Thread.sleep(2000);
		//switch to frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame-one748593425']")));
		driver.findElement(By.cssSelector("#RESULT_TextField-7")).sendKeys("987654321");
		driver.findElement(By.id("RESULT_TextField-8")).sendKeys("chanikya");
		driver.switchTo().defaultContent();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("")));
}
}
