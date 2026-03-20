package pageObjects;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUSPage extends BasePage {

	public ContactUSPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[contains(text(),\"Get In Touch\")]")
	WebElement txt_getInTOuch;
	@FindBy(xpath = "//input[@name=\"name\"]")
	WebElement input_Name;
	@FindBy(xpath = "//input[@name='email']")
	WebElement input_email;
	@FindBy(xpath = "xpath=\"//input[@name='subject']\"")
	WebElement subject;
	@FindBy(xpath = "//textarea[@id=\"message\"]")
	WebElement input_message;
	@FindBy(xpath = "//input[@name=\"submit\"]")
	WebElement bttn_Submit;
	@FindBy(xpath = "//input[@name=\"upload_file\"]")
	WebElement upload_file;

	public boolean checkGetinTouch() {
		return txt_getInTOuch.isDisplayed();

	}

	public void enterName(String name) {
		input_Name.sendKeys(name);
	}

	public void enterEmail(String email) {
		input_email.sendKeys(email);
	}

	public void Entersubject(String sub) {
		subject.sendKeys(sub);
	}

	public void enterMsg(String msg) {
		input_message.sendKeys(msg);
	}

	public void clickSubmit() {
		bttn_Submit.click();
	}

	public void uploadFile() {
		String filePath = new File("C:\\Users\\Admin\\eclipse-workspace\\OpenCartDeo26\\testData\\file.txt")
				.getAbsolutePath();
		// Use sendKeys to send the file path
		upload_file.sendKeys(filePath);

	}

}
