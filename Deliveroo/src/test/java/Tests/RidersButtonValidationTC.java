package Tests;

import org.testng.annotations.Test;

import Pages.HomePage;

public class RidersButtonValidationTC extends TestBase {

	
	@Test
	public void RidersButtonValidation() throws InterruptedException {



		HomePage HP = new HomePage(driver);
		HP.AcceptCookies(driver);
		HP.selectUnitedKingdomCountry(driver);

		HP.CheckRidersButtonFunctionality(driver);



	}

}
