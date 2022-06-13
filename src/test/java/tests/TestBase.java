package tests;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import productFunctions.Constants;


public class TestBase {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static TCResult result;

	@BeforeMethod(alwaysRun = true)
	public static void beforMethod() {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "latest");
		caps.setCapability("browserstack.local", "false");
		caps.setCapability("browserstack.selenium_version", "4.1.2");
		
		
		driver = new ChromeDriver(caps);
		driver.manage().window().maximize();	
		
		driver.manage().timeouts().implicitlyWait(Constants.TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Constants.TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(Constants.TimeOut, TimeUnit.SECONDS);
	
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TimeOut));
		result = new TCResult();

		//driver.get(Constants.pageUrl);
	}

	
	@AfterMethod()
	public void afterMethod(ITestResult pResult) {

		switch (pResult.getStatus()) {
		case ITestResult.SUCCESS:
			System.out.println("Result: PASSED.");
			break;
		case ITestResult.FAILURE:
			System.out.println("Result: FAILED.");

			break;
		case ITestResult.SKIP:
			System.out.println("Result: SKIPPED.");
			break;
		}
		try {
			driver.close();
			driver.quit();
		} catch (Exception e) 
		{

		}

	}

//	@AfterSuite()
//	public void afterTest() {
//		driver.quit();
//	}

}
