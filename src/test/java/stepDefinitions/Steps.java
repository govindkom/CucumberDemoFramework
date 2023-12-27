package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;


public class Steps extends BaseClass{
	
	@Before
	public void setup() throws IOException {

		conprop= new Properties();
		FileInputStream configPropFile= new FileInputStream("config.properties");
		conprop.load(configPropFile);
		
		String br= conprop.getProperty("browser");
		
		if(br.equals("chrome")) {
			//System.setProperty("webdriver.chrome..driver", conprop.getProperty("chromepath"));
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if(br.equals("firefox")) {
			//System.setProperty("webdriver.gecko..driver", conprop.getProperty("firefoxpath"));
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(br.equals("ie")) {
			//System.setProperty("webdriver.ie..driver", conprop.getProperty("iepath"));
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
	}
	
	
	@Given("user Launch Chrome Broswer")
	public void user_launch_chrome_broswer() {
		
//Logger logger = Logger.getLogger("noCommerce");
//       PropertyConfigurator.configure("Log4j.properties");
		
		lp= new LoginPage(driver);
	    
	}

	@When("user opens URL {string}")
	public void user_opens_url(String url) {
	  driver.get(url);
	  driver.manage().window().maximize(); 
	}

	@When("user enters Email as {string} and password as {string}.")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    lp.setUsername(email);
	    lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		lp.clickLogin();
	    
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		// String title=driver.getTitle();

		if (driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			System.out.println(driver.getTitle());
			Assert.assertEquals(title, driver.getTitle());
		}

	}

	@When("user click on Logout")
	public void user_click_on_logout() throws Exception {
		Thread.sleep(2000);
		lp.logOut();
	    
	}
	
//	@When("user enters Email as {string} and password as {string}")
//	public void user_enters_email_as_and_password_as(String email, String password) {
//		lp.setUsername(email);
//	    lp.setPassword(password);
//	}


// Customer featiure file step defination
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		custpage=new CustomersPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", custpage.getPageTitle());
		Thread.sleep(2000);
	}

	@When("user click on customers Menu")
	public void user_click_on_customers_menu() throws Throwable {
	    custpage.clickOnCustomersMenu();
	    Thread.sleep(2000);
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws Exception {
	    custpage.clickOnCustomersMenuItem();
	    Thread.sleep(2000);
	}

	@When("click on Add new Button")
	public void click_on_add_new_button() throws InterruptedException {
	    custpage.clickOnAddNew();
	    Thread.sleep(2000);
	}

	@Then("user can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", custpage.getPageTitle());
	    Thread.sleep(2000);
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws Exception {
		String email=randomestring()+"@gmail.com";
		custpage.setEmail(email);
		custpage.setPassword("test123");
		custpage.selectGender("Male");
		custpage.setManagerOfVendors("Vendor 2");
		custpage.setFirstName("paven");
		custpage.setLastName("kumar");
	    Thread.sleep(3000);
		
	    
	}

	@When("click on save button")
	public void click_on_save_button() throws Exception {
	    custpage.clickOnSaveButton();
	    Thread.sleep(3000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText());
	    //Assert.assertEquals(msg, driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText());
	}
	
	@When("Enter customer Email")
	public void enter_customer_email() throws Exception {
		seacustpage=new SearchCustomerPage(driver);
		seacustpage.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws Throwable {
		seacustpage.clickSearch();
		Thread.sleep(2000);
	}

	@Then("user should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() throws Throwable {
		boolean status=seacustpage.searchCustomersByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertTrue(status);
		Assert.assertEquals(true, status);
	}

// steps for searching e;lement through fname and lastnamew
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() throws InterruptedException {
		seacustpage=new SearchCustomerPage(driver);
		seacustpage.setFirstName("Victoria ");
	}

	@When("enter customer LastName")
	public void enter_customer_last_name() throws Exception {
		seacustpage.setLastName("Terces");
	}

	@Then("user should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		boolean status=seacustpage.searchCustomersByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}


	@Then("close Browser")
	public void close_browser() {
		
	    driver.close();
	}



	
}


