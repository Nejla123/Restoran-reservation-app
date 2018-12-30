package test.smoke;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.MakeFreeReservation;

public class SmokeTest {

	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "probniemail@gmail.com";
	private String loginPasswordField = "probniemail";
	private String searchBarField = "Panera";
	private String guestsField = "3";
	private String dayField = "1";
	private String monthField = "Feb";
	private String yearField = "2019";
	private String timeField1 = "2";
	private String timeField2 = "00";

	@BeforeTest
	public void setupEnviromnent() {
		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());

	}

	@Test
	public void testMakeFreeReservation() throws InterruptedException {
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
		makeReservation.scrollDown2();

		makeReservation.clickOnObject();

		makeReservation.clickOnFindTableButton2();
		makeReservation.clickOnNearestTimeButton();
		makeReservation.scrollDown();
		makeReservation.clickOnCompleteReservationButton();
		makeReservation.clickOnMyReservationLink();

		String title = makeReservation.getCompletedReservationClass();
		Assert.assertEquals(title, "col-xs-4 col-info ng-binding");
		setupEnviroment.getDriver().close();
	}
}
