package test.smoke;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
	private Integer guestsField;
	private Integer dayField;
	private String monthField;
	private String yearField = "2019";
	private String timeField1 = "2";
	private String timeField2 = "00";

	public void generateRandomNumberOfGuests() {

		Random random = new Random();
		guestsField = random.nextInt(7);
		guestsField = (guestsField + 1) % 8;
		System.out.println("Generated random number of guests:" + guestsField);
	}

	public void generateRandomDay() {

		Random random = new Random();
		dayField = random.nextInt(28);
		dayField = (dayField + 1) % 29;
		System.out.println("Generated random day:" + dayField);
	}

	public void generateRandomMonth() {
		String[] months = { "Jan", "Feb", "Mar", "Apr" };
		Random random = new Random();
		int index = random.nextInt(4);
		monthField = months[index];
		System.out.println("Generated random month:" + monthField);
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

	@Test
	public void testMakeFreeReservation() throws InterruptedException {

		System.out.println("Started method " + this.getClass().getSimpleName());
		setupEnviroment.getDriver().get(baseURL);
		makeReservation.clickOnLoginLink();

		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.setSearchBarField(searchBarField);

		generateRandomNumberOfGuests();
		makeReservation.setGuestsField(guestsField.toString());

		generateRandomDay();
		makeReservation.setDay(dayField.toString());

		generateRandomMonth();
		makeReservation.setMonth(monthField);
		makeReservation.setYear(yearField);

		makeReservation.setTime1(timeField1);
		makeReservation.setTime2(timeField2);
		makeReservation.clickOnFindTableButton();
		makeReservation.scrollDownLittle();

		makeReservation.clickSearchReservationResult();

		makeReservation.clickOnFindTableButton2();
		makeReservation.clickOnNearestTimeButton();
		makeReservation.scrollDown();
		makeReservation.clickOnCompleteReservationButton();
		makeReservation.clickOnMyReservationLink();

		String title = makeReservation.getCompletedReservationClass();
		Assert.assertEquals(title, "col-xs-4 col-info ng-binding");
		setupEnviroment.getDriver().close();

		System.out.println("Finished method " + this.getClass().getSimpleName());
	}
}
