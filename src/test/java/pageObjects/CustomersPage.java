package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomersPage {
	
	public WebDriver ldriver;
	
	public CustomersPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}

	By lnk_customer_menu = By.xpath("(//a[@class='nav-link'])[21]");
	By lnk_customer_menuitem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	
	By add_new_btn=By.xpath("//a[normalize-space()='Add new']");
	
	By add_new_custPage=By.xpath("//h1[@class=\"float-left\"]");
	
	

	By txtemail=By.id("Email");
	By txtPassword=By.id("Password");
	By FirstName=By.id("FirstName"); 
	By LastName=By.id("LastName");  
	By Gender_Male=By.id("Gender_Male"); 
	By Gender_feMale=By.id("Gender_Female"); 
	
	By DateOfBirth=By.id("DateOfBirth");     
	By Company=By.id("Company");
	By IsTaxExempt=By.id("IsTaxExempt");
	By news_letter=By.xpath("(//div[@role=\"listbox\"])[1]");  
	By your_store=By.xpath("//li[contains(text(),'Your store name')]");    
	By test_store=By.xpath("//li[contains(text(),'Test store 2')]"); 
	By cust_role=By.xpath("(//div[@role=\"listbox\"])[2]");
	
	By administration=By.xpath("(//li[contains(text(),'Administrators')]");
	By forumMod=By.xpath("(//li[contains(text(),'Forum Moderators')]");
	By geust=By.xpath("((//li[contains(text(),'Guests')])[2]");
	By Registered=By.xpath("(//li[contains(text(),'Registered')])[2]");
	By Vendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	
	
	By select_classid=By.id("VendorId");  
	By admin_cmnt=By.id("AdminComment");
	By save_btn=By.xpath("//button[@name=\"save\"]");
	
	
	// Actions Method
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void clickOnCustomersMenu() {
		ldriver.findElement(lnk_customer_menu).click();
	}
	
	public void clickOnCustomersMenuItem() {
		ldriver.findElement(lnk_customer_menuitem).click();
	}
	
	public void clickOnAddNew() {
		ldriver.findElement(add_new_btn).click();
	}
	
	public void setEmail(String email) {
		ldriver.findElement(txtemail).sendKeys(email);
	}
	
	public void setPassword(String password) {
		ldriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setManagerOfVendors(String value) {
		Select drp= new Select(ldriver.findElement(select_classid));
		drp.selectByVisibleText(value);
		
	}
	
	public void selectGender(String gender) {
		if(gender.equals("male")) {
			ldriver.findElement(Gender_Male).click();
		}
		else if(gender.equals("Female")){
			ldriver.findElement(Gender_feMale).click();
		}
		else
		{
			ldriver.findElement(Gender_Male).click();
		}
	}
	
	public void setFirstName(String fname) {
		ldriver.findElement(FirstName);
	}
	
	public void setLastName(String Lname) {
		ldriver.findElement(LastName);
	}
	
	public void clickOnSaveButton() {
		ldriver.findElement(save_btn).click();
	}
	
}

