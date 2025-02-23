package earleePayroll;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Login {
		
	@Test
	public void login() {
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		driver.get(UniversalLocators.URL);
		
		 driver.manage().window().maximize();
		 
		 //LogIn
		 wait.until(ExpectedConditions.elementToBeClickable(UniversalLocators.EMAIL)).sendKeys(UniversalLocators.emailAddress_creds);
		 wait.until(ExpectedConditions.elementToBeClickable(UniversalLocators.PASSWORD)).sendKeys(UniversalLocators.password_creds);
		 wait.until(ExpectedConditions.elementToBeClickable(UniversalLocators.LOGIN)).click();
	}
}
