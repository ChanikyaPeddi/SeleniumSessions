package selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");

		// To select the webElement by clicking next button

		// finding the element which we want to select
		int pageCount = 1;
		while (true) {
			if (driver.findElements(By.xpath("//td[text()='Russia']")).size() > 0) {
				selectCity("Russia");
				System.out.println("selected city is in page : " + pageCount);
				break;
			} else {
				// pagination logic
				// click on next button
				WebElement next = driver.findElement(By.xpath("//a[@id='tablepress-1_next' and  text()='Next']"));
				if (next.getAttribute("class").contains("disabled")) {
					System.out.println("Element is not found ... next button is disabled");
					break;
				}
				next.click();
				Thread.sleep(3000);
				pageCount++;
			}
		}

	}

	public static void selectCity(String cityName) {
		driver.findElement(By.xpath("//td[text()='" + cityName + "']/preceding-sibling::td/input[@type='checkbox']"))
				.click();

	}

}
