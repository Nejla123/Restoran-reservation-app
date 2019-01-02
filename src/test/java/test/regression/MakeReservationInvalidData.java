package test.regression;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.MakeFreeReservation;

public class MakeReservationInvalidData {
	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "probniemail@gmail.com";
	private String loginPasswordField = "probniemail";
	private String searchBarField = "Metropolis";
	private String guestsField = "2e";
	private String dayField = "20";
	private String monthField = "Apr";
	private String yearField = "2019";
	private String timeField1 = "3";
	private String timeField2 = "30";

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
	public void testMakeReservationInvalidData() throws InterruptedException {
		System.out.println("Started method " + this.getClass().getSimpleName());
		setupEnviroment.getDriver().navigate().to(baseURL);
		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.setSearchBarField(searchBarField);
		makeReservation.setGuestsField(guestsField);
		makeReservation.setDay(dayField);
		makeReservation.setMonth(monthField);
		makeReservation.setYear(yearField);
		makeReservation.setTime1(timeField1);
		makeReservation.setTime2(timeField2);

		makeReservation.clickOnFindTableButton();

		String messageGuestsField = makeReservation.getTooltipGuestsField();
		Assert.assertEquals(messageGuestsField,
				"form-control home-form-control ng-dirty ng-empty ng-invalid ng-invalid-number ng-touched");

		setupEnviroment.getDriver().close();
		System.out.println("Finished method " + this.getClass().getSimpleName());

	}

}