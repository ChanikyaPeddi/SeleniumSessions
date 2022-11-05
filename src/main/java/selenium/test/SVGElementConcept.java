package selenium.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://petdiseasealerts.org/forecast-map#/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);

		List<WebElement> statesList = driver.findElements(By
				.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='path']"));

		System.out.println("No of states in United States " + statesList.size());
		Actions act = new Actions(driver);
		for (WebElement e : statesList) {
			act.moveToElement(e).perform();
			String stateName = e.getAttribute("name");
			System.out.println(stateName);
			if (stateName.equals("Nebraska")) {
				e.click();
				break;
			}

		}
		Thread.sleep(5000);
		List <WebElement> list2 = 
				driver.findElements
				(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @class='counties']//*[name()='path' and @class='child']"));
		System.out.println("No of states in Nebraska " +list2.size());
		for (WebElement e :list2 ) {
			act.moveToElement(e).perform();
			String stateId=e.getAttribute("id");
			System.out.println(stateId);
			if(stateId.equals("31031")) {
				e.click();
				break;
			}
		}

	}

}
