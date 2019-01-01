package test.regression;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.MakeFreeReservation;

public class NonExistentRestaurant {
	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private String loginEmailField = "probniemail@gmail.com";
	private String loginPasswordField = "probniemail";
	private String searchBarField = "Mlinada";
	private String guestsField = "3";
	private String dayField = "30";
	private String monthField = "Mar";
	private String yearField = "2019";
	private String timeField1 = "2";
	private String timeField2 = "00";

	@BeforeClass
	private void startClass() {
		System.out.println("Starting test class " + this.getClass().getCanonicalName());
	}

	@AfterClass
	private void finishedClass() {
		System.out.println("Finished test class " + this.getClass().getCanonicalName());
	}

	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";

	@BeforeTest
	public void setupEnviromnent() {
		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());
	}

	@Test(priority = 1)
	public void testNonExistentRestaurant() throws InterruptedException {
		setupEnviroment.getDriver().get(baseURL);
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

		String messageForNonExistentRestaurant = makeReservation.getMessageClass();
		Assert.assertEquals(messageForNonExistentRestaurant, "no-results");

		setupEnviroment.getDriver().close();
		System.out.println("Finished regression test Check search bar with non-existent restaurant in the database");

	}

}
