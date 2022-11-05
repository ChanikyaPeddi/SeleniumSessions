package exercise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandleExercise {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='orangehrm-login-footer-sm']/a)[1]")).click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String ParentWindow = it.next();
		System.out.println("Parent window" + ParentWindow);
		
		String childWindow = it.next();
		System.out.println("child window" + childWindow);
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(ParentWindow);
		System.out.println(driver.getTitle());

	}

}
