package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.SignUpPage;
import pageObjects.AccountInfoPage;
import pageObjects.HomePage;
import org.testng.asserts.SoftAssert; 
public class TC001_AccountSignUp extends BaseClass {
	@Test (groups="sanity")
	public void verify_acct_opening() {
		
		logger.info("****Starting TC001_AccountSignUp  *****");
		 SoftAssert softAssert = new SoftAssert();
		try {
			//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickSignupLogin();
		logger.info("clicked on SignUpLogin");
		//SignUpPage
		SignUpPage sp = new SignUpPage(driver);
		sp.setName(p.getProperty("name"));
		String rEmail=randomString("rohit");
		sp.setEmail(rEmail);
		sp.clickSignUp();
		logger.info("clicked on SignUpLogin");
		logger.info("**Check if Email is already exists******");
	     softAssert.assertFalse(sp.chkduplicateEmail());
		logger.debug("Line Number 30");
		//AccountInfoPage
		AccountInfoPage acctInfo = new AccountInfoPage(driver);
		logger.debug("Line Number 30");
		acctInfo.clickMale();
		softAssert.assertEquals(acctInfo.getName(), p.getProperty("name"));
		logger.info("***********Checking the Email entered and showing is same**********");
		softAssert.assertEquals(acctInfo.getEmail(),rEmail);
	   // Assert.assertEquals(email,rEmail );
		acctInfo.setPassword("Rohit");
		acctInfo.setDate("3");
		logger.info("Entering Month");
		acctInfo.setMonth("March");
		//acctInfo.clickyear();
		acctInfo.setYear("2010");
		acctInfo.setFirstName("rohit");
		acctInfo.setLastName("M");
		acctInfo.setCompanyName("google");
		acctInfo.setAddress("Pune");
		acctInfo.setState("Maharashtra");
		acctInfo.setCity("Mumbai");
		acctInfo.setZIP("400587");
		acctInfo.setMobNumber("91994998898");
		acctInfo.clickCreateAcct();
		String successMsg = acctInfo.acctCreationConfirmation();
       Assert.assertEquals(successMsg, "ACCOUNT CREATED!","Congrats Account Created");
       softAssert.assertAll();
		System.out.println("successMsg");
		}
		catch(Exception e) {
			
		logger.error("Test Failed");
		logger.debug("Debug Logs *****");
		Assert.fail(e.getMessage());
		System.out.println(e.getMessage());
		}
		logger.info("****Finished TC001_AccountSignUp  *****");
	}	

}
