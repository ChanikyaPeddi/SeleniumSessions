package exercise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.test.BrowserUtil;
import selenium.test.ElementUtil;

public class IkeaBasicFlow {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_driver("chrome");

		br.launchUrl("https://www.ikea.com/au/en/");
		br.windowSettings();
		ElementUtil eu = new ElementUtil(driver);

		// System.out.println(driver.getTitle());

		By searchKey = By.xpath("//input[@name='q']");
		By SearchBtn = By.cssSelector("#search-box__searchbutton");
		By searchedItems = By.xpath("//div[@class='product-fragment__info' ]//span[text()='BILLY']");
		By addToCartBtn= By.xpath("//span[text()='Add to bag']");
		By shoppingCartBtn = By.linkText("Continue to bag");
		By checkoutBtn= By.xpath("(//span[text()='Continue to checkout'])[2]");
		eu.getElement(searchKey).sendKeys("Billy");
		eu.getElement(SearchBtn).click();
		
		// clicking on billy item
		List<WebElement> searchItemsList = eu.waitForElementsPresence(searchedItems, 5);
		System.out.println(searchItemsList.size());
		for (WebElement e : searchItemsList) {
			String text = e.getText();
			if(text.equals("BILLY")) {
				System.out.println(text);
				e.click();
				break;
			}else {
				System.out.println("Searched Item is not found ");
			}
			
		}
		// add product to cart page 
		eu.getElement(addToCartBtn).click();
		//continue to shopping bag
		eu.waitForElementVisible(shoppingCartBtn, 10).click();
		// checkout 
		eu.waitForElementVisible(checkoutBtn, 10).click();
		
		
	}

}
