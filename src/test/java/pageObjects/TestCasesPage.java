package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasesPage extends BasePage{
	
	public TestCasesPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//b[contains(text(),'Test Cases')]")
	WebElement txt_TestCase;
	
	
	public boolean  isTestPageOpen()
	{
		return txt_TestCase.isDisplayed();
		
	}
}
