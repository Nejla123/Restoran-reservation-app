package test.regression;

import org.testng.Assert;
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

	@BeforeTest
	public void setupEnviromnent() {
		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());

	}

	@Test(priority = 1)
	public void testMakeReservationNoInputData() throws InterruptedException {
		setupEnviroment.getDriver().get(baseURL);
		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.clickOnFindTableButton();

		String messageBellowTheField1 = makeReservation.getToolTipBellowField();
		Assert.assertEquals(messageBellowTheField1,
				"form-control home-form-control ng-pristine ng-untouched ng-empty ng-valid-min ng-valid-max ng-invalid ng-invalid-required");

		setupEnviroment.getDriver().close();
		System.out.println("Finished regression test Make a free reservation - no input data");

	}

}