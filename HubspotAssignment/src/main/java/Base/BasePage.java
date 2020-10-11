package Base;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Pages.LandingPage;
import Utilities.DateUtils;
import Utilities.ExtentReportmanager;

public class BasePage {

	
	public WebDriver driver;
	
	public ExtentReports report= ExtentReportmanager.getReportInstance();
	public ExtentTest Logger;
	public void Invoke() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public LandingPage OpenWebsite() {
		
		driver.get("https://phptravels.net/");
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	public void GetTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void  ReportFail(String report) {
		Logger.log(Status.FAIL, report);
		//takeSS;
		Assert.fail(report);
	}
	
	public void takeSS() {
		
		TakesScreenshot take=(TakesScreenshot)driver;
		File srcfile=take.getScreenshotAs(OutputType.FILE);
		File destFile=new File(System.getProperty("user.dir")+"\\test-output\\"+DateUtils.getTymStamp()+".png");
		try {
			FileUtils.copyFile(srcfile,destFile);
			Logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\test-output\\"+DateUtils.getTymStamp()+".png");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void reportPass(String report) {
		
		Logger.log(Status.PASS, report);
	}
	
	
	
	
	@AfterMethod
	public void FlushReports() {
		report.flush();
	}
}
