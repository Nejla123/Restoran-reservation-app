package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupEnvironment {

	private WebDriver driver;
	private String driverName = "webdriver.chrome.driver";
	private String driverPath = "C:\\Users\\Nejla\\Downloads\\chromedriver_win32\\chromedriver.exe";

	public SetupEnvironment() {
		System.setProperty(driverName, driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

}
