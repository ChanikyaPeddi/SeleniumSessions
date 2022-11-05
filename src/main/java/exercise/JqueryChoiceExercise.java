package exercise;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryChoiceExercise {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox1")).click();
		Thread.sleep(2000);

		By choices = By.xpath("(//div[contains(@id,'DropDownContainer')])[2]//ul//span[@class='comboTreeItemTitle']");
		// 1st - select only one choice
		// selectChoice(choices, "choice 1");

		// select multiple choices
		// selectChoiceMultiple(choices, "choice 1", "choice 2", "choice 6 1");
		selectChoiceAll(choices, "all");
	}

	public static void selectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);
		System.out.println(choiceList.size());
		for (WebElement e : choiceList) {
			String text = e.getText().trim();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}

		}

	}

	// to select muliple choices
	public static void selectChoiceMultiple(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);
		System.out.println(choiceList.size());
		for (WebElement e : choiceList) {
			String text = e.getText().trim();
			// System.out.println(text);
			for (int i = 0; i < value.length; i++) {
				if (text.equals(value[i])) {
					e.click();
					break;

				}
			}

		}

	}

	// to select all choices
	public static void selectChoiceAll(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);
		System.out.println(choiceList.size());
		boolean flag = false;
		if (!value[0].trim().equalsIgnoreCase("all")) {
			for (WebElement e : choiceList) {
				String text = e.getText().trim();
				// System.out.println(text);
				for (int i = 0; i < value.length; i++) {
					if (text.equals(value[i])) {
						flag = true;
						e.click();
						break;

					}
				}

			}
		} else {
			// all select logic
			for (WebElement e : choiceList) {
				e.click();
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("choice is not available = " + value[0]);
		}
	}
}
