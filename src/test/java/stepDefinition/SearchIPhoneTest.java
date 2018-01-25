package stepDefinition;


import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ResultPage;
import pages.SearchPage;
import utils.DriverUtils;


public class SearchIPhoneTest extends DriverUtils
{
	 
	WebDriver driver;
	DriverUtils driverUtils;
	SearchPage searchPage;
	ResultPage resultPage;
	private  final Logger LOG = LoggerFactory.getLogger(SearchIPhoneTest.class);
	public SearchIPhoneTest()
	{
			System.setProperty("webdriver.gecko.driver", "C:\\Mona\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = getDriver();
			driverUtils = new DriverUtils();
			searchPage = new SearchPage(driver);
			resultPage = new ResultPage(driver);
			}
	
@Given("^Launch the browser and open Google Website$")
public void isGooglePageLoaded() {
		searchPage.navigateToGooglePage();
		try {
		Assert.assertEquals("Google", driver.getTitle());}
		catch(Exception e) {
			LOG.info("Invalid URL");
			
		}
				}

@When("^User enters search criteria as (.*) and click on Google Search button$")
public void enterSearchItem(String IPhone) {
	searchPage.searchIPhone("IPhone");
	}

@Then("^IPhone - Google Search page get loaded$")
public void isGoogleSearchPagesLoaded() {
		try {
		assertTrue(driver.getTitle().contains("Google Search"));}
		catch(Exception e) {
			LOG.info("Invalid URL");
		}
}

@And("^Clicks on the link pointing to amazon.co.uk$")
public void navigateThroughLinks() {
	resultPage.getLink();
}

@Then("^Model URL should contains (.*) and get printed$")
public void modelURLPointsToAmazon(String amazon) {
	try {
		assertTrue(resultPage.getModelURL().contains("amazon"));
		System.out.println("URL of Largest Model is: " + resultPage.getModelURL());
	} catch (Exception e) {
		LOG.info("Clicked on incorrect URL");
	}
}

@And("^Name and price of the largest Model should get printed$")
public void getNameAndPriceOfModel() {
	resultPage.compareProduct();
	//resultPage.chk();
	resultPage.setModelDetails();
	System.out.println(resultPage.getModelObject());
		}

@And("^Price should not be greater than 1000$")
public void checkPriceIsLess() throws Exception {
	if(Integer.parseInt(resultPage.getModelObject().getPrice().split("\\.")[0].replaceAll("\\D", ""))<1000)
		System.out.println("Product price is less than £1000.00");
	else 
		System.out.println("Product price is not less than £1000.00");
		}
}



