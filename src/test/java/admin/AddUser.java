package admin;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.Admin;
import model.MakeFreeReservation;

public class AddUser {

	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private Admin admin;

	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "ridvan_appa@hotmail.com";
	private String loginPasswordField = "admin";
	private String firstNameField = "Amy";
	private String lastNameField = "lFid";
	private int emailPrefixLenght = 5;
	private String emailSufix = "@gmail.com";
	private String emailField;
	private String phoneNumberField = "033777777";
	private String passwordField = "amy123123";
	private String confirmPasswordField = "amy123123";

	public void generateRandomEmail() {

		String allowedCharacters = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();
		String randomEmailPrefix = "";
		for (int i = 0; i < emailPrefixLenght; i++) {
			// length of the random string.
			int index = random.nextInt(allowedCharacters.length());
			char randomCharacter = allowedCharacters.charAt(index);
			randomEmailPrefix = randomEmailPrefix + randomCharacter;
		}
		emailField = randomEmailPrefix + emailSufix;
	}

	@BeforeTest
	public void setupEnviromnent() {

		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());
		admin = new Admin(setupEnviroment.getDriver());
		makeReservation = admin.getMakeReservatiom();

	}

	@Test(priority = 1)
	public void testAddUser() throws InterruptedException {
		setupEnviroment.getDriver().get(baseURL);

		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		admin.clickOnAdminLink();
		admin.clickOnUsersLInk();
		admin.clickOnAddUserButton();

		admin.clickOnFirstNameField(firstNameField);
		admin.clickOnLastNameField(lastNameField);
		generateRandomEmail();
		admin.setEmailField(emailField);
		admin.setPhoneNumberField(phoneNumberField);
		admin.chooseCountryForUser();
		admin.chooseCityForUser();
		makeReservation.scrollDownLittle();
		admin.setPassword(passwordField);
		admin.confirmPasswordField(confirmPasswordField);
		admin.clickOnSaveUserButton();
		makeReservation.scrollDown();

		String succes = admin.getCompletedCreatedUserClass();
		Assert.assertEquals(succes, "alert alert-success ng-binding ng-scope");
		setupEnviroment.getDriver().close();

	}
}
