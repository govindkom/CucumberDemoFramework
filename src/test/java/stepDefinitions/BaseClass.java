package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.CustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;


public class BaseClass {

	public WebDriver driver;
	public LoginPage lp;
	public CustomersPage custpage;
	public SearchCustomerPage seacustpage;
	public static Logger logger;
	public Properties conprop;
	
	// created for generating random string for unique email
	public static String randomestring() {
		String generatedstring1=RandomStringUtils.randomAlphabetic(5);
		return (generatedstring1);
	}
	
	
}
