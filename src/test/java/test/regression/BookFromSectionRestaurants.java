package test.regression;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.MakeFreeReservation;
import model.Menu;

public class BookFromSectionRestaurants {

	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private Menu menu;
	//
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
		System.out.println("Generated random number of guests:" + guestsForFilteredObject);
	}

	public void generateRandomDay() {

		Random random = new Random();
		dayForFilteredObject = random.nextInt(29);
		System.out.println("Generated random day:" + dayForFilteredObject);
	}

	public void generateRandomMonth() {
		String[] months = { "Jan", "Feb", "Mar", "Apr" };
		Random random = new Random();
		int index = random.nextInt(4);
		monthForFilteredObject = months[index];
		System.out.println("Generated random month:" + monthForFilteredObject);
	}

	@BeforeTest
	public void setupEnviromnent() {

		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());
		menu = makeReservation.getMenu();

	}

	@Test(priority = 1)
	public void testBookFromSectionRestaurants() throws InterruptedException {
		setupEnviroment.getDriver().get(baseURL);

		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		makeReservation.clickOnHomeLink();
		makeReservation.clickOnRestaurantsLink();

		makeReservation.clickOnFindByButton();
		makeReservation.clickOnRate();
		makeReservation.clickOnFilterSearchButton();
		makeReservation.clickOnFilteredObject();
		menu.clickOnAboutButton();

		String aboutHeaderClass = menu.getAboutHeaderClass();
		Assert.assertEquals(aboutHeaderClass, "restaurant-h5 ng-binding");

		String aboutDescriptionClass = menu.getAboutDescriptionClass();
		Assert.assertEquals(aboutDescriptionClass, "desc restaurant-h6");

		makeReservation.scrollToTop();
		menu.clickOnMenuButton();

		String menuClass = menu.getMenuClass();
		Assert.assertEquals(menuClass, "container-card ng-scope");

		makeReservation.clickOnLunchButton();
		makeReservation.clickOnDinnerButton();
		makeReservation.clickOnShowFullMenuButton();
		makeReservation.scrollToTop();
		menu.clickOnReviewsButton();
		String reviewClass = menu.getReviewClass();
		Assert.assertEquals(reviewClass, "h5-heading-reservation review-h5 restaurant-h5");

		makeReservation.scrollToTop();
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

		String toolTip1Class = makeReservation.getToolTip1Class();
		Assert.assertEquals(toolTip1Class, "row-reservation btn-block ng-scope");

		setupEnviroment.getDriver().close();

		System.out.println("Finished regressiontest Book a restaurant from the section Restaurants");

	}

}
