package Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> threadDriver=new ThreadLocal<WebDriver>(){@Override protected synchronized WebDriver initialValue(){return initDriver();}};


	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		return threadDriver.get();
	}

	public static WebDriver initDriver() {
		WebDriver driver = null;
		String constantBrowser = "CHROME";
		switch (constantBrowser) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/resources/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			// Disable extensions and hide infobars
			options.addArguments("--disable-extensions");
			options.addArguments("disable-infobars");

			Map<String, Object> prefs = new HashMap<String, Object>();

			// Enable Flash
			prefs.put("profile.default_content_setting_values.plugins", 1);
			prefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
			prefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);

			// Hide save credentials prompt
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			// driver = new ChromeDriver();
			break;

		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/resources/geckodriver.exe");
			FirefoxOptions profile = new FirefoxOptions();
			// As 0 is to disable, I used 1. I don"t know what to use.
			profile.addPreference("dom.ipc.plugins.enabled.libflashplayer.so", "true");
			driver = new FirefoxDriver(profile);
			// driver = new FirefoxDriver ();
			break;

		case "IE":
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	public static void killDriver(){
		WebDriver driver = getDriver();
		if(driver != null) {
			driver.quit();
			driver = null;
		}
		if(threadDriver != null) {
			threadDriver.remove();
		}
	}
}
