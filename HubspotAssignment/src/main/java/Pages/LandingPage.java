package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import Base.MenuCommon;

public class LandingPage extends BasePage {
	
	public MenuCommon menu;
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		menu=PageFactory.initElements(driver, MenuCommon.class);
	}
	
	@FindBy(xpath="//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/a[1]")
	public WebElement currency;
	
	@FindBy(xpath="//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/div[1]/div[1]/div[1]/a")
	public List<WebElement> selectCurrency;
	
	@FindBy(xpath="//body[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/div[1]/a[1]")
	public WebElement myAcc;
	
	@FindBy(xpath="//header/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/a[1]") 
	public WebElement LoinBtn;
	
	
	public void ChangeCurrency() {
		int i=0;
		currency.click();
		while(!selectCurrency.get(i).getText().equalsIgnoreCase("EUR")) {
			i++;
		}
		
		selectCurrency.get(i).click();
		
	}
	
	public LoginPage login() {
		
		myAcc.click();
		LoinBtn.click();
		return PageFactory.initElements(driver,LoginPage.class);
	}
	
	public MenuCommon getmenu() {
		
		return menu;
	}
	
	
	

}
