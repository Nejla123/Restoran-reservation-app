package model;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"js-navbar-collapse\"]/ul/li[3]/a")
	WebElement loginLink;

	@FindBy(xpath = "/html/body/div[2]/div/form/ul/li[2]/p/a")
	WebElement createAccountLink;

	@FindBy(xpath = "//*[@id=\"firstName\"]")
	WebElement firstNameField;

	@FindBy(xpath = "//*[@id=\"lastName\"]")
	WebElement lastNameField;

	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement emailField;

	@FindBy(xpath = "//*[@id=\"phone\"]")
	WebElement phoneNumberField;

	@FindBy(xpath = "/html/body/div[2]/div/form/div[5]/div[1]/select")
	WebElement countryField;

	@FindBy(xpath = "/html/body/div[2]/div/form/div[5]/div[2]/select")
	WebElement cityField;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement passwordField;

	@FindBy(xpath = "//*[@id=\"confirmPassword\"]")
	WebElement confirmPassword;

	@FindBy(xpath = "/html/body/div[2]/div/form/button")
	WebElement createAccountButton;

	@FindBy(xpath = "/html/body/div[2]/div/form/ul/li[1]/h3")
	WebElement createdAccount;

	@FindBy(xpath = "/html/body/div[2]/div/form/div[3]/p")
	WebElement invalidEmail;

	@FindBy(xpath = "/html/body/div[2]/div/form/div[3]")
	WebElement invalidEmailField;

	@FindBy(xpath = "/html/body/div[2]/div/form/div[4]")
	WebElement invalidPhoneNumber;

	public void clickOnLoginLink() {
		loginLink.click();
	}

	public CreateAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnCreateAccountLink() {
		createAccountLink.click();
	}

	public void setFirstName(String firstNameField2) {
		firstNameField.sendKeys(firstNameField2);
	}

	public void setLastName(String lastNameField2) {
		lastNameField.sendKeys(lastNameField2);
	}

	public void setPhoneNumber(String phoneNumberField2) {
		phoneNumberField.sendKeys(phoneNumberField2);
	}

	public void setEmail(String emailField2) {
		emailField.sendKeys(emailField2);
	}

	public void chooseCountry() {
		// countryField.click();
		countryField.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void chooseCity() {
		cityField.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void setPassword(String passwordField2) {
		passwordField.sendKeys(passwordField2);
	}

	public void confirmPassword(String confirmPassword2) {
		confirmPassword.sendKeys(confirmPassword2);
	}

	public void clickOnCreateAccountbutton() {
		createAccountButton.click();
	}

	public String getCreatedAccountClass() {
		String title = createdAccount.getAttribute("class");
		return title;
	}

	public String getInvalidEmailClass() {
		String message = invalidEmail.getAttribute("class");
		return message;
	}

	public String getInvalidEmailFieldClass() {
		String highlighedEmailField = invalidEmailField.getAttribute("class");
		return highlighedEmailField;
	}

	public String getInvalidPhoneNumberClass() {
		String highlighedPhoneNumberField = invalidPhoneNumber.getAttribute("class");
		return highlighedPhoneNumberField;

	}

}
