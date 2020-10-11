package TestCases;

import java.text.ParseException;

import org.testng.annotations.Test;

import Base.BasePage;
import Base.MenuCommon;
import Pages.LandingPage;
import Pages.LoginPage;
import Pages.ResultPage;
import Pages.SearchPage;

public class Test1 extends BasePage{

	LandingPage lp;
	LoginPage lop;
	MenuCommon mc;
	SearchPage sp;
	ResultPage rp;
	
	
	@Test
	public void Tes() throws InterruptedException, ParseException {
		Logger=report.createTest("PHPTravels");
		
		Invoke();
		lp=OpenWebsite();
		lp.ChangeCurrency();
		
//		mc=lp.getmenu();
//		lop=mc.Logout();
		Thread.sleep(3000);
		lop=lp.login();
		//lop.SignIn("surya.vamsi.1432@gmail.com", "qwertyuiop");
		lop.Signup("Surya","Vamsi","1234567890","automating@gmail.com","asdfghjkl");
		Thread.sleep(2000);
		mc=lop.getmenu();
		sp=mc.Home();
		sp.Search();
		sp.inCalender("3/11/2020");
		sp.outCalender("11/11/2021");
		sp.Adults(5);
		rp=sp.GoSearch();
		rp.Filter("5");
		
		
	}
}
