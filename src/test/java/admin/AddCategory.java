package admin;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.Admin;
import model.MakeFreeReservation;

public class AddCategory {

	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private Admin admin;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "ridvan_appa@hotmail.com";
	private String loginPasswordField = "admin";
	private int categoryLenght = 5;
	// private String categoryNameField = "gluten frreeee";
	private String categoryNameField;

	public void generateRandomCategory() {
		String allowedCharacters = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();
		String randomCategoryWord = "";
		for (int i = 0; i < categoryLenght; i++) {
			int index = random.nextInt(allowedCharacters.length());
			char randomCharacter = allowedCharacters.charAt(index);
			randomCategoryWord = randomCategoryWord + randomCharacter;
		}
		categoryNameField = randomCategoryWord;

	}

	@BeforeTest
	public void setupEnviromnent() {

		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());
		admin = new Admin(setupEnviroment.getDriver());
		makeReservation = admin.getMakeReservatiom();

	}

	@Test(priority = 1)
	public void testAddRestaurant() throws InterruptedException {
		setupEnviroment.getDriver().get(baseURL);

		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		admin.clickOnAdminLink();
		admin.clickOnCategoriesSection();
		admin.clickOnAddCategeryButton();
		generateRandomCategory();
		admin.setCategoryNameField(categoryNameField);
		admin.clickOnCreateCategoryButton();
		String alertForCreatedCategory = admin.getCreatedCategoryClass();
		Assert.assertEquals(alertForCreatedCategory, "alert alert-success ng-binding ng-scope");

	}
}