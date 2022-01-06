package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id=\"location-search\"]")
	WebElement AdressField ; 

	@FindBy(xpath="//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div/div[1]/div/div[2]/div/div/div/div/div/div[2]/span/button")
	WebElement SearchButton ;

	@FindBy(xpath="//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div/div[1]/div/div[2]/div/div/div/div[2]/ul/ul[1]/li/button/div/div/div[2]")
	WebElement AdressSelection;

	@FindBy(id="onetrust-accept-btn-handler")
	WebElement AcceptAllCookiesButton ; 

	@FindBy(xpath="//*[@id=\"onetrust-close-btn-container\"]/button")
	WebElement RejectCookiesButton ; 

	@FindBy(xpath="//*[@id=\"modal-header-title\"]/span")
	WebElement ConfirmAddressPopUpTitle ;


	@FindBy(xpath="/html/body/div[9]/div/div/div/div[1]/div/div[1]/div/div[2]/button")
	WebElement ConfirmAddressPopCloseButton;

	@FindBy(xpath="//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[3]/div/div[1]/div/div[2]/div/div/div/div[1]/p")
	WebElement CheckingAddressFieldVaidation;


	// Menu Variables

	@FindBy(xpath="//*[@id=\"countries-picker\"]")
	WebElement CountriesPickerDropDownList;
	
	@FindBy(xpath="	//*[@id=\"languages-picker\"]")
	WebElement LanguageDropDownList;

	@FindBy(xpath="	//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[1]/div/div/div/div/ul/li[1]/button/span/span[2]/span")
	WebElement MenuButton;
	
	
	// Rider Variables

	@FindBy(xpath="	//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[1]/div/div/div/div/ul/li[3]/div/button/span")
	WebElement PartnerWithUsButton;
	
	@FindBy(partialLinkText="Riders")
	WebElement RidersButton;
	
	@FindBy(xpath="//*[@id=\"__layout\"]/div/section/section[1]/div[2]/div[1]/h1")
	WebElement FindWorkThatSuitsYouHeader;


	
	
	public void CheckRidersButtonFunctionality(WebDriver driver) throws InterruptedException{
		
		
		WebDriverWait w1 = new WebDriverWait(driver, 5);
		w1.until(ExpectedConditions.visibilityOf(PartnerWithUsButton));
		PartnerWithUsButton.click();
		RidersButton.click();
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().equals("https://deliveroo.co.uk/"));
		Thread.sleep(3000);
		if(AcceptAllCookiesButton.isDisplayed()){
			WebDriverWait w2 = new WebDriverWait(driver, 5);
			w2.until(ExpectedConditions.visibilityOf(AcceptAllCookiesButton));
			AcceptAllCookiesButton.click();
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");

		Assert.assertTrue(FindWorkThatSuitsYouHeader.getText().contains("Find work that suits you"));
		
	}
	
	public void selectLanguage(WebDriver driver){

		MenuButton.click();

		Actions ac = new Actions(driver);
		ac.moveToElement(LanguageDropDownList).build().perform();
		
		Select Country = new Select(LanguageDropDownList);
		Country.selectByVisibleText("Français");
		
		WebDriverWait w1 = new WebDriverWait(driver, 5);
		w1.until(ExpectedConditions.visibilityOf(AdressField));
		Assert.assertTrue(SearchButton.getText().contains("Rechercher"));
		
		
	}
	
	public void selectFranceCountry(WebDriver driver){

		MenuButton.click();

		Actions ac = new Actions(driver);
		ac.moveToElement(CountriesPickerDropDownList).build().perform();
		
		Select Country = new Select(CountriesPickerDropDownList);
		Country.selectByVisibleText("France");
		
	}
	
	public void selectUnitedKingdomCountry(WebDriver driver){

		MenuButton.click();

		Actions ac = new Actions(driver);
		ac.moveToElement(CountriesPickerDropDownList).build().perform();
		
		Select Country = new Select(CountriesPickerDropDownList);
		Country.selectByVisibleText("United Kingdom");
		
	}
	

	public void AcceptCookies(WebDriver driver){

		WebDriverWait w1 = new WebDriverWait(driver, 5);
		w1.until(ExpectedConditions.visibilityOf(AcceptAllCookiesButton));

		AcceptAllCookiesButton.click();
	}


	public void RejectCookies(WebDriver driver){

		WebDriverWait w1 = new WebDriverWait(driver, 5);
		w1.until(ExpectedConditions.visibilityOf(RejectCookiesButton));

		RejectCookiesButton.click();
	}


	public void PassAddressToAdressField(WebDriver driver,String AdressToBeInserted){

		WebDriverWait w2 = new WebDriverWait(driver, 5);
		w2.until(ExpectedConditions.visibilityOf(AdressField));

		Actions MoveToAdressField = new Actions(driver);
		MoveToAdressField.moveToElement(AdressField).click().perform();
		AdressField.sendKeys(AdressToBeInserted);
	}


	public void SearchWithValidAdress (WebDriver driver)
	{


		WebDriverWait w3 = new WebDriverWait(driver, 5);
		w3.until(ExpectedConditions.visibilityOf(AdressSelection));
		w3.until(ExpectedConditions.elementToBeClickable(AdressSelection));
		AdressSelection.click();




	}



	public void ClickOnSearchButton (WebDriver driver)
	{
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.elementToBeClickable(SearchButton));
		SearchButton.click();

	}


	public void CheckThatConfirmAddressPopUpisDisplayed (WebDriver driver)
	{
		WebDriverWait w3 = new WebDriverWait(driver, 5);
		w3.until(ExpectedConditions.visibilityOf(ConfirmAddressPopUpTitle));
		Assert.assertTrue(ConfirmAddressPopUpTitle.getText().contains("Confirm your address"));


	}

	public void ClosingConfirmAddressPopUp(WebDriver driver)
	{
		WebDriverWait w3 = new WebDriverWait(driver, 5);
		w3.until(ExpectedConditions.visibilityOf(ConfirmAddressPopCloseButton));
		ConfirmAddressPopCloseButton.click();

	}




	public void CheckingAddressFieldVaidation(WebDriver driver){

		Assert.assertTrue(CheckingAddressFieldVaidation.getText().contains("Choose your address"));

	}
}
