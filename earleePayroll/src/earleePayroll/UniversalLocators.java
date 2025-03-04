package earleePayroll;

import org.openqa.selenium.By;

public class UniversalLocators {
	public static final String URL = "https://earleepayroll.com/signin";
	public static final String emailAddress_creds = "aringay.keno23@gmail.com";
	public static final String password_creds = "passwprd@123_Janjan123";
	//Login 
	public static final By EMAIL = By.id("email1"); //email field
	public static final By PASSWORD = By.id("password1"); //email field
	public static final By LOGIN = By.xpath("//span[contains(text(), 'Log In')]");
	
	
	
	//Sign up Data
    public static final String FIRST_NAME_VALUE = "John";
    public static final String LAST_NAME_VALUE = "Doe";
    public static final String SIGNUP_PASSWORD = "Test@1234";

    // Sign up locators
    public static final By REGISTER_LINK = By.xpath("//span[contains(text(),'Register your Organization')]");
    public static final By FIRST_NAME = By.cssSelector("input[formcontrolname='firstName']");
    public static final By LAST_NAME = By.cssSelector("input[formcontrolname='lastName']");
    public static final By EMAIL_SIGNUP = By.cssSelector("input[formcontrolname='email']");
    public static final By PASSWORD_SIGNUP = By.id("password");
    public static final By CONFIRM_PASSWORD = By.id("confirmPassword");
    public static final By TERMS_CHECKBOX = By.xpath("//div[contains(@class, 'p-checkbox')]");
    public static final By REGISTER_BUTTON = By.xpath("//button[span[contains(text(),'Register')]]");

    // Email Verification
    public static final String VERIFICATION_URL_CONTAINS = "verify?mode=registered";

    // Temporary Mail
    public static final String TEMP_MAIL_URL = "https://temp-mail.io/en";
    public static final By TEMP_EMAIL_FIELD = By.id("email");
    public static final By TEMP_MAIL_INBOX = By.cssSelector("span[data-qa='message-subject'][title='Verify your email']");
    public static final By EMAIL_CONFIRMATION_LINK = By.xpath("//a[contains(text(),'Confirm Email')]");

    // Login Locators (2)
    public static final By EMAIL1 = By.cssSelector("input[formcontrolname='email']");
    public static final By PASSWORD1 = By.id("password1");
    public static final By LOGIN1 = By.xpath("//span[contains(text(), 'Log In')]");
    
	
	
}
