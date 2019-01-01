package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupEnvironment {

	private WebDriver driver;
	private String driverName = "webdriver.chrome.driver";
	private String driverPath = "C:\\Users\\Nejla\\Downloads\\chromedriver_win32\\chromedriver.exe";

	public SetupEnvironment() {
//		System.setProperty(driverName, driverPath);
		System.setProperty("webdriver.chrome.driver","/home/haris/spring test/eclipse-workspace/maven/Restoran-reservation-app/chromedriver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public WebDriver getDriver() {
		return driver;
	}

}
