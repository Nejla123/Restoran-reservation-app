package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupEnvironment {

	private WebDriver driver;
//	private String driverName = "webdriver.chrome.driver";
//	private String driverPath = "C:\\Users\\Nejla\\Downloads\\chromedriver_win32\\chromedriver.exe";

	public SetupEnvironment() {
//		System.setProperty(driverName, driverPath);
//		System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

}
