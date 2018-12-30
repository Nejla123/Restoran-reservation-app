package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"js-navbar-collapse\"]/ul/li[3]/a")
	WebElement loginLink;

	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement loginEmailField;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement loginPasswordField;

	@FindBy(xpath = "/html/body/div[2]/div/form/button")
	WebElement loginButton;

	@FindBy(xpath = "/html/body/div[2]/div/form/div[1]/p")
	WebElement login;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnLoginLink() {
		loginLink.click();
	}

	public void setLoginEmailField(String loginEmailField2) {
		loginEmailField.sendKeys(loginEmailField2);
	}

	public void setLoginPasswordField(String loginPasswordField2) {
		loginPasswordField.sendKeys(loginPasswordField2);

	}

	public void clickOnLoginButton() {
		loginButton.click();
	}

	public String getLoginClass() {
		String message = login.getAttribute("class");
		return message;
	}

}
