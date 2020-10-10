package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(id="username")
	public WebElement Usrname;
	
	@FindBy(id="password")
	public WebElement Pwd;
	
	@FindBy(id="remember")
	public WebElement check;
	
	@FindBy(id="loginBtn")
	public WebElement LoinBtn;
	
	public void SignIn(String name,String pawd) {
		driver.findElement(By.id("username")).sendKeys(name);
		Usrname.sendKeys(name);
		Pwd.sendKeys(pawd);
		check.click();
		LoinBtn.click();
	}
	
}
