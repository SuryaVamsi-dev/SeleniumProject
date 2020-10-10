package TestCases;

import org.testng.annotations.Test;

import Base.BasePage;
import Pages.LandingPage;

public class Test1 extends BasePage {

	
	@Test
	public void Tes() throws InterruptedException {
		
		Invoke();
		LandingPage lp=OpenWebsite();
		lp.SignIn("surya.vamsi.1432@gmail.com", "9963@Hubspot");
	}
}
