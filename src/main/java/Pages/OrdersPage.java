package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrdersPage extends PageBase{

	public OrdersPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath="/html/body/div[8]/div/div/div/div/div/div[2]/span[2]/button")
	WebElement OkButtonForOfferPopUp ; 
	
	@FindBy(xpath="	//*[@id=\"__next\"]/div/div/div[2]/div/div[1]/div/div[1]/div/div[1]/div[1]/span/button/div/div[2]/div/div")
	WebElement DisplayedAddress ; 
	
	
	public void ValidateTheAddress (WebDriver driver,String Address)
	{
		
		
		WebDriverWait w2 = new WebDriverWait(driver, 10);
		w2.until(ExpectedConditions.visibilityOf(OkButtonForOfferPopUp));
		
		Actions MoveToAdressField = new Actions(driver);
		MoveToAdressField.moveToElement(OkButtonForOfferPopUp).click().perform();
		
		Assert.assertTrue(DisplayedAddress.getText().contains(Address));
		
	}
	
	
}
