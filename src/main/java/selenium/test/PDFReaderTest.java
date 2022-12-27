package selenium.test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PDFReaderTest {
	
	WebDriver driver;
	String url= "file:///C:/Users/cpeddi/Downloads/_OceanofPDF.com_Atomic_Habits_-_James_Clear.pdf";
	@BeforeTest
	
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	@Test
	public void pdfReaderTest() throws IOException {
		
		URL pdfUrl =new URL(url);
		InputStream ip= pdfUrl.openStream();
		BufferedInputStream bf= new BufferedInputStream(ip);
		PDDocument pdfDoc =PDDocument.load(bf);
		//pageCount
		int pageCount=pdfDoc.getNumberOfPages();
		System.out.println(pageCount);
		Assert.assertEquals(pageCount, 294);
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
