package Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.HomePage;

public class SearchWithInvalidAddressFieldValidation extends TestBase {

	@DataProvider(name = "data")
	public Object[][] UserData() throws IOException {

		ExcelReader ER = new ExcelReader();
		return ER.getExcelData(1);

	}

	@Test(dataProvider = "data")
	public void CheckingSearchFieldValidaion(String Address)

	{

		HomePage HP = new HomePage(driver);
		HP.AcceptCookies(driver);
		HP.PassAddressToAdressField(driver, Address);

		HP.ClickOnSearchButton(driver);
		HP.CheckThatConfirmAddressPopUpisDisplayed(driver);

		HP.ClosingConfirmAddressPopUp(driver);
		HP.ClickOnSearchButton(driver);
		HP.CheckingAddressFieldVaidation(driver);		


	}

}
