package test.regression;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.CreateAccount;

public class CreateAccountFillFields {
	private SetupEnvironment setupEnviroment;
	private CreateAccount createAccount;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String firstNameField = "Amy";
	private String lastNameField = "Rey";
	private String email;
	private int emailPrefixLenght = 5;
	private String emailSufix = "@gmail.com";
	private String phoneNumberField = "037800111";
	private String passwordField = "apple12";
	private String confirmPassword = "apple12";

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
		email = randomEmailPrefix + emailSufix;

	}

	@BeforeClass
	private void startClass() {
		System.out.println("Starting test class " + this.getClass().getCanonicalName());
	}

	@AfterClass
	private void finishedClass() {
		System.out.println("Finished test class " + this.getClass().getCanonicalName());
	}

	@BeforeTest
	public void setupEnviromnent() {
		setupEnviroment = new SetupEnvironment();
		createAccount = new CreateAccount(setupEnviroment.getDriver());

	}

	@Test(priority = 1)
	public void testCreateAccountFillField() {

		setupEnviroment.getDriver().get(baseURL);

		createAccount.clickOnLoginLink();
		createAccount.clickOnCreateAccountLink();
		createAccount.setFirstName(firstNameField);
		createAccount.setLastName(lastNameField);
		generateRandomEmail();
		createAccount.setEmail(email);
		createAccount.setPhoneNumber(phoneNumberField);
		createAccount.chooseCountry();
		createAccount.chooseCity();
		createAccount.setPassword(passwordField);
		createAccount.confirmPassword(confirmPassword);
		createAccount.clickOnCreateAccountbutton();

		String title = createAccount.getCreatedAccountClass();
		Assert.assertEquals(title, "login-h3");

		setupEnviroment.getDriver().close();
		System.out.println("Finished regression test Create an account - fill all fields");

	}

}
