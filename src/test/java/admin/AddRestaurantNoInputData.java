package admin;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.Admin;
import model.MakeFreeReservation;

public class AddRestaurantNoInputData {
	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private Admin admin;
	//
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "ridvan_appa@hotmail.com";
	private String loginPasswordField = "admin";

	@BeforeTest
	public void setupEnviromnent() {

		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());
		admin = new Admin(setupEnviroment.getDriver());
		// admin = makeReservation.getAdmin();
		makeReservation = admin.getMakeReservatiom();

	}

	@Test
	public void testAddRestaurant() throws InterruptedException, AWTException {
		setupEnviroment.getDriver().get(baseURL);

		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		admin.clickOnAdminLink();
		admin.clikcOnRestaurantSection();
		admin.clickOnAddRestaurantButton();
		makeReservation.scrollDown();
		admin.clickOnSaveRestaurantButton();

		String alertForInvalidFieldInForm = admin.getNoInputDataRestaurantClass();
		Assert.assertEquals(alertForInvalidFieldInForm, "alert alert-danger ng-scope");

		makeReservation.scrollToTop();

//		String emptyLogoImage = admin.getLogoImageClass();
//		Assert.assertEquals(emptyLogoImage, "{'error-form' : rest.logoInv && submited }");

//		String emptyNameField = admin.getNameFieldClass();
//		Assert.assertEquals(emptyNameField,
//				"login-form-control input-lg input-admin-forms input-admin-forms ng-pristine ng-empty ng-invalid ng-invalid-required error-form ng-touched");

//		String emptyCategoriesField = admin.getCategoriesFieldClass();
//		Assert.assertEquals(emptyCategoriesField, "{'error-form' : rest.restCatInv && submited}");

		setupEnviroment.getDriver().close();

	}
}
