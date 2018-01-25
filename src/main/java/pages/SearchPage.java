package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;

public class SearchPage {
	
	WebDriver driver;
	private CommonUtils commonUtils;
	@FindBy(id="lst-ib")
	public WebElement inputSearchItem;
	
	@FindBy(name="btnK")
	public WebElement SearchButton;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils =new CommonUtils(driver);
	}
	
	public void navigateToGooglePage() {
		String url= "https://www.google.co.uk";
		commonUtils.navigateToURL(url);
		
		}
	
	public void searchIPhone(String IPhone) {
		inputSearchItem.sendKeys(IPhone);
		commonUtils.waitForElementToBeClickable(SearchButton);
		SearchButton.click();
	}
	
		
		}
	
	
	

