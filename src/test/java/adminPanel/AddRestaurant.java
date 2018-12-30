package adminPanel;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.SetupEnvironment;
import model.Admin;
import model.MakeFreeReservation;

public class AddRestaurant {
	private SetupEnvironment setupEnviroment;
	private MakeFreeReservation makeReservation;
	private Admin admin;

	//
	private String baseURL = "https://ridvansrestaurantclient.herokuapp.com/";
	private String loginEmailField = "ridvan_appa@hotmail.com";
	private String loginPasswordField = "admin";
	private String descriptionField = "Very good.";
	private String nameFieldForDish1 = "Musaka";
	private String priceOfDish1 = "10";
	private String nameFieldForDish2 = "Sarma";
	private String priceOfDish2 = "8";
	private String nameFieldForDish3 = "Makarons";
	private String priceOfDish3 = "7";
	private String amount1 = "4";
	private String amount2 = "6";
	private String amount3 = "8";
	private String defaultLength = "30";

	// private String uploadLogoImage1 =
	// "C:\\Users\\Nejla\\Desktop\\webapp\\kaminn.png";
	// slike\\bug1.png";
	// slike\\slikazanina.jpg";

	@BeforeTest
	public void setupEnviromnent() {

		setupEnviroment = new SetupEnvironment();
		makeReservation = new MakeFreeReservation(setupEnviroment.getDriver());
		admin = new Admin(setupEnviroment.getDriver());
		// admin = makeReservation.getAdmin();
		makeReservation = admin.getMakeReservatiom();

	}

	@Test
	public void testAddRestaurant() throws InterruptedException {
		setupEnviroment.getDriver().get(baseURL);

		makeReservation.clickOnLoginLink();
		makeReservation.setLoginEmailField(loginEmailField);
		makeReservation.setLoginPasswordField(loginPasswordField);
		makeReservation.clickOnLoginButton();
		admin.clickOnAdminLink();
		admin.clikcOnRestaurantSection();
		admin.clickOnAddRestaurantButton();
		// admin.clickOnUploadLogo();

		admin.UploadLogo();

		admin.setNameField();
		admin.clickOnCategory();

		admin.uploadCoverPhoto();

		admin.chooseCountry();
		admin.chooseCity();
		admin.setDescription(descriptionField);
		makeReservation.scrollDown();
		admin.choosePriceRange();
		makeReservation.scrollToTop();
		admin.clickOnMenuSection();
		admin.setNameOfDish(nameFieldForDish1);
		admin.chooseTypeOfDish();
		admin.setPrice(priceOfDish1);
		admin.setNameOfDish2(nameFieldForDish2);
		admin.chooseTypeOfDish2();
		admin.setPrice2(priceOfDish2);
		makeReservation.scrollDownLittle();
		admin.setNameOfDish3(nameFieldForDish3);
		admin.chooseTypeOfDish3();
		admin.setPrice3(priceOfDish3);
		admin.clickOnTablesSection();
		admin.chooseTypeOfTables1();
		admin.setAmount1(amount1);
		admin.chooseTypeOfTables2();
		admin.setAmount2(amount2);
		admin.chooseTypeOfTables3();
		admin.setAmount3(amount3);
		admin.clickOnReservationSection();
		admin.setdefaultLength(defaultLength);
		admin.clickOnSaveRestaurantButton();

	}
}
