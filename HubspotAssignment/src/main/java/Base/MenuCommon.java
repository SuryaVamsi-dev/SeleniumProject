package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Pages.LoginPage;
import Pages.SearchPage;

public class MenuCommon extends BasePage {
	
	public MenuCommon(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[@id='dropdownLangauge']")
	public WebElement ClickLanguage;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	public WebElement home;
	
	@FindBy(xpath="//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/div[1]/a[1]")
	public WebElement myacc;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	public WebElement logout;
	
	public LoginPage Logout() {
		
		myacc.click();
		logout.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public SearchPage Home() {
		
		home.click();
		return PageFactory.initElements(driver, SearchPage.class);
	}
	
	

}
