package testCases;
import TestBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	
	@Test (groups="sanity")
   @Parameters({"chrome","windows"})
	public void verify_login()
	{ 	
		logger.info("*** Starting TC002_LoginTest*******");
		HomePage hp=new HomePage(driver);
		hp.clickSignupLogin();
		SignUpPage sp= new SignUpPage(driver);
		sp.enterloginEmail(p.getProperty("email"));
		sp.enterloginPass(p.getProperty("password"));
		sp.clickBttnLogin();
		logger.info("************Clicked on the loginBttn*******");
		MyAccountPage hpl=new MyAccountPage(driver);
		Assert.assertTrue(hpl.isMyAccountExists());
		logger.info("*** Finished  TC002_LoginTest*******");
		MyAccountPage macp=new MyAccountPage(driver);
		macp.clickLogout();
	}

}
