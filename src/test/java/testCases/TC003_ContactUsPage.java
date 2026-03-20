package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.ContactUSPage;
import pageObjects.HomePage;

public class TC003_ContactUsPage extends BaseClass {
@Test
	public void verify_ContactUS () {
	
	logger.info("*** Starting TC003_ContactUsPage*******");
	HomePage hp=new HomePage(driver);
	hp.clickContactUS();
	ContactUSPage cntcPage=new ContactUSPage(driver);
	Assert.assertTrue(cntcPage.checkGetinTouch(), "GetinTOuchVErified");
	
	cntcPage.enterName("Rajaesh");
	cntcPage.enterEmail("raja@gmail.com");
	cntcPage.Entersubject("Subject");
	cntcPage.enterMsg("The Subject is to ");  
	cntcPage.uploadFile();
	cntcPage.clickSubmit();
}
	
}
