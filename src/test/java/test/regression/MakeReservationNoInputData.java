package test.regression;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.MakeFreeReservation;

public class MakeReservationNoInputData {
	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "probniemail@gmail.com";
	private String loginPasswordField = "probniemail";

	@BeforeClass
	private void startClass() {
		System.out.println("Starting test class " + this.getClass().getCanonicalName());
	}

	@AfterClass
	private void finishedClass() {
		System.out.println("Finished test class " + this.getClass().getCanonicalName());
		System.out.println();
	}

	@BeforeTest
	public void setupEnviromnent() {
		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());

	}

	@Test(priority = 1)
	public void testMakeReservationNoInputData() throws InterruptedException {
		System.out.println("Started method " + this.getClass().getSimpleName());
		setupEnviroment.getDriver().navigate().to(baseURL);
		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.clickOnFindTableButton();

		String messageBellowTheField1 = makeReservation.getToolTipBellowField();
		Assert.assertEquals(messageBellowTheField1,
				"form-control home-form-control ng-pristine ng-untouched ng-empty ng-valid-min ng-valid-max ng-invalid ng-invalid-required");

		setupEnviroment.getDriver().close();
		System.out.println("Finished method " + this.getClass().getSimpleName());

	}

}