package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy ;
public class SignUpPage extends BasePage{
	
	public SignUpPage(WebDriver driver) 
	{
		
		super(driver);
	}
	
	@FindBy(xpath="//form[@action=\"/login\"]//input[@name=\"email\"]")
	WebElement loginEmail;
	@FindBy(xpath="//form[@action=\"/login\"]//input[@name=\"password\"]")
	WebElement loginPass;
	@FindBy(xpath="//form[@action='/login']//button[@type='submit']")
	WebElement bttnLogin;
	
	@FindBy(xpath="//input[@name=\"name\"]")
	WebElement inputName;
	 @FindBy(xpath="//input[@name='name']/following-sibling::input[@name='email']")
	 WebElement inputEmail;
	 @FindBy(xpath="//button[contains(text(), 'Signup')]")
	 WebElement bttnSignup;
	 @FindBy(xpath="//p[contains(text(),'Email Address already exist!')]")
	 WebElement duplicateEmail;
	 @FindBy(xpath="//*[@class='login-form']//h2")
	 WebElement txtLogin2Acct;
	 public void setName(String name) {
		 inputName.sendKeys(name);
		 
	 }
	 
	 public void setEmail(String email) {
		 inputEmail.sendKeys(email);
		 
	 }
     public void clickSignUp() {
    	 bttnSignup.click();
    	 
     }
     public void scrollScreenToLogin() {
    	 
    	 JavascriptExecutor js = (JavascriptExecutor)driver;
    	 js.executeScript("arguments[0].scrollIntoView(true)",txtLogin2Acct );
     }
     public void enterloginEmail(String emailid) {
    	
    	 loginEmail.click();
    	 loginEmail.sendKeys(emailid);
    	    	 
     }
     
     public void enterloginPass(String pass) {
    	// loginPass.click();
    	 loginPass.sendKeys(pass);
    	    	 
     }
     public void clickBttnLogin() {
    	 
    	 bttnLogin.click();
     }
	 public boolean chkduplicateEmail() {
          try {
		 return  (duplicateEmail.isDisplayed()) ;	
          }
          catch(Exception e) {
        	  return false;
          }
	 }
		
	 
     
	 
}
