package seleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	String title;

	@Test
	public void launchBrowser(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		title = driver.getTitle();
		Assert.assertEquals("Google", title);
		driver.quit();
	}

	@Test
	public void searchItems() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		driver.findElement(By.name("q")).sendKeys("world");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		title = driver.getTitle();
		Assert.assertEquals("world - Google Search", title);
		driver.quit();
	}
}
