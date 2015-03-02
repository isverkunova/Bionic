package olxTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Searching {

	public WebDriver driver;

	public static final String HOST = "http://olx.ua";
	public static final String ID1 = "headerSearch";
	public static final String INPUT = "nokia lumia 630 black";
	public static final String ID2 = "submit-searchmain";
	public static final String XPATH1 = "/html/body/div[1]/div[2]/section/div/div/div[3]/table/tbody/tr[";
	public static final String XPATH2 = "]/td/table/tbody/tr/td[3]/h3/a/span";
	
	@BeforeSuite
	public void initEnv() {
		driver = new FirefoxDriver();
	}

	@Test
	public void TestGit() {

		driver.get(HOST);

		driver.findElement(By.id(ID1)).sendKeys(INPUT);
		
		driver.findElement(By.id(ID2)).click();
		
		boolean result = false;
		
		for (int i = 2; i < 7; i++) {
			String currentString = driver.findElement(
					By.xpath(XPATH1 + i + XPATH2)).getText();
			boolean contains = currentString.toLowerCase().contains(INPUT);

			if (contains) {
				result = true;
				break;
			}
		}

		Assert.assertEquals(result, true);
	}

	@AfterSuite
	public void closeIt() {
		driver.quit();
	}
}