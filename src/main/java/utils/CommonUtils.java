package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CommonUtils {

	 WebDriver driver;
	 public WebDriverWait wait;
	 private static int timeout = 10;
	 private  final Logger LOG = LoggerFactory.getLogger(CommonUtils.class);
	 private String emptySTring="";
	public CommonUtils(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void navigateToURL(String url) {
		try {
			driver.get(url);
			driver.manage().window().maximize();
						} catch (Exception e) {
				LOG.info("URL did not load " + url);
		}}
			
	
	public String getCurrentURL() {
		try {
			return driver.getCurrentUrl();
		}catch(Exception e) {
			LOG.info("Current URL is Invalid\"");
		}
		return emptySTring;
			}
	
	public String getCurrentTitle() {
		try {
			return driver.getTitle();
		}catch(Exception e) {
			LOG.info("Current URL is Invalid");
		}
		return emptySTring;
			}
	
	public void waitForElementToBeClickable(WebElement locator) {
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            LOG.info("The following element is not clickable: " + locator);
        }
    }
	public void waitUntilpresenceOfAllElementsLocated(By locator){
        try {
            wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.presenceOfElementLocated((By) locator));
        } catch (Exception e) {
            LOG.info("The following element is not present: " + locator);
        }}
	
        public void waitForElementToBeClickableByLocator(By locator) {
            try {
                wait = new WebDriverWait(driver, timeout);
                wait.until(ExpectedConditions.elementToBeClickable((By)locator));
            } catch (Exception e) {
               LOG.info("The following element is not clickable: " + locator);
            }
        }  
   
}
