package pageObjects;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AccountInfoPage extends BasePage{
	
	public AccountInfoPage(WebDriver driver) {
		
		super (driver);
	}
	
	@FindBy(id="id_gender1")
	WebElement radioMaleBttn ;
	@FindBy(id="name")
	WebElement inputName;
	@FindBy(id="email")
	WebElement inputEmail;
	@FindBy(xpath="//input[@id='password']")
	WebElement inputPassword;
	//WebELements for the clickAction
	/*
	 * @FindBy (xpath="//div[@id=\"uniform-days\"]") WebElement dateClick;
	 * 
	 * @FindBy (xpath="//div[@id=\"uniform-months\"]") WebElement monthClick;
	 * 
	 * @FindBy (xpath="//div[@id=\"uniform-years\"]") WebElement yearsClick;
	 */
	@FindBy (xpath="//div[@id='uniform-days']/select")
	WebElement datePicker;
	@FindBy (xpath="//div[@id='uniform-months']/select")
	WebElement monthPicker;
	@FindBy (xpath="//div[@id='uniform-years']/select")
	WebElement yearsPicker;
	@FindBy(xpath="//input[@id='first_name']")
	WebElement inputFirstName;
	@FindBy(xpath="//input[@id='last_name']")
	WebElement inputLastName;
	@FindBy(xpath="//input[@id='company']")
	WebElement inputCompanyName;
	@FindBy(xpath="//p[@class='required form-group']//input[@id=\"address1\"]")
	WebElement inputAddress1;
	@FindBy(xpath="//p[@class='required form-group']//select[@id=\"country\"]")
	WebElement selectCountry;
	@FindBy(xpath="//p[@class='required form-group']//input[@id=\"state\"]")
	WebElement inputState;
	@FindBy(xpath="//p[@class='required form-group']//input[@id=\"city\"]")
	WebElement inputCity;
	@FindBy(xpath="//p[@class='required form-group']//input[@id=\"zipcode\"]")
	WebElement inputZipcode;
	@FindBy(xpath="//p[@class='required form-group']//input[@id=\"mobile_number\"]")
	WebElement inputMobilenumber;
	@FindBy(xpath="//button[@type=\"submit\" and contains(text(),'Create Account')]")
    WebElement bttnCreateAcct;
	@FindBy(xpath="//*[ contains(text(),'Account Created!')]")
	WebElement acctConfirmatonMsg ;
	
	public void clickMale() {
		radioMaleBttn.click();
				
	}
	
	/*getText() → works for elements like <div>, <span>, etc. that have visible text content.
	- getAttribute("value") → works for form fields (<input>, <textarea>, <select>), because their data is stored in the value attribute.
	- Even if the input is disabled, Selenium can still read its attributes.*/

	
	public String getName() {
		 return inputName.getAttribute("value");  
		 
	 }
	public String getEmail() {
		 return inputEmail.getAttribute("value");
		 
	 }
	public void setPassword(String password) {
		
		inputPassword.sendKeys(password);
	}
	
    public void setFirstName(String fname) {
		
		inputFirstName.sendKeys(fname);
	}
 public void setLastName(String lname) {
		
		inputLastName.sendKeys(lname);
	}
 public void setCompanyName(String cname) {
		
		inputCompanyName.sendKeys(cname);
	}
  public void setAddress(String address) {
		
	 inputAddress1.sendKeys(address);
	}
 public void setState(String statename) {
		
		inputState.sendKeys(statename);
	}
 public void setCity(String city) {
		
	 inputCity.sendKeys(city);
	}
 public void setZIP(String zip) {
		
	 inputZipcode.sendKeys(zip);
	}
 public void setMobNumber(String mobNumber) {
		
	 inputMobilenumber.sendKeys(mobNumber);
	}
 public void setDate(String date) {
	
	 WebElement dateSelect = wait.until(ExpectedConditions.elementToBeClickable(datePicker));
	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateSelect);
	 datePicker.click();
	 Select selector =new Select(dateSelect);
	selector.selectByValue(date);
 }
 public void setMonth(String month) {
	 WebElement monthSelect = wait.until(ExpectedConditions.elementToBeClickable(monthPicker));
	
		    
	    // Scroll the element into view
	   // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", monthSelect);
	    
	    // Now click and select the year
	    monthSelect.click();
		 Select selector =new Select(monthSelect);
		selector.selectByVisibleText(month);
	 
 }
 public void setYear(String year) {
	    // Wait until the element is present and clickable
	    WebElement yearSelect = wait.until(ExpectedConditions.elementToBeClickable(yearsPicker));
	    
	    // Scroll the element into view
	   // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yearSelect);
	    
	    // Now click and select the year
	    yearSelect.click();
	    Select selector = new Select(yearSelect);
	    selector.selectByValue(year);
	}

 public void clickCreateAcct()
 {
	 bttnCreateAcct.click();
 }
 
 public String acctCreationConfirmation() {
	try {
		return acctConfirmatonMsg.getText();
	}
	 catch(Exception e)
	 {
		 return (e.getMessage());
	 }
 }
	
	
}
