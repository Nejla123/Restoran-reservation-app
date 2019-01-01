package test.regression;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.Login;

public class LoginInvalidInput {
	private SetupEnvironment setupEnviroment;

	private Login login;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "probniemail@gmail%com";
	private String loginPasswordField = "probniemail";

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
		login = new Login(setupEnviroment.getDriver());

	}

	@Test(priority = 1)
	public void testLoginInvalidInput() {
		setupEnviroment.getDriver().get(baseURL);
		login.clickOnLoginLink();

		login.setLoginEmailField(loginEmailField);
		login.setLoginPasswordField(loginPasswordField);

		String messageForInvalidEmail = login.getLoginClass();
		Assert.assertEquals(messageForInvalidEmail, "help-block");
		setupEnviroment.getDriver().close();
		System.out.println("Finished regression test Login form - invalid inputs");

	}
}