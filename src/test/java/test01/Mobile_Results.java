package test01;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Mobile_Results {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sajith\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void launch() {
		driver.get("https://www.amazon.in/");
	}
	
	@Test(priority = 2)
	public void search() {
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Mobile");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement mobileProductNames = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class, 'a-text-normal')]")));
	}
	
	
	
	@Test(priority = 3)
	public void listMobileNames() {
		List<WebElement> mobileTitles = driver.findElements(By.xpath("//span[contains(@class, 'a-text-normal')]"));
		for(int i=0; i<6; i++) {
			System.out.println(mobileTitles.get(i).getText());
		}
	}

	@AfterClass
	public void quit() {
		if (driver != null) {
            driver.quit();
        	}
	}

	

}
