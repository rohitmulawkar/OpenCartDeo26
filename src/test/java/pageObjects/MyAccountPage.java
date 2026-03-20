package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@href='/logout']")
	WebElement bttnLogout;
	
	public void clickLogout() {
		bttnLogout.click();
		
	}
	@FindBy(xpath="//*[@href=\"/delete_account\"]")
	WebElement bttnDeleteAcct;
	public boolean  isMyAccountExists()
	{
		return bttnDeleteAcct.isDisplayed();
		
	}
}
