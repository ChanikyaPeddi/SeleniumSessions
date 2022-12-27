package exercise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestNav {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();

		// driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.get("https://www.hdfcbank.com/");

//		String pageTitle = driver.getTitle();
//		System.out.println(pageTitle);
//		driver.close();
		By productTypeElement = By.xpath("//div[@class='drp1']//div[@class='dropdown']");
		By productTypeListElement = By.xpath("//ul[@class='dropdown1 dropdown-menu']/li");
		//WebElement selectEle = driver.findElement(By.name("tablepress-1_length"));
		//selectDropDown(selectEle, "50");
		driver.findElement(productTypeElement).click();
		dropDownwithoutSelect (productTypeListElement,"Accounts");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
	}

	public static void selectDropDown(WebElement element, String value) {

		Select select = new Select(element);
		List<WebElement> optionsList = select.getOptions();

		for (WebElement e : optionsList) {

			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}

	}
	
	public static void dropDownwithoutSelect(By locator,  String value ) {
		
		
		List<WebElement> optionsList = driver.findElements(locator);
		System.out.println(optionsList.size());
		for (WebElement e :optionsList) {
			 String text = e.getText();
			 if (text.equals(value)) {
				 System.out.println(text);
				 e.click();
				 break;
			 }
		}
		
		
		
		
	}

}
