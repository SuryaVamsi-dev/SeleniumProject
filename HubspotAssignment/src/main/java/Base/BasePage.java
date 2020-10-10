package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Pages.LandingPage;

public class BasePage {

	
	public WebDriver driver;
	
	public void Invoke() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public LandingPage OpenWebsite() {
		
		driver.get("https://app.hubspot.com/login");
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	public void GetTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}
}
