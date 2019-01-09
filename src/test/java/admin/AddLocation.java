package admin;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.Admin;
import model.MakeFreeReservation;

public class AddLocation {
	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private Admin admin;
	private String locationNameField;
	private int locationPrefixLenght = 5;
	private String locationSufix = "a";

	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "ridvan_appa@hotmail.com";
	private String loginPasswordField = "admin";
	private String existingOrNewCountryField = "Hrvatska";

	public void generateRandomLocation() {
		String allowedCharacters = "abcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();
		String randomLocationPrefix = "";
		for (int i = 0; i < locationPrefixLenght; i++) {
			int index = random.nextInt(allowedCharacters.length());
			char randomCharacter = allowedCharacters.charAt(index);
			randomLocationPrefix = randomLocationPrefix + randomCharacter;
		}
		locationNameField = randomLocationPrefix + locationSufix;

	}

	@BeforeTest
	public void setupEnviromnent() {

		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());
		admin = new Admin(setupEnviroment.getDriver());
		makeReservation = admin.getMakeReservatiom();

	}

	@Test(priority = 1)
	public void testAddRestaurant() throws InterruptedException {
		setupEnviroment.getDriver().get(baseURL);

		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		admin.clickOnAdminLink();
		admin.clickONLocationsSection();
		admin.clickOnAddLocationButton();
		generateRandomLocation();
		admin.setLocationNameField(locationNameField);
		admin.setExistingOrNewCountryField(existingOrNewCountryField);
		admin.clickOnCreateLocationButton();
		String alert = admin.getCreatedLocationClass();
		Assert.assertEquals(alert, "alert alert-success ng-binding ng-scope");
		setupEnviroment.getDriver().close();

	}
}