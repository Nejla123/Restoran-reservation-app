package test.regression;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.CreateAccount;

public class CreateAccountInvalidInput {
	public class CreateAccountFillFields {
		private SetupEnvironment setupEnviroment;
		private CreateAccount createAccount;
		private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
		private String firstNameField = "Amy";
		private String lastNameField = "Rey";
		private String emailField = "amy1234mail.com";
		private String phoneNumberField = "0330&/$%111";

		@BeforeTest
		public void setupEnviromnent() {
			setupEnviroment = new SetupEnvironment();
			createAccount = new CreateAccount(setupEnviroment.getDriver());

		}

		@Test(priority = 1)
		public void testCreateAccountInvalidInput() {

			setupEnviroment.getDriver().get(baseURL);

			createAccount.clickOnLoginLink();
			createAccount.clickOnCreateAccountLink();
			createAccount.setFirstName(firstNameField);
			createAccount.setLastName(lastNameField);
			createAccount.setEmail(emailField);

			String message = createAccount.getInvalidEmailClass();
			Assert.assertEquals(message, "help-block");

			String highlighedEmailField = createAccount.getInvalidEmailFieldClass();
			Assert.assertEquals(highlighedEmailField, "form-group formg has-error");

			createAccount.setPhoneNumber(phoneNumberField);

			String highlighedPhoneNumberField = createAccount.getInvalidPhoneNumberClass();
			Assert.assertEquals(highlighedPhoneNumberField, "form-group formg");

			setupEnviroment.getDriver().close();
			System.out.println("Finished regression test Create an account - invalid inputs");

		}
	}

}
