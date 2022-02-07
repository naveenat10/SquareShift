package cnacodechallenge;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Naveena Tholapi
 */

public class BaseCna {
	
	public static ChromeDriver driver;
	
	@BeforeMethod
	public void preCondition() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		
    }
	
	@AfterMethod
	public void postCondition() {
		driver.close();
		
	}
}
