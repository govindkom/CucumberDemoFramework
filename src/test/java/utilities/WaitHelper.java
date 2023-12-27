package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	public WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void waitForElement(WebElement element,Duration timeInOutSeconds) {
		WebDriverWait wait=new WebDriverWait(driver, timeInOutSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	


}
