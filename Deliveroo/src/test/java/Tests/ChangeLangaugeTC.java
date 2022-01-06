package Tests;

import org.testng.annotations.Test;

import Pages.HomePage;

public class ChangeLangaugeTC extends TestBase {


	@Test
	public void ChangeLanguageSuccessfully() throws InterruptedException {
	
		
		
		HomePage HP = new HomePage(driver);
		HP.AcceptCookies(driver);
		HP.selectFranceCountry(driver);
		HP.selectLanguage(driver);
		
	}

}
