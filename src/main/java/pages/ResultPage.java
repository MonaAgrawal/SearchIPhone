package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

public class ResultPage {
	
	@FindBy(xpath="//table[@id='HLCXComparisonTable']/tbody")
	public WebElement table;
	
WebDriver driver;
private CommonUtils commonUtils;
private ModelDetails modelDetails;
private ModelDetails modelDetails1;
private ModelDetails modelDetails2;
String myLink = "";
int cellNumber=0;
public List<WebElement> trows;
public List<WebElement> tcells;

	public ResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		commonUtils =new CommonUtils(driver);
		
	}
	
			
	public void getLink() {
		boolean found = false;
		while(!found) {
			commonUtils.waitUntilpresenceOfAllElementsLocated(By.xpath("//h3[@class='r']/a"));
			List<WebElement> links = driver.findElements(By.xpath("//h3[@class='r']/a"));
			for (WebElement link : links) {
				if(link.getAttribute("href").contains("www.amazon.co")) {
					myLink= link.getAttribute("href");
					commonUtils.waitForElementToBeClickable(link);
					link.click();
					found = true;
					break;
				}
			}
			if(!found) {
				commonUtils.waitForElementToBeClickableByLocator(By.xpath("//a[@id='pnnext']"));
				driver.findElement(By.xpath("//a[@id='pnnext']")).click();
				links.clear();
				}
			}
		}
	
	public String getModelURL() {
		return myLink;
	}
	
	public void compareProduct() {
		List<ModelDetails> pojo = new ArrayList<ModelDetails>();
		trows= table.findElements(By.tagName("tr"));
		tcells= trows.get(11).findElements(By.tagName("td"));
		String maxStorageSpace=tcells.get(0).getText();
		modelDetails = new ModelDetails(driver.findElement(By.xpath(getLocator(0))).getText(),trows.get(4).findElements(By.tagName("td")).get(0).getText());
		pojo.add(modelDetails);
		for(int i= 1;i<tcells.size();i++) {
			int diff = tcells.get(i).getText().compareTo(maxStorageSpace);
			if(diff==0) {
				 modelDetails1 = new ModelDetails(driver.findElement(By.xpath(getLocator(i))).getText(),trows.get(4).findElements(By.tagName("td")).get(i).getText());
				pojo.add(modelDetails1);
				if(modelDetails.getName().contains("iPhone")) {
					maxStorageSpace=tcells.get(i-1).getText();
					cellNumber=i-1;
				}else if(modelDetails1.getName().contains("iPhone")) {
					maxStorageSpace=tcells.get(i).getText();
					cellNumber=i;
				}
			}
			else if(diff>0) {
				pojo.clear();
				modelDetails2 = new ModelDetails(driver.findElement(By.xpath(getLocator(i))).getText(),trows.get(4).findElements(By.tagName("td")).get(i).getText());
				pojo.add(modelDetails2);
				maxStorageSpace=tcells.get(i).getText();
				cellNumber=i;
			}
		}
	}
		
	public void setModelDetails() {
		modelDetails=new ModelDetails(driver.findElement(By.xpath(getLocator(cellNumber))).getText(),trows.get(4).findElements(By.tagName("td")).get(cellNumber).getText());
	}
	
	public ModelDetails getModelObject() {
		return modelDetails;
		
	}
	
	public String getLocator(int col) {
		switch (col) {
		case 0:
			return "//div[@id='comparison_title']/span";
		case 1:
			return "//div[@id='comparison_title0']/span";
		case 2:
			return "//div[@id='comparison_title1']/span";
		case 3: 
			return "//div[@id='comparison_title2']/span";
		default:
			return "there is error";
		}
		
	}
		
	}


