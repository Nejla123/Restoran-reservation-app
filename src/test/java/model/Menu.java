package model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Menu {

	WebDriver driver;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div[2]/a[2]")
	WebElement aboutButton;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div[2]/a[3]")
	WebElement menuButton;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div[1]/div/div[2]/a[4]")
	WebElement reviewsBUtton;

	@FindBy(xpath = "//*[@id=\"About\"]/h5")
	WebElement titleAbout;

	@FindBy(xpath = "//*[@id=\"About\"]/h6")
	WebElement titleDescription;

	@FindBy(xpath = "//*[@id=\"Menu\"]")
	WebElement titleMenu;

	@FindBy(xpath = "//*[@id=\"Reviews\"]/h5")
	WebElement titleReview;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[3]/div/div[1]/div[2]/button[1]")
	WebElement tooltip1;

	public Menu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getAboutHeaderClass() {
		String headerClass = titleAbout.getAttribute("class");
		return headerClass;
	}

	public String getAboutDescriptionClass() {
		String descriptionClass = titleDescription.getAttribute("class");
		return descriptionClass;
	}

	public String getMenuClass() {
		String menuSection = titleMenu.getAttribute("class");
		return menuSection;
	}

	public String getReviewClass() {
		String reviewSection = titleReview.getAttribute("class");
		return reviewSection;
	}

	public void clickOnAboutButton() {
		aboutButton.click();

	}

	public void clickOnMenuButton() {
		menuButton.click();

	}

	public void clickOnReviewsButton() throws InterruptedException {
		reviewsBUtton.click();
		Thread.sleep(3000);

	}

}
