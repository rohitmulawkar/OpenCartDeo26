package pageObjects;
import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BasePage {
	WebDriver driver ;
	WebDriverWait wait;
	Wait<WebDriver> fluentWait;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		fluentWait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class);
	}

}
