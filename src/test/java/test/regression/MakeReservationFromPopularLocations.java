package test.regression;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.MakeFreeReservation;

public class MakeReservationFromPopularLocations {
	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "probniemail@gmail.com";
	private String loginPasswordField = "probniemail";
	private String guestsForFilteredObject = "2";
	private String dayForFilteredObject = "28";
	private String monthForFilteredObject = "Dec";
	private String yearForFilteredObject = "2018";
	private String time1FieldForFilteringObject = "02";
	private String time2FieldForFilteringObject = "00";

	@BeforeTest
	public void setupEnviromnent() {
		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());
	}

	@Test(priority = 1)
	public void testMakeReservationFromPopularLocations() throws InterruptedException {
		setupEnviroment.getDriver().get(baseURL);
		makeReservation.clickOnLoginLink();

		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.clickOnHomeLink();
		makeReservation.scrollDownPopularLocation();

		String titlePopularLocations = makeReservation.getSectionClass();
		Assert.assertEquals(titlePopularLocations, "text-center container-h3");

		makeReservation.clickOnPopularLocationCity();
		makeReservation.clickOnPopularLocationRestaurant();
		makeReservation.setGuestesForFilteredObject(guestsForFilteredObject);
		makeReservation.setDayForFilteredObject(dayForFilteredObject);
		makeReservation.setMonthForFilteredObject(monthForFilteredObject);
		makeReservation.setYearForFilteredObject(yearForFilteredObject);
		makeReservation.setTime1FieldForFilteringObject(time1FieldForFilteringObject);
		makeReservation.setTime2FieldForFilteringObject2(time2FieldForFilteringObject);
		makeReservation.clickOnFindTableForFilteredObject();
		makeReservation.clickOnNearestTimeForFilteredObject();
		makeReservation.scrollDown();
		makeReservation.clickOnCompleteReservationButton();
		makeReservation.clickOnMyReservationLink();

		String message1 = makeReservation.getConfirmationReservationClass();
		Assert.assertEquals(message1, "row-reservation btn-block ng-scope");

		setupEnviroment.getDriver().close();
		System.out.println("Finished regression test Make Reservation from popular locations section");

	}
}
