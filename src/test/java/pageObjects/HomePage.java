package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) {
		super (driver);
	}
	
	@FindBy(xpath="//a[contains(text(),' Signup / Login')]")
	WebElement bttnSignupLogin;
	
	@FindBy(xpath="//a[@href=\"/view_cart\"]/u[contains(text(),'View Cart')]")
	WebElement bttncart;
	@FindBy(xpath="//*[@href=\"/contact_us\"]")
	WebElement bttnContactUS;
	@FindBy(xpath="//a[@href='/test_cases']")
	WebElement testCasePage;
	@FindBy(xpath="//*[@href='/products']")
	WebElement bbtnProduct;
	public void clickProducts() {
		bbtnProduct.click();
	}
	
	public void clickSignupLogin() {
		bttnSignupLogin.click();
		}
	public void clickCard() {
		bttncart.click();
		
	}
	public void clickContactUS() {
		bttnContactUS.click();
		
	}
	public void clicktestCasePage() {
		
		testCasePage.click();
	}

}
