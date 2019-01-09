package model;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin {
	MakeFreeReservation makeReservation;
	private WebDriver driver;

	@FindBy(xpath = "//*[@id=\"js-navbar-collapse\"]/ul/li[4]/a")
	WebElement adminLink;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[5]/div/div[2]/form/div/div[1]/div[8]")
	WebElement succesMessageForCreatedUser;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[2]/div[2]/div[2]/div")
	WebElement succesMessageForCreatedRestaurant;

	@FindBy(xpath = "/html/body/div[2]/div/div/ul/li[2]/a")
	WebElement restaurantSectionInAdmin;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[1]/div[1]/ul/li[2]/button")
	WebElement addRestaurantButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[1]/div[1]/label[1]")
	WebElement uploadLogoImage;

	@FindBy(xpath = "//*[@id=\"restaurantName\"]")
	WebElement nameField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[3]/div[1]/div[3]/select")
	WebElement category;

	@FindBy(className = "uploadcover")
	WebElement uploadCoverPhoto;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[2]/div[2]/div[1]/select")
	WebElement countryField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[2]/div[2]/div[2]/select")
	WebElement cityField;

	@FindBy(xpath = "//*[@id=\"resDescription\"]")
	WebElement descriptionField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[4]/div[2]/select")
	WebElement priceRange;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/ul/li[2]/a")
	WebElement menuSection;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[2]/div[2]/input[1]")
	WebElement nameFieldForDish1;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[2]/div[3]/select")
	WebElement typeOfDish1;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[2]/div[4]/input")
	WebElement priceOfDish1;

	@FindBy(xpath = "/html/body/div[2]/div/div/ul/li[3]/a")
	WebElement locationsSection;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div/div[1]/div[1]/ul/li[2]/button")
	WebElement addLocationButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div/div[2]/form[1]/div/div[1]/div[1]/input")
	WebElement locationNameField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div/div[2]/form[1]/div/div[1]/div[2]/input")
	WebElement existingOrNewCountryField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div/div[2]/form[1]/div/div[2]/div[2]/button")
	WebElement createLocationButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div/div[2]/form[1]/div/div[1]/div[1]/div")
	WebElement createdLocationAlert;

	@FindBy(xpath = "/html/body/div[2]/div/div/ul/li[4]/a")
	WebElement categoriesSection;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[4]/div/div[1]/div[1]/ul/li[2]")
	WebElement addCategoryButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[4]/div/div[2]/form[1]/div/div[1]/input")
	WebElement categoryNameField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[4]/div/div[2]/form[1]/div/div[2]/div[2]/button")
	WebElement createCategoryButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[4]/div/div[2]/form[1]/div/div[1]/div")
	WebElement createdCategoryAlert;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[3]/div[2]/input[1]")
	WebElement nameFieldForDish2;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[3]/div[3]/select")
	WebElement typeOfDish2;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[3]/div[4]/input")
	WebElement priceOfDish2;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[4]/div[2]/input[1]")
	WebElement nameFieldForDish3;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[4]/div[3]/select")
	WebElement typeOfDish3;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[2]/div/ng-form/div[4]/div[4]/input")
	WebElement priceOfDish3;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/ul/li[3]/a")
	WebElement tablesSection;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[3]/div/ng-form/div[2]/div[2]/select")
	WebElement typeOfTables1;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[3]/div/ng-form/div[2]/div[3]/input")
	WebElement amount1;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[3]/div/ng-form/div[3]/div[2]/select")
	WebElement typeOfTables2;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[3]/div/ng-form/div[3]/div[3]/input")
	WebElement amount2;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[3]/div/ng-form/div[4]/div[2]/select")
	WebElement typeOfTables3;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[3]/div/ng-form/div[4]/div[3]/input")
	WebElement amount3;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/ul/li[4]/a")
	WebElement reservationsSection;

	@FindBy(xpath = "//*[@id=\"defaultStay\"]")
	WebElement defaultLength;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[2]/div[2]/div[2]/button")
	WebElement saveRestaurantButton;

	@FindBy(xpath = "//*[@id=\"firstName\"]")
	WebElement firstNameField;

	@FindBy(xpath = "//*[@id=\"lastName\"]")
	WebElement lastNameField;

	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement emailField;

	@FindBy(xpath = "//*[@id=\"phone\"]")
	WebElement phoneNumberField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[5]/div/div[2]/form/div/div[1]/div[5]/div[1]/select")
	WebElement countryFieldforUserSection;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[5]/div/div[2]/form/div/div[1]/div[5]/div[2]/select")
	WebElement cityFieldforUserSection;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement passwordField;

	@FindBy(xpath = "//*[@id=\"confirmPassword\"]")
	WebElement confirmPasswordField;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[5]/div/div[2]/form/div/div[2]/div[2]/button")
	WebElement saveUserButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/ul/li[5]/a")
	WebElement usersLink;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[5]/div/div[1]/div[1]/ul/li[2]/button")
	WebElement addUserButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[2]/div[2]/div[2]/div")
	WebElement messageForNoInputData;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[1]/div[1]/label[1]")
	WebElement invalidLogoImage;

	@FindBy(xpath = "//*[@id=\"restaurantName\"]")
	WebElement invalidName;

	@FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div/div[2]/form/div[1]/div/div[1]/div/ng-form/div[3]/div[1]/div[2]")
	WebElement invalidCategories;

	public Admin(WebDriver driver) {
		this.driver = driver;
		makeReservation = new MakeFreeReservation(driver);

		PageFactory.initElements(driver, this);
	}

	public void clickOnAdminLink() {
		adminLink.click();
	}

	public void clikcOnRestaurantSection() {
		restaurantSectionInAdmin.click();
	}

	public void clickOnAddRestaurantButton() {
		addRestaurantButton.click();
	}

	public MakeFreeReservation getMakeReservatiom() {
		return makeReservation;
	}

	public void uploadLogo() throws InterruptedException, AWTException {

		uploadLogoImage.click();
		WebElement frame = driver.switchTo().activeElement();
		frame.sendKeys("C:\\Users\\Nejla\\Desktop\\webapp\\kaminn.png");
		Thread.sleep(1000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

	}

	public void setNameField(String name) {
		nameField.sendKeys(name);
	}

	public void clickOnCategory() {
		category.click();
		category.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void uploadCoverPhoto() throws InterruptedException, AWTException {
		uploadCoverPhoto.click();
		WebElement frame = driver.switchTo().activeElement();
		frame.sendKeys("C:\\Users\\Nejla\\Desktop\\webapp\\noentercity.png");
		Thread.sleep(1000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);

	}

	public void chooseCountry() {
		countryField.click();
		countryField.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void chooseCity() {
		cityField.click();
		cityField.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void setDescription(String descriptionField2) {
		descriptionField.sendKeys(descriptionField2);
	}

	public void choosePriceRange() {
		priceRange.click();
		priceRange.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void clickOnMenuSection() {
		menuSection.click();
	}

	public void setNameOfDish(String nameFieldForDish12) {
		nameFieldForDish1.sendKeys(nameFieldForDish12);
	}

	public void chooseTypeOfDish() {
		typeOfDish1.click();
		typeOfDish1.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void setPrice(String priceOfDish12) {
		priceOfDish1.sendKeys(priceOfDish12);
	}

	public void clickONLocationsSection() {
		locationsSection.click();
	}

	public void setLocationNameField(String locationNameField2) {
		locationNameField.sendKeys(locationNameField2);
	}

	public void setExistingOrNewCountryField(String existingOrNewCountryField2) {
		existingOrNewCountryField.sendKeys(existingOrNewCountryField2);
	}

	public void clickOnCreateLocationButton() {
		createLocationButton.click();
	}

	public String getCreatedLocationClass() {
		String alert = createdLocationAlert.getAttribute("class");
		return alert;
	}

	public void clickOnAddLocationButton() {
		addLocationButton.click();
	}

	public void clickOnCategoriesSection() {
		categoriesSection.click();
	}

	public void clickOnAddCategeryButton() {
		addCategoryButton.click();

	}

	public void setCategoryNameField(String categoryNameField2) {
		categoryNameField.sendKeys(categoryNameField2);
	}

	public void clickOnCreateCategoryButton() {
		createCategoryButton.click();
	}

	public String getCreatedCategoryClass() {
		String alertForCreatedCategory = createdCategoryAlert.getAttribute("class");
		return alertForCreatedCategory;
	}

	public void setNameOfDish2(String nameFieldForDish22) {
		nameFieldForDish2.sendKeys(nameFieldForDish22);
	}

	public void chooseTypeOfDish2() {
		typeOfDish2.click();
		typeOfDish2.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

	}

	public void setPrice2(String priceOfDish22) {
		priceOfDish2.sendKeys(priceOfDish22);
	}

	public void setNameOfDish3(String nameFieldForDish32) {
		nameFieldForDish3.sendKeys(nameFieldForDish32);
	}

	public void chooseTypeOfDish3() {
		typeOfDish3.click();
		typeOfDish3.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void setPrice3(String priceOfDish32) {
		priceOfDish3.sendKeys(priceOfDish32);
	}

	public void clickOnTablesSection() {
		tablesSection.click();
	}

	public void chooseTypeOfTables1() {
		typeOfTables1.click();
		typeOfTables1.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void chooseTypeOfTables2() {
		typeOfTables2.click();
		typeOfTables2.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void chooseTypeOfTables3() {
		typeOfTables3.click();

		typeOfTables3.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);

	}

	public void setAmount1(String amount12) {
		amount1.sendKeys(amount12);
	}

	public void setAmount2(String amount22) {
		amount2.sendKeys(amount22);
	}

	public void setAmount3(String amount32) {
		amount3.sendKeys(amount32);
	}

	public void clickOnReservationSection() {
		reservationsSection.click();
	}

	public void setdefaultLength(String defaultLength2) {
		defaultLength.sendKeys(defaultLength2);
	}

	public void clickOnSaveRestaurantButton() {
		saveRestaurantButton.click();
	}

	public void clickOnUploadLogo() {
		uploadLogoImage.click();
	}

	public void clickOnFirstNameField(String firstNameField2) {
		firstNameField.sendKeys(firstNameField2);
	}

	public void clickOnLastNameField(String lastNameField2) {
		lastNameField.sendKeys(lastNameField2);
	}

	public void setEmailField(String emailField2) {
		emailField.sendKeys(emailField2);
	}

	public void setPhoneNumberField(String phoneNumberField2) {
		phoneNumberField.sendKeys(phoneNumberField2);
	}

	public void chooseCountryForUser() {
		countryFieldforUserSection.click();
		countryFieldforUserSection.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void chooseCityForUser() {
		cityFieldforUserSection.click();
		cityFieldforUserSection.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
	}

	public void setPassword(String passwordField2) {
		passwordField.sendKeys(passwordField2);
	}

	public void confirmPasswordField(String confirmPasswordField2) {
		confirmPasswordField.sendKeys(confirmPasswordField2);
	}

	public void clickOnSaveUserButton() {
		saveUserButton.click();
	}

	public void clickOnUsersLInk() {
		usersLink.click();

	}

	public void clickOnAddUserButton() {
		addUserButton.click();
	}

	public String getCompletedCreatedUserClass() {
		String succes = succesMessageForCreatedUser.getAttribute("class");
		return succes;
	}

	public String getCreatedRestaurantClass() {
		String alertSuccessfully = succesMessageForCreatedRestaurant.getAttribute("class");
		return alertSuccessfully;
	}

	public String getNoInputDataRestaurantClass() {
		String alertForInvalidFieldInForm = messageForNoInputData.getAttribute("class");
		return alertForInvalidFieldInForm;
	}

	public String getLogoImageClass() {
		String emptyLogoImage = invalidLogoImage.getAttribute("class");
		return emptyLogoImage;
	}

	public String getNameFieldClass() {
		String emptyNameField = invalidName.getAttribute("class");
		return emptyNameField;
	}

	public String getCategoriesFieldClass() {
		String emptyCategoriesField = invalidCategories.getAttribute("class");

		return emptyCategoriesField;
	}
}
