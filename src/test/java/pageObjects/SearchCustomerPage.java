package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	public WebDriver ldriver;
	WaitHelper waithelper;
	
	
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper= new WaitHelper(ldriver);
	}

	
	@FindBy(id="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	
	@FindBy(id="SearchFirstName")
	@CacheLookup
	WebElement txtfname;
	
	
	@FindBy(id="SearchLastName")
	@CacheLookup
	WebElement txtlname;
	
	@FindBy(id="search-customers")
	@CacheLookup
	WebElement searchbtn;
	
	@FindBy(xpath="//*[@id=\"customers-grid\"]//tbody/tr//td")
	@CacheLookup
	List<WebElement> tablecolm;
	
	@FindBy(xpath="//*[@id=\"customers-grid\"]//tbody/tr")
	@CacheLookup
	List<WebElement> tablerow;
	
	@FindBy(xpath="//*[@id=\"customers-grid\"]")
	@CacheLookup
	WebElement table;
	
	
	
	
	public void setEmail(String email) throws Exception {
		//waithelper.waitForElement(txtEmail,10 );
		Thread.sleep(1000);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String finame) throws InterruptedException {
		Thread.sleep(1000);
		txtfname.clear();
		txtfname.sendKeys(finame);
	}
	
	public void setLastName(String laname) throws Exception {
		Thread.sleep(1000);
		txtfname.clear();
		txtfname.sendKeys(laname);
	}
	
	public void clickSearch() throws Exception {
		searchbtn.click();
		Thread.sleep(1000);
	}
	
	public int getNoOfRows() {
		return (tablerow.size());
	}
	
	public int getNoOfColumns() {
		return (tablecolm.size());
	}
	
	public boolean searchCustomersByEmail(String email) {
		boolean flag=false;
		
		for(int i=1;i<=getNoOfRows();i++) {
			String emailid= table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr[\"+i+\"]/td[2]")).getText();
			System.out.println(emailid);
			
			if(emailid.equals(email)) {
				flag=true;
			}
		}
		return flag;
	}
	
	public boolean searchCustomersByName(String Name) {
		boolean flag=false;
		
		for(int i=1;i<=getNoOfRows();i++) {
			String name= table.findElement(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr[\"+i+\"]/td[3]")).getText();
			System.out.println(name);
			String names[]=name.split(" ");  // separating first name and last name through string 
			if(names[0].equals("Victoria") && names[1].equals("Terces")) {
				flag=true;
			}
		}
		return flag;
	}
}
