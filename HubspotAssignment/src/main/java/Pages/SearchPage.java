package Pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BasePage;
import Base.MenuCommon;

public class SearchPage extends BasePage {
	public MenuCommon menu;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		menu = PageFactory.initElements(driver, MenuCommon.class);
	}

	
	@FindBy(xpath = "//div[@id='s2id_autogen16']/a")
	public WebElement search;

	@FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/input[1]")
	public WebElement input;
	
	@FindBy(xpath="//div[contains(text(),'Hotels')]//parent::li/ul/li[1]/div")
	public WebElement hotels;
	
	@FindBy(xpath="//div[contains(text(),'Locations')]//parent::li/ul/li[1]/div")
	public WebElement Locations;
	
	@FindBy(xpath="//input[@id='checkin']")
	public WebElement clickCheckin;

	@FindBy(xpath = "//body/div[@id='datepickers-container']/div[1]/nav[1]/div[2]/i[1]")
	public WebElement Year;

	@FindBy(xpath = "//body/div[@id='datepickers-container']/div[1]/nav[1]/div[2]")
	public WebElement Month;

	@FindBy(xpath = "//body/div[@id='datepickers-container']/div[2]/nav[1]/div[2]")
	public WebElement outMonth;

	@FindBy(xpath = "//body/div[@id='datepickers-container']/div[2]/nav[1]/div[3]")
	public WebElement outforwardArrow;

	@FindBy(xpath = "//body/div[@id='datepickers-container']/div[2]/nav[1]/div[1]")
	public WebElement outBackArrow;

	@FindBy(xpath = "//body/div[@id='datepickers-container']/div[1]/nav[1]/div[3]")
	public WebElement forwardArrow;

	@FindBy(xpath = "//body/div[@id='datepickers-container']/div[1]/nav[1]/div[1]")
	public WebElement BackArrow;

	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]")
	public WebElement plus;

	@FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/button[2]")
	public WebElement minus;

	 @FindBy(xpath="//body/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[4]/button[1]")
	 public WebElement Search;
	
	// @FindBy(xpath="")
	// public WebElement minus;
	//
	// @FindBy(xpath="")
	// public WebElement minus;
	//

	public void Search() throws InterruptedException {

		search.click();
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		// WebElement element = wait.until(
		// ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='']")));
		input.sendKeys("Dubai");
		Thread.sleep(2000);
		
		//input.sendKeys(Keys.TAB);
		
		//hotels.click();
		Locations.click();

	}

	public void inCalender(String date) throws ParseException {
		clickCheckin.click();
		Date currentdate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Date Expected = dateFormat.parse(date);
		String split[] = date.split("/");
		String sdate = split[0];
		String day = new SimpleDateFormat("dd").format(Expected);
		String month = new SimpleDateFormat("MMMM").format(Expected);
		String year = new SimpleDateFormat("yyyy").format(Expected);

		String ExpectedMY = month + ",\n" + year;
		while (true) {

			String disply = Month.getText();
			System.out.println(ExpectedMY + " - " + disply);
			if (disply.equals(ExpectedMY)) {
				System.out.println("inside Equal");

				WebElement daySelect = driver.findElement(
						By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[text()='" + (sdate) + "']"));
				System.out.println(daySelect.getText());
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", daySelect);
				break;

			} else if (Expected.compareTo(currentdate) > 0) {
				forwardArrow.click();
			} else {
				BackArrow.click();
			}

		}

	}

	public void outCalender(String date) throws ParseException {

		Date currentdate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		Date Expected = dateFormat.parse(date);
		String split[] = date.split("/");
		String sdate = split[0];
		String day = new SimpleDateFormat("dd").format(Expected);
		String month = new SimpleDateFormat("MMMM").format(Expected);
		String year = new SimpleDateFormat("yyyy").format(Expected);

		String ExpectedMY = month + ",\n" + year;
		while (true) {

			String disply = outMonth.getText();
			System.out.println(ExpectedMY + " - " + disply);
			if (disply.equals(ExpectedMY)) {
				System.out.println("inside Equal");

				WebElement daySelect = driver.findElement(
						By.xpath("//body[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[text()='" + (day) + "']"));
				System.out.println(daySelect.getText());
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click()", daySelect);
				break;

			} else if (Expected.compareTo(currentdate) > 0) {
				outforwardArrow.click();
			} else {
				outBackArrow.click();
			}

		}

	}

	public void Adults(int num) {

		int def = 2;
		System.out.println("going into while");
		while (num!=def) {
			System.out.println("inside while");
			if (num < def) {
				//System.out.println("inside <");
					def -=1;
					minus.click();
					//System.out.println(num+"  "+def);
				
			} else if (num > def) {
				
				//System.out.println("inside >");
					def +=1;
					plus.click();
					//System.out.println(num+"  "+def);
			}

		}

	}
	
	public ResultPage GoSearch() {
		System.out.println("inside search");
		Search.click();
		return PageFactory.initElements(driver, ResultPage.class);
	}

}
