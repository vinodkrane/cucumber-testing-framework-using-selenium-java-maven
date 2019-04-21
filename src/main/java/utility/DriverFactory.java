package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	
	static WebDriver driver = null;
	
	/**
	* Create a driver instance or returns existing driver
	* @author  Vinod Rane
	* @version 1.0
	* @since   2018-12-26
	*/
	public static WebDriver get_driver_instance() {
		
		if(driver == null) {
			System.out.println("Creating driver");
			System.setProperty("webdriver.chrome.driver","../Gurukul/driver/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized"); // open Browser in maximized mode
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			options.addArguments("--disable-gpu"); // applicable to windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			driver = new ChromeDriver(options);
		}
		
		return driver;
	}
}
