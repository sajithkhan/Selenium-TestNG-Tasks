package end2end;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Elements {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sajith\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
	}
	
	
	@Test(priority = 1, description = "Click on the element card")
	public void navigateThroughElement() {
		WebElement elementA = driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[3]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementA);
		elementA.click();
	}
	
	@Test(priority = 2, description = "Validate the textbox's behaviour")
	public void textBox() {
		//click on textbox
		driver.findElement(By.xpath("//span[normalize-space()='Text Box']")).click();
		
		//Enter the full name & validate
		WebElement fullName = driver.findElement(By.xpath("//input[@id='userName']"));
		String expectedText = "Sajith Khan";
		fullName.sendKeys(expectedText);
		String actualText = fullName.getAttribute("value");
		Assert.assertEquals(actualText, expectedText,"Validate that the fullname entered is not valid");
		
		//Enter the email & validate
		WebElement email = driver.findElement(By.xpath("//input[@id='userEmail']"));
		String expectedEmail = "sajith1395@gmail.com";
		email.sendKeys(expectedEmail);
		String actualEmail = email.getAttribute("value");
		Assert.assertEquals(actualEmail, expectedEmail,"Validate that the email entered is not valid");
		
		//Enter the current address & validate
		WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		String expectedAddress = "VVU, chenai, Tilo";
		currentAddress.sendKeys(expectedAddress);
		String actualAddress = currentAddress.getAttribute("value");
		Assert.assertEquals(actualAddress, expectedAddress,"Validate that the address entered is not valid");
		
		//Enter the permanent address & validate
		WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
		String expectedPermanentAddress = "Bigi, Bhilachiki";
		permanentAddress.sendKeys(expectedPermanentAddress);
		String actualPermanentAddress = permanentAddress.getAttribute("value");
		Assert.assertEquals(actualPermanentAddress, expectedPermanentAddress,"Validate that the entered permanent address is not valid");
		
		//validate the submit button
		WebElement submitButton = driver.findElement(By.id("submit"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
		Assert.assertTrue(submitButton.isDisplayed(),"Submit button is not available on the page");
		String buttonText = submitButton.getText();
		Assert.assertEquals(buttonText, "Submit","Submit button text is false");
		submitButton.click();
	}
	
	@Test(priority = 3, description = "Validate the checkbox's behaviour")
	public void checkBox() {
		driver.findElement(By.xpath("//span[normalize-space()='Check Box']")).click();
		driver.findElement(By.xpath("//button[@title='Expand all']//*[name()='svg']//*[name()='path' and contains(@d,'M19 3H5c-1')]")).click();
	}
	
	
	

}
