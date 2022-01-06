package Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.HomePage;
import Pages.OrdersPage;

public class SearchForValidAddressTC extends TestBase {

	@DataProvider(name = "data")
	public Object[][] UserData() throws IOException {

		ExcelReader ER = new ExcelReader();
		return ER.getExcelData(0);

	}
	
	@Test(dataProvider = "data")
	public void ValidatingAdressField(String Address) {


		HomePage HP = new HomePage(driver);
		HP.AcceptCookies(driver);
		HP.PassAddressToAdressField(driver, Address);
		HP.SearchWithValidAdress(driver);
		
		OrdersPage OP = new OrdersPage(driver);
		OP.ValidateTheAddress(driver,Address);
	}


	

}
