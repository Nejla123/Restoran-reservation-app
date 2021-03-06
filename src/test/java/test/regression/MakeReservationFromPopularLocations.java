package test.regression;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
	private Integer guestsForFilteredObject;
	private Integer dayForFilteredObject;
	private String monthForFilteredObject;
	private String yearForFilteredObject = "2019";
	private String time1FieldForFilteringObject = "02";
	private String time2FieldForFilteringObject = "00";

	public void generateRandomNumberOfGuests() {

		Random random = new Random();
		guestsForFilteredObject = random.nextInt(7);
		guestsForFilteredObject = (guestsForFilteredObject + 1) % 8;
		System.out.println("Generated random number of guests:" + guestsForFilteredObject);
	}

	public void generateRandomDay() {

		Random random = new Random();
		dayForFilteredObject = random.nextInt(28);
		dayForFilteredObject = (dayForFilteredObject + 1) % 29;
		System.out.println("Generated random day:" + dayForFilteredObject);
	}

	public void generateRandomMonth() {
		String[] months = { "Jan", "Feb", "Mar", "Apr" };
		Random random = new Random();
		int index = random.nextInt(4);
		monthForFilteredObject = months[index];
		System.out.println("Generated random month:" + monthForFilteredObject);
	}

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
	public void testMakeReservationFromPopularLocations() throws InterruptedException {

		System.out.println("Started method " + this.getClass().getSimpleName());

		setupEnviroment.getDriver().navigate().to(baseURL);
		makeReservation.clickOnLoginLink();

		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.clickOnHomeLink();
		makeReservation.scrollToBottom();

		String titlePopularLocations = makeReservation.getSectionClass();
		Assert.assertEquals(titlePopularLocations, "text-center container-h3");

		makeReservation.clickOnPopularLocationCity();
		makeReservation.clickOnPopularLocationRestaurant();
		generateRandomNumberOfGuests();
		makeReservation.setGuestesForFilteredObject(guestsForFilteredObject.toString());
		generateRandomDay();
		makeReservation.setDayForFilteredObject(dayForFilteredObject.toString());
		generateRandomMonth();
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
		System.out.println("Finished method " + this.getClass().getSimpleName());

	}
}
