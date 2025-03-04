package earleePayroll;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Signup {
	@Test
    public void signup() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Open Temp Mail and get a temporary email
        driver.get(UniversalLocators.TEMP_MAIL_URL);
        Thread.sleep(3000);
        @SuppressWarnings("deprecation")
		String tempEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(UniversalLocators.TEMP_EMAIL_FIELD)).getAttribute("value");
        
        // Open sign up page in a new tab
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(UniversalLocators.URL);

        // Fill out the sign up form
        wait.until(ExpectedConditions.elementToBeClickable(UniversalLocators.REGISTER_LINK)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(UniversalLocators.FIRST_NAME)).sendKeys(UniversalLocators.FIRST_NAME_VALUE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UniversalLocators.LAST_NAME)).sendKeys(UniversalLocators.LAST_NAME_VALUE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UniversalLocators.EMAIL_SIGNUP)).sendKeys(tempEmail);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UniversalLocators.PASSWORD_SIGNUP)).sendKeys(UniversalLocators.SIGNUP_PASSWORD);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UniversalLocators.CONFIRM_PASSWORD)).sendKeys(UniversalLocators.SIGNUP_PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(UniversalLocators.TERMS_CHECKBOX)).click();
        wait.until(ExpectedConditions.elementToBeClickable(UniversalLocators.REGISTER_BUTTON)).click();

        // Switch back to temp mail tab and verify email
        Thread.sleep(5000);
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(UniversalLocators.TEMP_MAIL_INBOX)).click();
        wait.until(ExpectedConditions.elementToBeClickable(UniversalLocators.EMAIL_CONFIRMATION_LINK)).click();

        // Switch to the new tab if the verification link opens one
        ArrayList<String> updatedTabs = new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(7000);
        if (updatedTabs.size() > 2) {
            driver.switchTo().window(updatedTabs.get(2));
        }

        // Close the verification tab and return to the main app
        driver.close();
        driver.switchTo().window(tabs.get(1));
        driver.get(UniversalLocators.URL);

        // Log in after verification
        wait.until(ExpectedConditions.elementToBeClickable(UniversalLocators.EMAIL1)).sendKeys(tempEmail);
        wait.until(ExpectedConditions.elementToBeClickable(UniversalLocators.PASSWORD1)).sendKeys(UniversalLocators.SIGNUP_PASSWORD);
        wait.until(ExpectedConditions.elementToBeClickable(UniversalLocators.LOGIN1)).click();
        
        Thread.sleep(5000);
        driver.quit();
    }

}
